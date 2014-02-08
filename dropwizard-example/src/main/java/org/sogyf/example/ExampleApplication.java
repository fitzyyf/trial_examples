package org.sogyf.example;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.skife.jdbi.v2.DBI;
import org.sogyf.example.dao.ResourceDAO;
import org.sogyf.example.health.ExampleHealthCheck;
import org.sogyf.example.resources.ExampleResource;
import org.sogyf.example.resources.ResourceResource;

public class ExampleApplication extends Application<ExampleConfiguration> {
    public static void main(String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "example";
    }

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<ExampleConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(ExampleConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(ExampleConfiguration configuration,
                    Environment environment) {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi;
        try {
            jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        final ResourceDAO dao = jdbi.onDemand(ResourceDAO.class);

        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.jersey().register(new ExampleResource(template, defaultName));
        environment.jersey().register(new ResourceResource(dao));
        environment.healthChecks().register("template", new ExampleHealthCheck(template));
    }
}
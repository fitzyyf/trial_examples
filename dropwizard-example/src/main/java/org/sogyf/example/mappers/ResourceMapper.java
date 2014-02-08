/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013-2014 sagyf Yang. The Four Group.
 */

package org.sogyf.example.mappers;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.sogyf.example.model.Resource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>
 * .
 * </p>
 *
 * @author sagyf yang
 * @version 1.0 2014-02-08 22:46
 * @since JDK 1.6
 */
public class ResourceMapper implements ResultSetMapper<Resource> {
    @Override
    public Resource map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Resource(resultSet.getLong("id"), resultSet.getString("name"));
    }
}

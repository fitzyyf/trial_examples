/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013-2014 sagyf Yang. The Four Group.
 */

package org.sogyf.example.resources;

import org.sogyf.example.dao.ResourceDAO;
import org.sogyf.example.model.Resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <p>
 * .
 * </p>
 *
 * @author sagyf yang
 * @version 1.0 2014-02-08 22:40
 * @since JDK 1.6
 */
@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class ResourceResource {
    private final ResourceDAO personDAO;

    public ResourceResource(ResourceDAO dao) {
        this.personDAO = dao;
    }

    @GET
    public List<Resource> list() {
        return personDAO.findAll();
    }

}

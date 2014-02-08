/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013-2014 sagyf Yang. The Four Group.
 */

package org.sogyf.example.dao;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.sogyf.example.mappers.ResourceMapper;
import org.sogyf.example.model.Resource;

import java.util.List;

/**
 * <p>
 * .
 * </p>
 *
 * @author sagyf yang
 * @version 1.0 2014-02-08 21:28
 * @since JDK 1.6
 */
@RegisterMapper(ResourceMapper.class)
public interface ResourceDAO {

    @SqlQuery("SELECT id, name, type, path, action FROM res")
    List<Resource> findAll();
}

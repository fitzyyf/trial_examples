/*
 * Copyright (c) 2012-2012 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by Ifly@ZY team.
 * Software code and design for the team, copy rights reserved.
 */

package com.iflytek.train.ws.impl;

import javax.jws.WebService;

import com.iflytek.train.ws.OrderWebService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * .
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-12-27 1:20 PM
 * @since JDK 1.5
 */
@WebService(endpointInterface = "com.iflytek.train.ws.OrderWebService")
@Service("orderWebService")
public class OrderWebServiceImpl implements OrderWebService {
	@Override
	public void submitOrder() {
		System.out.println("submitOrder");
	}
}

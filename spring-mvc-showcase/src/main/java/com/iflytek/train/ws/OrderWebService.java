/*
 * Copyright (c) 2012-2012 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by Ifly@ZY team.
 * Software code and design for the team, copy rights reserved.
 */

package com.iflytek.train.ws;

import javax.jws.WebService;

/**
 * <p>
 * .
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-12-27 1:20 PM
 * @since JDK 1.5
 */
@WebService
public interface OrderWebService {

	/**
	 * 模拟提交订单
	 */
	public void submitOrder();
}

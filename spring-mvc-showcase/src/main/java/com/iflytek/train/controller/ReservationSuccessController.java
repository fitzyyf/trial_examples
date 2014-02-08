/*
 * Copyright (c) 2012-2012 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by Ifly@ZY team.
 * Software code and design for the team, copy rights reserved.
 */

package com.iflytek.train.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * .
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-12-26 11:55 PM
 * @since JDK 1.5
 */
@Controller
public class ReservationSuccessController {
	// Method is bound directly to URL /reservationSuccess
	@RequestMapping("/reservationSuccess")
	public String reservationSuccess() {
		// Return view reservationSuccess. Via resolver the view
		// will be mapped to /WEB-INF/jsp/reservationSuccess.jsp
		return "reservationSuccess";
	}
}

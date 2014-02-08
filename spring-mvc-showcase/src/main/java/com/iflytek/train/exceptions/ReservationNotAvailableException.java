/*
 * Copyright (c) 2012-2012 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by Ifly@ZY team.
 * Software code and design for the team, copy rights reserved.
 */

package com.iflytek.train.exceptions;

import java.util.Date;

/**
 * <p>
 * .
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-12-26 10:17 PM
 * @since JDK 1.5
 */
public class ReservationNotAvailableException extends RuntimeException {


	public static final long serialVersionUID = 1L;
	private String courtName;
	private Date date;
	private int hour;

	public ReservationNotAvailableException(String courtName, Date date, int hour) {
		this.courtName = courtName;
		this.date = date;
		this.hour = hour;
	}

	public String getCourtName() {
		return courtName;
	}

	public Date getDate() {
		return date;
	}

	public int getHour() {
		return hour;
	}
}
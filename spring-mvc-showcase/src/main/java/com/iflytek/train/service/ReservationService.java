/*
 * Copyright (c) 2012-2012 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by Ifly@ZY team.
 * Software code and design for the team, copy rights reserved.
 */

package com.iflytek.train.service;

import com.iflytek.train.domain.PeriodicReservation;
import com.iflytek.train.domain.Reservation;
import com.iflytek.train.exceptions.ReservationNotAvailableException;

/**
 * <p>
 * .
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-12-26 10:17 PM
 * @since JDK 1.5
 */
public interface ReservationService {


	public void make(Reservation reservation)
			throws ReservationNotAvailableException;

	public void makePeriodic(PeriodicReservation periodicReservation)
			throws ReservationNotAvailableException;
}

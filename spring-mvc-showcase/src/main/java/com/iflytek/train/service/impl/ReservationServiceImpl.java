/*
 * Copyright (c) 2012-2012 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by Ifly@ZY team.
 * Software code and design for the team, copy rights reserved.
 */

package com.iflytek.train.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.iflytek.train.domain.PeriodicReservation;
import com.iflytek.train.domain.Player;
import com.iflytek.train.domain.Reservation;
import com.iflytek.train.domain.SportType;
import com.iflytek.train.exceptions.ReservationNotAvailableException;
import com.iflytek.train.service.ReservationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * .
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-12-26 10:18 PM
 * @since JDK 1.5
 */
@Service
public class ReservationServiceImpl implements ReservationService {

	public static final SportType TENNIS = new SportType(1, "Tennis");
	public static final SportType SOCCER = new SportType(2, "Soccer");
	private List<Reservation> reservations;

	public ReservationServiceImpl() {
		reservations = new ArrayList<Reservation>();
		reservations.add(new Reservation("Tennis #1",
				new GregorianCalendar(2012, 0, 14).getTime(), 16,
				new Player("Roger", "N/A"), TENNIS));
		reservations.add(new Reservation("Tennis #2",
				new GregorianCalendar(2012, 0, 14).getTime(), 20,
				new Player("James", "N/A"), TENNIS));
	}


	@Override
	public void makePeriodic(PeriodicReservation periodicReservation)
			throws ReservationNotAvailableException {

		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(periodicReservation.getFromDate());

		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(periodicReservation.getToDate());

//		while (fromCalendar.before(toCalendar)) {
//			Reservation reservation = new Reservation();
//			reservation.setCourtName(periodicReservation.getCourtName());
//			reservation.setDate(fromCalendar.getTime());
//			reservation.setHour(periodicReservation.getHour());
//			reservation.setPlayer(periodicReservation.getPlayer());
//			make(reservation);
//
//			fromCalendar.add(Calendar.DATE, periodicReservation.getPeriod());
//		}
	}

	@Override
	public void make(Reservation reservation)
			throws ReservationNotAvailableException {
//		for (Reservation made : reservations) {
//			if (made.getCourtName().equals(reservation.getCourtName())
//					&& made.getDate().equals(reservation.getDate())
//					&& made.getHour() == reservation.getHour()) {
//				throw new ReservationNotAvailableException(reservation
//						.getCourtName(), reservation.getDate(), reservation
//						.getHour());
//			}
//		}
		reservations.add(reservation);
	}
}

/*
 * Copyright (c) 2012-2012 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by Ifly@ZY team.
 * Software code and design for the team, copy rights reserved.
 */

package com.iflytek.train.service;

import com.iflytek.train.domain.PeriodicReservation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * <p>
 * 向导控制器，校验表单数据.
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-12-26 10:31 PM
 * @since JDK 1.5
 */
@Component
public class PeriodicReservationValidator implements Validator {
	@Override
	public boolean supports(Class clazz) {
		return PeriodicReservation.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		validateCourt(target, errors);
		validateTime(target, errors);
		validatePlayer(target, errors);
	}

	public void validateCourt(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courtName",
				"required.courtName", "Court name is required.");
	}

	public void validateTime(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "fromDate",
				"required.fromDate", "From date is required.");
		ValidationUtils.rejectIfEmpty(errors, "toDate", "required.toDate",
				"To date is required.");
		ValidationUtils.rejectIfEmpty(errors, "period",
				"required.period", "Period is required.");
		ValidationUtils.rejectIfEmpty(errors, "hour", "required.hour",
				"Hour is required.");
	}

	public void validatePlayer(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "player.name",
				"required.playerName", "Player name is required.");
	}
}

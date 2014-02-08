/*
 * Copyright (c) 2012-2012 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by Ifly@ZY team.
 * Software code and design for the team, copy rights reserved.
 */

package com.iflytek.train.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iflytek.train.domain.PeriodicReservation;
import com.iflytek.train.domain.Player;
import com.iflytek.train.service.PeriodicReservationValidator;
import com.iflytek.train.service.ReservationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;

/**
 * <p>
 * 向导控制器.
 * </p>
 * <p/>
 * 对于一个向导控制器，不同页面中的所有表单字段都绑定到单一的模式属性Reservation对象中
 * ，在多个请求期间存储在用户的会话中
 *
 * @author poplar.yfyang
 * @version 1.0 2012-12-26 9:56 PM
 * @since JDK 1.5
 */
@Controller
@RequestMapping("/periodicReservationForm")
//可以使用SessionStatus对象进行删除。
@SessionAttributes("reservation")
public class PeriodicReservationController {


	private final ReservationService reservationService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	public PeriodicReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	/**
	 * 用于加载第一个表单视图，并初始化玩家和预订信息对象
	 *
	 * @param model ui model
	 * @return 第一个表单页面视图
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		PeriodicReservation reservation = new PeriodicReservation();
		reservation.setPlayer(new Player());
		model.addAttribute("reservation", reservation);
		return "/reservationCourtForm";
	}

	/**
	 * 处理三个不同的表单页面
	 *
	 * @param request     HttpServletRequest
	 * @param reservation 预订信息
	 * @param result      校验结果
	 * @param status      session状态对象，用于处理完成后删除session中的信息
	 * @param currentPage 当前页面索引
	 * @param model       ui model
	 * @return 视图
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
			HttpServletRequest request,
			@RequestParam(value = "_cancel",required = false) String cancel,
			@RequestParam(value =  "_finish",required = false) String finish,
			@ModelAttribute("reservation") PeriodicReservation reservation,
			BindingResult result, SessionStatus status,
			@RequestParam("_page") int currentPage, Model model) {
		//定义一个map，关联页面号和视图名称
		Map<Integer, String> pageForms = new HashMap<Integer, String>();
		pageForms.put(0, "/reservationCourtForm");// Mapped to /WEB-INF/ftl/reservationCourtForm.ftl
		pageForms.put(1, "/reservationTimeForm");// Mapped to /WEB-INF/ftl/reservationTimeForm.ftl
		pageForms.put(2, "/reservationPlayerForm");// Mapped to /WEB-INF/ftl/reservationPlayerForm.ftl

		if (StringUtils.isNotEmpty(cancel)) {
			//返回到制定的页面号对应的视图中
			return pageForms.get(currentPage);
		} else if (StringUtils.isNotEmpty(finish)) {
			//如果用户点击了完成预订 按钮，则意味者执行业务方法进行处理
			new PeriodicReservationValidator().validate(reservation, result);
			if (!result.hasErrors()) {
				reservationService.makePeriodic(reservation);
				//完成状态用户会话，执行这个函数后，会自动将@SessionAttribute中存储的数据删除
				status.setComplete();
				//重定向
				return "redirect:reservationSuccess";
			} else {
				//
				return pageForms.get(currentPage);
			}
		} else {
			//从 _target0-x中取出页面索引号
			int targetPage = WebUtils.getTargetPage(request, "_target", currentPage);
			//判定点击了是上一步还是下一步
			if (targetPage < currentPage) {
				return pageForms.get(targetPage);
			}
			switch (currentPage) {
				case 0:
					new PeriodicReservationValidator().validateCourt(reservation, result);
					break;
				case 1:
					new PeriodicReservationValidator().validateTime(reservation, result);
					break;
				case 2:
					new PeriodicReservationValidator().validatePlayer(reservation, result);
					break;
			}
			if (!result.hasErrors()) {
				return pageForms.get(targetPage);
			} else {
				return pageForms.get(currentPage);
			}
		}
	}


	/**
	 * modelAttribute 注解用于定义全局模式属性，这种属性对处理程序方法中返回的任意视图可用。
	 * @return 信息
	 */
	@ModelAttribute("periods")
	public Map<Integer, String> periods() {
		Map<Integer, String> periods = new HashMap<Integer, String>();
		periods.put(1, "Daily");
		periods.put(7, "Weekly");
		return periods;
	}
}

package com.spring.starter.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.starter.models.Users;
import com.spring.starter.user.dao.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated Users user, Model model) {

		System.out.println(userService.fetchAllUsers());

		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		return "user";
	}
}
package com.example.mvc.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.mvc.exception.CustomException;

//Will apply advice to every class that has @controller
@ControllerAdvice(annotations = Controller.class)
public class GlobalControllerAdvice {

	// Current date is available in every controller now
	@ModelAttribute("currentDate")
	public Date getCurrentDate() {
		return new Date();
	}

	// Made ProjectValidator global
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(binder.getValidator());

	}

	// if controller throws custom exception this will get triggered
	@ExceptionHandler(CustomException.class)
	public String handleError() {
		return "controller_error";
	}
}

package com.neu.ghost.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.ghost.pojo.Employer;

@RequestMapping(value ="/addEmployer.htm")
public class ToEmployer {
	@RequestMapping(method = RequestMethod.GET)
	public String search() {

		return "success";
	}
	
}

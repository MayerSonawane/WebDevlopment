package com.neu.ghost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.ghost.DAO.ApplicantDAO;
import com.neu.ghost.DAO.EmployerDAO;
import com.neu.ghost.exception.AdException;
import com.neu.ghost.pojo.Applicant;
import com.neu.ghost.pojo.Employer;

@Controller

public class AddApplicantController {
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/addApplicant.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("applicant") Applicant applicant, BindingResult result) throws Exception {
		validator.validate(applicant, result);
		if (result.hasErrors()) {
			return "addApplicant";
		}

		try {
			System.out.print("test");
			ApplicantDAO applicantDAO = new ApplicantDAO();
			System.out.print("test1");
		
			applicantDAO.createApplicant(applicant.getApplicantId(), applicant.getApplicantTitle(), applicant.getName(), applicant.getPassword(), applicant.getEmail().getEmailId(), applicant.getFirstName(), applicant.getLastName(), applicant.getAddress());
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedApplicant";
	}
	
	@RequestMapping(value="/addApplicant.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("applicant") Applicant applicant, BindingResult result) {

		return "addApplicant";
	}
	
	
}

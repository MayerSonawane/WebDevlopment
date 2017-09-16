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

import com.neu.ghost.DAO.EmployerDAO;
import com.neu.ghost.exception.AdException;
import com.neu.ghost.pojo.Employer;
import com.neu.ghost.pojo.User;
import com.neu.ghost.controller.UserValidator;

@Controller
@RequestMapping("/addEmployer.htm")
public class AddEmployerController {
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("employer") Employer employer, BindingResult result) throws Exception {
		validator.validate(employer, result);
		if (result.hasErrors()) {
			return "addEmployer";
		}

		try {
			System.out.print("test");
			EmployerDAO employerDAO = new EmployerDAO();
			System.out.print("test1");
		
			employerDAO.createEmployer(employer.getEmployerName(),employer.getEmployerType(),employer.getEmployerDesc(),employer.getName(), employer.getPassword(), employer.getEmail().getEmailId(), employer.getFirstName(), employer.getLastName(),employer.getAddress());
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedEmployer";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("employer") Employer employer) {

		return "addEmployer";
	}
	
}

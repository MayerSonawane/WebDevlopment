package com.neu.ghost.controller;

import com.neu.ghost.pojo.User;
import com.neu.ghost.pojo.Employer;
import com.neu.ghost.pojo.Applicant;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;
@Component
public class UserValidator implements Validator {
 String flag;
    public boolean supports(Class aClass)
    {
    	if(aClass.equals(Employer.class)){
    		flag = "Employer";
    		return true;
    	}else if(aClass.equals(Applicant.class)){
    		flag = "Applicant";
    		return true;
    	}
        return false;
    }

    public void validate(Object obj, Errors errors)
    {
    	if(flag == "Employer"){
        Employer employer = (Employer) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employerName", "error.invalid.employer", "Employer Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employerType", "error.invalid.employer", "Employer Type Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employerDesc", "error.invalid.employer", "Employer Description Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.employer", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.employer", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.employer", "Address Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.employer", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.employer", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailId", "error.invalid.email.emailId", "Email Required");
    	}else if(flag == "applicant"){
    		Applicant applicant = (Applicant) obj;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "applicantTitle", "error.invalid.applicant", "Applicant Title Required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.applicant", "First Name Required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.applicant", "Last Name Required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.applicant", "Address Required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.applicant", "User Name Required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.applicant", "Password Required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailId", "error.invalid.email.emailId", "Email Required");
        		
    		
    		
    	}
    }
}

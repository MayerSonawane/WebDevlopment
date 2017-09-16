package com.neu.ghost.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.ghost.exception.AdException;
import com.neu.ghost.pojo.Applicant;
import com.neu.ghost.pojo.Email;
import com.neu.ghost.pojo.User;

public class ApplicantDAO extends DAO {

	public ApplicantDAO(){}
	
	public Applicant getApplicant(String applicantName)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Applicant where applicantName = :applicantName");
            q.setString("applicantName", applicantName);
            Applicant applicant = (Applicant) q.uniqueResult();
            commit();
            return applicant;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get applicant " + applicantName, e);
        }
    }
	
	 public Applicant createApplicant(long applicantId, String applicantTitle, String username, String password,String emailId, String firstName, String lastName, String address)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	            Email email=new Email(emailId);
	            Applicant applicant=new Applicant(applicantId, applicantTitle);
	            
	            applicant.setFirstName(firstName);
	            applicant.setLastName(lastName);
	            applicant.setAddress(address);
	            
	            applicant.setEmail(email);
	            
	            email.setUser((User)applicant);
	            
	            getSession().save(applicant);
	            
	            commit();
	            return applicant;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            throw new AdException("Exception while creating user: " + e.getMessage());
	        }
	    }
	 
	 public void deleteApplicant(Applicant applicant)
	            throws AdException {
	        try {
	            begin();
	            getSession().delete(applicant);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete user " + applicant.getName(), e);
	        }
	    }
}

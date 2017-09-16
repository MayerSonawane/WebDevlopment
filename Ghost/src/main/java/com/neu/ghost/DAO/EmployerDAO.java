package com.neu.ghost.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.ghost.exception.AdException;
import com.neu.ghost.pojo.Email;
import com.neu.ghost.pojo.Employer;
import com.neu.ghost.pojo.User;

public class EmployerDAO extends DAO {
	
	public EmployerDAO(){}
	
	 public Employer getEmployer(String employerName)
	            throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Employer where employerName = :employerName");
	            q.setString("employerName", employerName);
	            Employer employer = (Employer) q.uniqueResult();
	            commit();
	            return employer;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get employer " + employerName, e);
	        }
	    }

	    public Employer createEmployer(String employerName, String employerType, String employerDesc, String username, String password,String emailId, String firstName, String lastName, String address)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	            Email email=new Email(emailId);
	            
	            Employer employer = new Employer(employerName, employerType, employerDesc);
	            
	            //User user=new User(username,password);
	            
	            employer.setFirstName(firstName);
	            employer.setLastName(lastName);
	            employer.setAddress(address);
	            
	            employer.setEmail(email);
	            
	            email.setUser((User)employer);
	            
	            
	            
	            
	            
	        
	            
	            getSession().save(employer);
	            
	            commit();
	            return employer;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create employer " + username, e);
	            throw new AdException("Exception while creating employer: " + e.getMessage());
	        }
	    }

	    public void deleteEmployer(Employer employer)
	            throws AdException {
	        try {
	            begin();
	            getSession().delete(employer);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete employer " + employer.getName(), e);
	        }
	    }

}

package com.neu.ghost.DAO;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.neu.ghost.exception.AdException;
import com.neu.ghost.pojo.Applicant;
import com.neu.ghost.pojo.Email;
import com.neu.ghost.pojo.Job;
import com.neu.ghost.pojo.User;

public class JobDAO extends DAO {
	
	 @Autowired
	 Job job;
	 
	public JobDAO(){}
	
	public Job getJob(String jobTitle) throws AdException{
		
		try{
			begin();
			Query q = getSession().createQuery("from Job where jobTitle = :jobTitle");
			q.setString("jobTitle", jobTitle);
			Job job = (Job) q.uniqueResult();
			commit();
			return job;
			
		}catch(HibernateException e){
			rollback();
			throw new AdException("could not get job"+ jobTitle, e);
			
		}
	}
	
	 public Job createJob(String jobTilte, String jobDesc)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside JobDAO");
	            
	           
	            job.setJobTitle("jobTitle");
	            job.setJobDesc("jobDesc");
	            
	            getSession().save(job);
	            
	            commit();
	            return job;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create job " + job.getJobTitle, e);
	            throw new AdException("Exception while creating JOb: " + e.getMessage());
	        }
	    }
	 
	 public void deleteJob(Job job)
	            throws AdException {
	        try {
	            begin();
	            getSession().delete(job);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete job " + job.getJobTitle(), e);
	        }
	 }

}

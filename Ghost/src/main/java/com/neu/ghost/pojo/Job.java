package com.neu.ghost.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Job")
public class Job {
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name  = "jobId", unique = true, nullable = false)
	private long jobId;
	
	@Column(name = "jobTitle")
	private String jobTitle;
	
	@Column(name = "jobDesc")
	private String jobDesc;
	
	public Job(){}
	
	  public long getJobId() {
	        return jobId;
	    }

	    public void setJobId(long jobId) {
	        this.jobId = jobId;
	    }

	    public String getJobTitle() {
	        return jobTitle;
	    }

	    public void setJobTitle(String jobTitle) {
	        this.jobTitle = jobTitle;
	    }

	    public String getJobDesc() {
	        return jobDesc;
	    }

	    public void setJobDesc(String jobDesc) {
	        this.jobDesc = jobDesc;
	    }
		
	

}

package com.neu.ghost.pojo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Aplicant")

@PrimaryKeyJoinColumn(name = "personID")
public class Applicant extends User {
	
	@Column(name = "applicantId")
	private long applicantId;
	
	@Column(name = "applicantTitle")
	private String applicantTitle;
	
	@Autowired
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "applicant", cascade = CascadeType.ALL)
	private ArrayList<Job> jobList;
	
	//private String applicantRole;
	//private String applicantSalary;
	

	public Applicant(){}
	
	public Applicant(long applicantId, String applicantTitle){
		this.applicantId = applicantId;
		this.applicantTitle = applicantTitle;
	}

    public ArrayList<Job> getJobList() {
        return jobList;
    }

    public void setJobList(ArrayList<Job> jobList) {
        this.jobList = jobList;
    }
	
	
	 	public long getApplicantId() {
	        return applicantId;
	    }

	    public void setApplicantId(long applicantId) {
	        this.applicantId = applicantId;
	    }

	    public String getApplicantTitle() {
	        return applicantTitle;
	    }

	    public void setApplicantTitle(String applicantTitle) {
	        this.applicantTitle = applicantTitle;
	    }
}

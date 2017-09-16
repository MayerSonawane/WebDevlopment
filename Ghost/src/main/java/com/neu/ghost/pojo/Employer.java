package com.neu.ghost.pojo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Employer")

public class Employer extends User {
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "employerId")
	private long employerId;
	
	@Column(name = "employerName")
	private String employerName;
	
	@Column(name = "employerType")
	private String employerType;
	
	@Column(name = "employerDesc")
	private String employerDesc;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "employer", cascade = CascadeType.ALL)
    private Email email;
	
	
	@Autowired
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employer", cascade = CascadeType.ALL)
	private ArrayList<Job> jobList;

	public Employer(){}
	
	
	public Employer ( String employerName, String employerType, String employerDesc){
		//this.employerId = employerId;
		this.employerName = employerName;
		this.employerType = employerType;
		this.employerDesc = employerDesc;
		//User user = user(username, Password, email);
		
	}

    public ArrayList<Job> getJobList() {
        return jobList;
    }

    public void setJobList(ArrayList<Job> jobList) {
        this.jobList = jobList;
    }
	
    
    public Email getEmail(){ 
    return email;
    }
        
    public void setEmail(Email email){
        this.email = email;
    }
        
	public long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(long employerId) {
        this.employerId = employerId;
    }
    
    public String getEmployerName() {
        return employerType;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerType() {
        return employerType;
    }

    public void setEmployerType(String employerType) {
        this.employerType = employerType;
    }

    public String getEmployerDesc() {
        return employerDesc;
    }

    public void setEmployerDesc(String employerDesc) {
        this.employerDesc = employerDesc;
    }
	
}

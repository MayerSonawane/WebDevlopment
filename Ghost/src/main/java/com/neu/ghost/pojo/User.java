package com.neu.ghost.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.neu.ghost.pojo.Email;
import com.neu.ghost.pojo.Person;

@Entity
@Table(name = "User")
@PrimaryKeyJoinColumn(name = "personID")
public class User extends Person{
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "password", nullable = false)
    private String password;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "email", nullable = false)
    private Email email;
	

    public User(String name, String password, Email email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


	public Email getEmail() {
		return email;
		
	}

	public void setEmail(Email email) {
		this.email = email;
	}

}

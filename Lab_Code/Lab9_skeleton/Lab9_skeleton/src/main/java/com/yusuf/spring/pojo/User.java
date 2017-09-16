package com.yusuf.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity // entity in Db
@Table(name="User")// table name in DB
@PrimaryKeyJoinColumn(name="personID") // this the foreign key which is PK in Person

public class User extends Person{
	
	@Column(name="name")
    private String name;
	
	@Column(name="password")
    private String password;
	
	@OneToOne(fetch= FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL ) // for one to one is bydefault is EAGER. 
    private Email email;
	

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    User() {
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
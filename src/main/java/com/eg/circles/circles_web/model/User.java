package com.eg.circles.circles_web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user",uniqueConstraints={@UniqueConstraint(columnNames={"login"})})
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String login;
	private String password;
	private Boolean isAdm;
	
	User(){}
	
	public User(String login,String password){
		this.login = login;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public Boolean getIsAdm() {
		return isAdm;
	}

}

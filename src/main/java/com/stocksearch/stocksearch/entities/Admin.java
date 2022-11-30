package com.stocksearch.stocksearch.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_form")
public class Admin {

	@Id
	private Integer login_id;
	private String username;
	private String password;
	private String role;
	public Admin(Integer login_id, String username, String password, String role) {
		super();
		this.login_id = login_id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Admin() {
		super();
	}
	public Integer getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Admin [login_id=" + login_id + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
	
}

package com.mvnWeb.shiro.model;

import javax.persistence.Entity;

@Entity
public class Sys_user {
	private String id;
	private String usercode;
	private String username;
	private String password;
	private String salt;
	private Character locked;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Character getLocked() {
		return locked;
	}
	public void setLocked(Character locked) {
		this.locked = locked;
	}
	@Override
	public String toString() {
		return "Sys_user [id=" + id + ", usercode=" + usercode + ", username=" + username + ", password=" + password
				+ ", salt=" + salt + ", locked=" + locked + "]";
	}
}

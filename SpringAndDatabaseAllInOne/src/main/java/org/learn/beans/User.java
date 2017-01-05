package org.learn.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
	String username;
	String password;

	public String getUsername() {
		return username;
	}

	@Autowired
	public void setUsername(@Value("${jdbc.username}") String username) {
		this.username = username;
	}

	// Following non-autowired version
	/*
	 * public void setUsername(String username) { this.username = username; }
	 */
	public String getPassword() {
		return password;
	}

	@Autowired
	public void setPassword(@Value("${jdbc.username}")String password) {
		this.password = password;
	}
	// Following non-autowired version
	/*public void setPassword(String password) {
		this.password = password;
	}*/

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}

package org.rest.service.swipe.common;

public class User {
	private String firstName;
	private String lastName;

	
	public User(String name, String className) {
		this.firstName = name;
		this.lastName = className;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	public String getClassName() {
		return lastName;
	}

	public void setClassName(String className) {
		this.lastName = className;
	}
}

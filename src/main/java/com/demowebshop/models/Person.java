package com.demowebshop.models;

public class Person {

	public String firstName, lastName, email, password, confirmPassword;

	public Person(String firstName, String lastName, String email, String password, String confirmPassword) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", confirmPassword=" + confirmPassword + "]";
	}
	
	
	
	
	
}

package com.example.dto;

import org.springframework.stereotype.Component;

/**
 * Holds the details of an user
 * @author kumareshkaruppusamy
 */
@Component
public class User {
	private int id;
	private String name;
	User() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
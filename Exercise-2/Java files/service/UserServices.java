package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.User;

@Service
public class UserServices {
	@Autowired
	private User user;
	
	public User createUser(int id, String name) {
		user.setId(id);
		user.setName(name);
		return user;
	}
}

package com.example.demo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("uservices")
@Transactional
public class UserServices implements UserServicesInterface{
	
	@Autowired
	private UserDAO dao;
	
	@Override
	public void createUser(User user) {
		dao.save(user);
	}
	
	@Override
	public User getUser(String id) {
		Optional<User> user  = dao.findById(id);
		return user.get();
	}

	@Override
	public void updateUserAmount(User user) {
		dao.updateAmount(user.getAmount(), user.getUserid());
	}
	
}

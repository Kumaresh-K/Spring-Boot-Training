package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String>{
	
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Transactional
	@Query("update User u set u.amount=?1 where u.userid=?2")
	public void updateAmount(int amount, String userId);
}

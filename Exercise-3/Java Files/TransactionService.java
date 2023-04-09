package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("ts")
@Transactional
public class TransactionService {
	@Autowired
	private UserServices us;
	
	@Transactional(propagation= Propagation.SUPPORTS)
	void creditAmount(String creditUserId, int amount ) {
		User user = us.getUser(creditUserId);
		user.setAmount(user.getAmount() + amount);
		us.updateUserAmount(user);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = {InsufficientBalanceException.class})
	void debitAmount(String debitUserId, int amount ) throws InsufficientBalanceException{
		User user = us.getUser(debitUserId);
		if(user.getAmount() < amount)
			throw new InsufficientBalanceException("Insufficient Balance...");
		user.setAmount(user.getAmount() - amount);
		us.updateUserAmount(user);
	}	
}

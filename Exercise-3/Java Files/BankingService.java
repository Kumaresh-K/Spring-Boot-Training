package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bs")
@Transactional
public class BankingService {
	
	@Autowired
	private TransactionService ts;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void transferAmount(String creditUserId, String debitUserId, int amount) throws InsufficientBalanceException{
		ts.debitAmount(debitUserId, amount);
		ts.creditAmount(creditUserId, amount);
	}
}

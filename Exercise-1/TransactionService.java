package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author kumareshkaruppusamy
 * This Transaction Service class provides the money transfer facility
 */

@Service("transactionService")
@Transactional
public class TransactionService {
	
	@Autowired
	private BankingService bankingService;
	
	public BankingService getBankingService() {
		return bankingService;
	}
	
	public void setBss(BankingService bankingService) {
		this.bankingService = bankingService;
	}
	
	/**
	 * The service that provides the money transfer functionality
	 * @param CreditID is the account number to do credit the money
	 * @param debitID is the account number to debit the money form 
	 * @param amount is represent the how much amount to transfer
	 * @throws InsufficientBalance, throws when user doesn't have the enough money
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void moneyTransfer(int CreditID,int debitID,int amount)throws InsufficientBalance {
		bankingService.doCredit(CreditID, amount);
		bankingService.doDebit(debitID, amount);			
	}
}

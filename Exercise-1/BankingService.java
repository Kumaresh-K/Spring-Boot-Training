package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kumareshkaruppusamy
 *	BankingService provides the debit and credit functionality for money transfer operation.
 */

@Service("bankService")
@Transactional
public class BankingService {
	
	@Autowired
	private AccountsDAO accountsDAO;
	
	/**
	 * To credit the amount to given user
	 * @param accountID is account number of the user
	 * @param creditAmount is amount want to credit to that given account
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public void doCredit(int accountID, int creditAmount) {
		AccountsDTO accountsDTO = accountsDAO.findByID(accountID);
		int amount = accountsDTO.getAmount();
		int updatedAmount = amount+creditAmount;
		System.out.println("Amount credited : " + updatedAmount);
		accountsDTO.setAmount(updatedAmount);
		accountsDAO.updateUser(accountsDTO);
	}
	
	/**
	 * 
	 * @param accountID is account number of the user
	 * @param debitAmount is amount to debit to the user
	 * @throws InsufficientBalance, throws when user have enough money to debit
	 */
	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = {InsufficientBalance.class})
	public void doDebit(int accountID,int debitAmount)throws InsufficientBalance {
		AccountsDTO accountsDTO = accountsDAO.findByID(accountID);
		int amount = accountsDTO.getAmount();
		if(amount < debitAmount) {
			throw new InsufficientBalance("Not enough money to transfer....");
		}
		int updatedAmount = amount - debitAmount;
		System.out.println("Amount debited : " + updatedAmount);
		accountsDTO.setAmount(updatedAmount);
		accountsDAO.updateUser(accountsDTO);
	}
}

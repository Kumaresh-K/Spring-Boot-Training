package com.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kumareshkaruppusamy
 * Service class for doing the update operations on the account table by access the AccountDAO
 */

@Service
@Transactional
public class MyService {
	
	@Autowired
	private AccountsDAO accountDAO;
	/**
	 * The service used to update the account details of the user
	 * @param accountID is account number of the user
	 * @param amount is money to set to given account
	 */
	public void doService(int accountID, int amount) {
		AccountsDTO accountsDTO = accountDAO.findByID(accountID);
		accountsDTO.setAmount(amount);
		accountDAO.updateUser(accountsDTO);
	}

	public AccountsDAO getDao() {
		return accountDAO;
	}

	public void setDao(AccountsDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
}	

package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @author kumareshkaruppusamy
 * Some related methods for an operations are written in the accountDAO
 */

@Repository("accountDAO")
public class AccountsDAO {
	
	@Autowired
	private SessionFactory factory;
	
	/** 
	 * to get the particular dto of the user
	 * @param accountID is account number of the user
	 * @return user DTO object of account number user
	 */
	public AccountsDTO findByID(int accountID) {
		Session session = factory.getCurrentSession();
		AccountsDTO accountsDTO = session.get(AccountsDTO.class, Integer.valueOf(accountID));
		return accountsDTO;
	}
	
	/**
	 * Updates the information of the account holder
	 * @param accountsDTO used to update the entry of the account holder
	 */
	public void updateUser(AccountsDTO accountsDTO) {
		Session session = factory.getCurrentSession();
		session.persist(accountsDTO);
	}
	
	/**
	 * To get the object of the session factory
	 * @return session factory object
	 */
	public SessionFactory getFactory() {
		return factory;
	}
	
	/**
	 * To assign the session factory object
	 * @param factory is the object of the session factory class
	 */
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
}
package com.rev.apitest.service;

import java.math.BigDecimal;

import com.rev.apitest.dao.AccountDao;
import com.rev.apitest.dao.AccountDaoImpl;
import com.rev.apitest.exception.CurrencyMismatchException;
import com.rev.apitest.exception.InsufficientFundException;
import com.rev.apitest.exception.InvalidAccountException;
import com.rev.apitest.model.Account;
import com.rev.apitest.model.Transaction;


/**
 * @author Akanksha
 *
 */
public class AccountServiceImpl implements AccountService{

private AccountDao accountDao = new AccountDaoImpl();	

	
/**
 * Get the account details based on accountId
 *
 * @param type accountId
 */
	
	@Override
	public Account getAccountById(long accountId) throws InvalidAccountException {
		return accountDao.getAccountById(accountId);
	}


	/**
	 * Exceute transaction based on input 
	 *
	 * @param type Transaction
	 */
	@Override
	public boolean transferAmount(Transaction transaction) throws InvalidAccountException, CurrencyMismatchException, InsufficientFundException {
		Account fromAccount= getAccountById(transaction.getFromAccontId());
		Account toAccount= getAccountById(transaction.getToAccountId());
		String transactionCurrency=transaction.getCurrency();
		
		if(!fromAccount.getCurrency().equals(toAccount.getCurrency())) {
			throw new CurrencyMismatchException("Source and Destination currency unequal");
		}
		
		if(!transactionCurrency.equals(fromAccount.getCurrency())) {
			throw new CurrencyMismatchException("Transaction currrency unequal");
		}
		if(fromAccount.getBalance().compareTo(transaction.getAmmount())<-1) {
			
			throw new InsufficientFundException("Insufficient funds");
		}
		
		synchronized(this){
			if(accountDao.updateBalance(fromAccount.getAccountId(),fromAccount.getBalance().subtract(transaction.getAmmount())))
				return accountDao.updateBalance(toAccount.getAccountId(), toAccount.getBalance().add(transaction.getAmmount()));
			else
				return false;
		}
	
	}

	/**
	 * GetBalnce of given account 
	 *
	 * @param type accountId
	 */

	@Override
	public BigDecimal getBalance(long accountId) {
		return accountDao.getBalance(accountId);
	}


	/**
	 * Update account based on input 
	 *
	 * @param type Account
	 */

	@Override
	public boolean updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

}

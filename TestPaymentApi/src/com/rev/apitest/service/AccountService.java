package com.rev.apitest.service;

import java.math.BigDecimal;

import com.rev.apitest.exception.CurrencyMismatchException;
import com.rev.apitest.exception.InsufficientFundException;
import com.rev.apitest.exception.InvalidAccountException;
import com.rev.apitest.model.Account;
import com.rev.apitest.model.Transaction;

/**
 * @author Akanksha
 *
 */
public interface AccountService {
	
	
	 Account getAccountById(long accountId) throws InvalidAccountException;
	 BigDecimal  getBalance(long accountId);
	 boolean transferAmount(Transaction transaction) throws InvalidAccountException, CurrencyMismatchException, InsufficientFundException;
	 boolean updateAccount(Account account);


}

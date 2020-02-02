package com.rev.apitest.dao;

import java.math.BigDecimal;

import com.rev.apitest.exception.InvalidAccountException;
import com.rev.apitest.model.Account;

/**
 * @author Akanksha
 *
 */
public interface AccountDao {

	Account getAccountById(long accountId) throws InvalidAccountException;

	boolean updateBalance(long accountId, BigDecimal balance) throws InvalidAccountException;

	BigDecimal getBalance(long accountId);

	boolean updateAccount(Account account);

}
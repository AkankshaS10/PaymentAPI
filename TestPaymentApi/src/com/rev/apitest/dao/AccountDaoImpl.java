package com.rev.apitest.dao;

import java.math.BigDecimal;

import com.rev.apitest.exception.InvalidAccountException;
import com.rev.apitest.model.Account;
import com.rev.apitest.repo.AccountRepo;

/**
 * @author Akanksha
 *
 */
public class AccountDaoImpl implements AccountDao {

	/**
	 * Get the account details based on accountId
	 *
	 * @param type accountId
	 */
	@Override
	public Account getAccountById(long accountId) throws InvalidAccountException {

		Account account = AccountRepo.accountMap.get(accountId);
		if(account==null) {
			throw new InvalidAccountException("Invalid account Id");
		}

		return account;
	}
	

	/**
	 * Update balance based on input  
	 *
	 * @param type accountId
	 * @param type balance
	 */

	@Override
	public boolean updateBalance(long accountId, BigDecimal balance) throws InvalidAccountException {

		boolean isUpdated=false;
		Account account = getAccountById(accountId);

		synchronized (this) {
			account.setBalance(balance);

			AccountRepo.accountMap.put(accountId, account);
			isUpdated=true;
		}

		return isUpdated;
	}
	
	/**
	 * GetBalnce of given account 
	 *
	 * @param type accountId
	 */

	@Override
	public BigDecimal getBalance(long accountId) {
		return AccountRepo.accountMap.get(accountId).getBalance();
		
	}
	
	
	/**
	 * Update account based on input 
	 *
	 * @param type Account
	 */

	@Override
	public boolean updateAccount(Account account) {
		
		if(AccountRepo.accountMap.put(account.getAccountId(), account)!=null)
		return true;
		else
			return false;
	}
}

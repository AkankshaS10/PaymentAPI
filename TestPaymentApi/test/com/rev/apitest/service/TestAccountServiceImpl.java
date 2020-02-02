package com.rev.apitest.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.rev.apitest.exception.CurrencyMismatchException;
import com.rev.apitest.exception.InsufficientFundException;
import com.rev.apitest.exception.InvalidAccountException;
import com.rev.apitest.model.Account;
import com.rev.apitest.model.Transaction;
import com.rev.apitest.repo.AccountRepo;

/**
 * @author Akanksha
 * 
 */
public class TestAccountServiceImpl {
	private AccountService accService =new AccountServiceImpl();
	private AccountRepo accRepo= new AccountRepo();
	private Transaction transaction;
	@Before
	public void setup() {
		 transaction = new Transaction(1000L,1001L,new BigDecimal(500),"EUR");
				
	}

	@Test
	public void  getAccountByid() throws InvalidAccountException {
		Account acc=accService.getAccountById(1000L);
		assertEquals(acc.getUserId(),"U1");
		assertEquals(acc.getBalance(),new BigDecimal(1000));
		assertEquals(acc.getCurrency(),"EUR");
	}
	
	@Test
	public void  transferAmount() throws InvalidAccountException, CurrencyMismatchException, InsufficientFundException {
		Boolean res=accService.transferAmount(transaction);
		assertEquals(res,true);;
	}
	
	@Test(expected =CurrencyMismatchException.class )
	public void  transferAmountInvalidCurrency() throws InvalidAccountException, InsufficientFundException, CurrencyMismatchException {
		 transaction = new Transaction(1000L,1001L,new BigDecimal(500),"USD");
		Boolean res=accService.transferAmount(transaction);
		assertEquals(res,true);;
	}
	
	@Test(expected =CurrencyMismatchException.class )
	public void  transferAmountInvalidCurrencyAcc() throws InvalidAccountException, InsufficientFundException, CurrencyMismatchException {
		 transaction = new Transaction(1000L,1009L,new BigDecimal(500),"USD");
		Boolean res=accService.transferAmount(transaction);
		assertEquals(res,true);;
	}
	
	@Test(expected =InsufficientFundException.class )
	public void  transferAmountInsuffFund() throws InvalidAccountException, InsufficientFundException, CurrencyMismatchException {
		 transaction = new Transaction(1000L,1001L,new BigDecimal(5000),"USD");
		Boolean res=accService.transferAmount(transaction);
		assertEquals(res,true);
	}
	
	@Test(expected =InvalidAccountException.class )
	public void  transferAmountInvalidAcc() throws InvalidAccountException, InsufficientFundException, CurrencyMismatchException {
		 transaction = new Transaction(2000L,1001L,new BigDecimal(500),"USD");
		Boolean res=accService.transferAmount(transaction);
		assertEquals(res,true);
	}
}

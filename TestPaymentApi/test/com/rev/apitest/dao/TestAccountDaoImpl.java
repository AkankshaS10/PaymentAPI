package com.rev.apitest.dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.rev.apitest.exception.InvalidAccountException;
import com.rev.apitest.model.Account;
import com.rev.apitest.repo.AccountRepo;

public class TestAccountDaoImpl {
	private AccountDao accDao= new AccountDaoImpl();
	private AccountRepo accRepo= new AccountRepo();
	
	@Before
	public void setup() {
		
	}

	@Test
	public void getAccountById() throws InvalidAccountException {
		
		Account acc=accDao.getAccountById(1000L);
		assertEquals(acc.getUserId(),"U1");
		assertEquals(acc.getBalance(),new BigDecimal(1000));
		assertEquals(acc.getCurrency(),"EUR");
	}
	
	@Test(expected =InvalidAccountException.class )
	public void getAccountByIdInvalid() throws InvalidAccountException {
		
		accDao.getAccountById(10L);;
	}
	
	@Test
	public void updateBalance() throws InvalidAccountException {
		
		Boolean result=accDao.updateBalance(1000L,new BigDecimal(2000));
		assertEquals(result,true);
		Account acc=accDao.getAccountById(1000L);
		assertEquals(acc.getBalance(),new BigDecimal(2000));
	}
	
	@Test
	public void getBalance() throws InvalidAccountException {
	
		assertEquals(accDao.getBalance(1000L),new BigDecimal(1000));
	}
	
	@Test
	public void updateAccount() throws InvalidAccountException {
		
		Account acc=new Account(1000L,"U1",new BigDecimal(2000),"USD");
		Boolean result=accDao.updateAccount(acc);
		assertEquals(result,true);
		Account acc1=accDao.getAccountById(1000L);
		assertEquals(acc.getBalance(),new BigDecimal(2000));
		assertEquals(acc.getCurrency(),"USD");
	}
}

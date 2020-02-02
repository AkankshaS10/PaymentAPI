package com.rev.apitest.controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import com.rev.apitest.exception.CurrencyMismatchException;
import com.rev.apitest.exception.InsufficientFundException;
import com.rev.apitest.exception.InvalidAccountException;
import com.rev.apitest.model.Account;
import com.rev.apitest.model.Transaction;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rev.apitest.service.AccountService;
import com.rev.apitest.service.AccountServiceImpl;


/**
 * @author Akanksha
 * Entry point for all account related apis
 *
 */


@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {

private AccountService accountService=new AccountServiceImpl();


/**
 * Api to transfer amount
 *
 * @return the response if transaction successful
 */
	@POST
	@Path("/transaction")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response transferMoney(Transaction transaction) {

		try {
			accountService.transferAmount(transaction);
			return Response.status(Response.Status.OK).build();

		} catch (InvalidAccountException | CurrencyMismatchException | InsufficientFundException e) {
			throw new WebApplicationException(e.getMessage(), Response.Status.BAD_REQUEST);
		}

	}
	
	
	/**
	 * Api to get account details
	 *
	 * @return the Account Details 
	 */
	@GET
	@Path("{accId}")
	public Account getAccountById(@PathParam("accountId")long accountId) {
		try {
			return accountService.getAccountById(accountId);
		} catch (InvalidAccountException e) {
			throw new WebApplicationException(e.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * Api to update account details
	 *
	 * @return the response if update successful
	 */
	
	@PUT
	@Path("/update")
	Response updateAccount(Account account) {
		if(accountService.updateAccount(account)) {
			return Response.status(Response.Status.OK).build();
		}
		else
			throw new WebApplicationException("Transaction failed", Response.Status.INTERNAL_SERVER_ERROR);
		
	}
}

package com.rev.apitest.controller.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.rev.apitest.app.App;
import com.rev.apitest.model.Transaction;

public class AccountControllerTest {
	private Client client = ClientBuilder.newClient();
	
	@Before
	public void setup() {
		App.loadData();
		App.startService();
	
	}

	
	@Test
	public void testurl() {
		
		WebTarget webTarget  = client.target("http://localhost:8008/account/transaction");
		Invocation.Builder invocationBuilder= webTarget.request(MediaType.APPLICATION_JSON);
		
		Response response  = invocationBuilder.get();
		 assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		 
		 String str = response.readEntity(String.class);
		System.out.println( "val is"+str);
		
	
	}
	
	@Test
	public void testMoneyTransfer() {
		
		WebTarget webTarget  = client.target("http://localhost:8008/account/test");
		Invocation.Builder invocationBuilder= webTarget.request(MediaType.APPLICATION_JSON);
	
		
		Transaction transcation=new Transaction(1000L,1001L,new BigDecimal(500),"EUR");
		
		Response response  = invocationBuilder.post(Entity.entity(transcation, MediaType.APPLICATION_JSON));
		
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

	}
	

	@Test
	public void testMoneyTransferfail() {
		
		WebTarget webTarget  = client.target("http://localhost:8008/account/test");
		Invocation.Builder invocationBuilder= webTarget.request(MediaType.APPLICATION_JSON);
	
		
		Transaction transcation=new Transaction(1000L,1001L,new BigDecimal(500),"USD");
		
		Response response  = invocationBuilder.post(Entity.entity(transcation, MediaType.APPLICATION_JSON));
		
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());

	}

}

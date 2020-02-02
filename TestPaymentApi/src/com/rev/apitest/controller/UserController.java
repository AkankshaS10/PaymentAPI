package com.rev.apitest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rev.apitest.model.User;
import com.rev.apitest.service.UserService;
import com.rev.apitest.service.UserServiceImpl;

/**
 * @author Akanksha
 * Api to get user details
 */

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

	private UserService userService = new UserServiceImpl();
	
	/**
	 * Api to get the User details based on UserId
	 *
	 * @param type userId
	 */
	@GET
	@Path("{userId}")
	public User getUserById(@PathParam("userId")String userId) {

		return userService.getUserById(userId);
	}

}

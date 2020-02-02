package com.rev.apitest.service;

import com.rev.apitest.dao.UserDao;
import com.rev.apitest.dao.UserDaoImpl;
import com.rev.apitest.model.User;



/**
 * @author Akanksha
 *
 */
public class UserServiceImpl implements UserService{

	private UserDao userDao= new UserDaoImpl();
	
	/**
	 * Get the user details based on userId
	 *
	 * @param type userId
	 */
	@Override
	public User getUserById(String userId) {
		return userDao.getUserById(userId);
	}




}

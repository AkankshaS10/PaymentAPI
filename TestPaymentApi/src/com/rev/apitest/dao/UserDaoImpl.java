package com.rev.apitest.dao;

import com.rev.apitest.model.User;
import com.rev.apitest.repo.UserRepo;

/**
 * @author Akanksha
 *
 */
public class UserDaoImpl implements UserDao {

	/**
	 * Get the user details based on userId
	 *
	 * @param type userId
	 */
	@Override
	public User getUserById(String userId) {
		return UserRepo.userMap.get(userId);
		
	}


}

package com.rev.apitest.dao;

import com.rev.apitest.model.User;

/**
 * @author Akanksha
 *
 */
public interface UserDao {

	User getUserById(String userId);

}
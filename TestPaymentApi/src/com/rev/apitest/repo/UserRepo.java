package com.rev.apitest.repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.rev.apitest.model.User;

/**
 * @author Akanksha
 * 
 * Repo to load data from csv for account
 */
public class UserRepo {

	public static Map<String, User> userMap = new HashMap<>();
	private static String USER_FILE = "userDetails.csv";
	private static String DELIMINATOR = ",";

	public UserRepo() {
		loadAUserRepo();
	}

	private void loadAUserRepo() {

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(USER_FILE);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)))  {

			String line = br.readLine();// header

			while ((line = br.readLine()) != null) {
				String[] userStr = line.split(DELIMINATOR);
				User user = new User(userStr[0], userStr[1], userStr[2]);
				userMap.put(userStr[0], user);
			}
		} catch (IOException e) {
			System.out.println("Exception occured while User data load");
			e.printStackTrace();
		}
	}

	public static Map<String, User> getUserMap() {
		return userMap;
	}

}

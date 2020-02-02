package com.rev.apitest.repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.rev.apitest.model.Account;

/**
 * @author Akanksha
 * 
 * Repo to load data from csv for account
 */
public class AccountRepo {

	private static String ACCOUNT_FILE = "accountDetails.csv";

	private static String DELIMINATOR = ",";
	public static Map<Long, Account> accountMap = new HashMap<>();

	public AccountRepo() {
		loadAccountRepo();
	}

	private void loadAccountRepo() {

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(ACCOUNT_FILE);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

			String line = br.readLine();// header

			while ((line = br.readLine()) != null) {
				String[] accountStr = line.split(DELIMINATOR);
				long accId = Long.parseLong(accountStr[0]);
				Account account = new Account(accId, accountStr[1], new BigDecimal(Double.parseDouble(accountStr[2])),
						accountStr[3]);
				accountMap.put(accId, account);
			}
		} catch (IOException e) {
			System.out.println("Exception occured while Account data load");
			e.printStackTrace();
		}
	}

	public Map<Long, Account> getAccountMap() {
		return accountMap;
	}

}

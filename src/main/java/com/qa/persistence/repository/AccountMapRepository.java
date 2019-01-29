package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.persistence.utility.JSONUtil;

import java.util.HashMap;
import java.util.Map;

 
public class AccountMapRepository implements AccountRepository{ 
	
	JSONUtil jsonutil = new JSONUtil();
	public Map<Long, Account> accountMap = new HashMap<>();

	public String getAllAccounts() {

		String tmp = "";
		for (Account name: accountMap.values()){

            String accountToString = name.toString();
            accountToString += "";
            tmp += accountToString;
            } 
		
		return tmp; 
	}

	public String createAccount(String account1) {
		
		
		Account acc = jsonutil.getObjectForJSON(account1, Account.class);
		
		
//		accountMap.put((long) accountMap.size(), acc);

		accountMap.put((long) acc.getAccountNumber(), acc);
		
////		return account1;
//		return acc.getAccount();
		return null;
	}

	public String deleteAccount(Long id) {
		accountMap.remove(id);
		return accountMap.toString();  
	} 

	public String updateAccount(Long id, String account1) {
		AccountMapRepository repo;
		JSONUtil util = new JSONUtil();
		Account account2 = util.getObjectForJSON(account1, null);
		if(accountMap.containsKey(id)) {
			accountMap.put(id, account2);
			return "values have been changed";
		} else {
			return "account does not exist";
		}
		
	}

	@Override
	public String getFirstName() {
				return null;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccountNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

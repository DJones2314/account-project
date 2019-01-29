package com.qa.persistence;

import com.qa.persistence.repository.AccountMapRepository;

public class App { 

	
	
	
	
	
	private static void hello() {
		String account1 = "dave"; 
		AccountMapRepository test = new AccountMapRepository();
		test.createAccount(account1);
		System.out.println("Hello world to the standard out");
	}
	
}

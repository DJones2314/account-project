package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.utility.JSONUtil;

public class AccountServiceTest {

	AccountMapRepository repo;
	JSONUtil util = new JSONUtil();
	
	@Before
	public void setup() {
	repo = new AccountMapRepository();
	}
	
	@Test
	public void addAccountTest() {
		
		int size = repo.accountMap.size(); 
		Account account = new Account("jane", "doe", 19); 
		repo.createAccount(util.getJSONForObject(account));
		size = repo.accountMap.size(); 
		assertEquals("new account", size, repo.accountMap.size());   
		

	}

	@Test
	public void add2AccountTest() {
	int size = repo.accountMap.size(); 
	Account account1 = new Account("jane", "doe", 19); 
	Account account2 = new Account("bane", "foe", 12);
	repo.createAccount(util.getJSONForObject(account1));
	repo.createAccount(util.getJSONForObject(account2));
	size = repo.accountMap.size(); 
	assertEquals("new account", size, repo.accountMap.size()); 
	}

	@Test
	public void removeAccountTest() {
		
		int size = repo.accountMap.size(); 
		Account account = new Account("jane", "doe", 19); 
		repo.deleteAccount((long) 19);
		size = repo.accountMap.size(); 
		assertEquals("new account", size, repo.accountMap.size()); 
		
	}
	
	@Test
	public void remove2AccountTest() {
		
		int size = repo.accountMap.size(); 
		Account account = new Account("jane", "doe", 19);
		Account account2 = new Account("bane", "foe", 12);
		repo.deleteAccount((long) 19);
		repo.deleteAccount((long) 12);
		size = repo.accountMap.size(); 
		assertEquals("new account", size, repo.accountMap.size());
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		int size = repo.accountMap.size(); 
		Account account = new Account("jane", "doe", 19);
		repo.deleteAccount((long) 19);
		repo.deleteAccount((long) 12);
		size = repo.accountMap.size(); 
		assertEquals("new account", size, repo.accountMap.size());
	} 
	
	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
	
	}
	
	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {
	
	}

	@Test
	public void accountConversionToJSONTest() {
		
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		
	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		
	}

}

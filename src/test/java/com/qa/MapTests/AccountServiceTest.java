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
	
		String jsonString = "{\"firstName\":\"dave\",\"lastName\":\"clayton\",\"accountNumber\":\"2847\"}"; 
		Account test = util.getObjectForJSON(jsonString, Account.class);

		
		assertEquals("Not Worked","dave clayton 2847",test.getAccount());
		
		}
		
	
	
	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {
		int size = repo.accountMap.size();
		
		Account aAccount = new Account("josh", "jerry", 4321);
		
		String account = util.getJSONForObject(aAccount);
		
		repo.createAccount(account);
		size = repo.accountMap.size();
		assertEquals("success", size, repo.accountMap.size());
		
	 
	}

	@Test
	public void accountConversionToJSONTest() {
		Account anAccount = new Account("matt", "hores", 2468);
		String account = util.getJSONForObject(anAccount);

		
		assertEquals("Worked","{\"firstName\":\"matt\",\"lastName\":\"hores\",\"accountNumber\":2468}", account.toString());
	} 

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		
		assertEquals("test failed", 0, repo.getNumberFirstName("john"));
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		String jsonString = "{\"firstName\":\"dave\",\"lastName\":\"clayton\",\"accountNumber\":\"1234\"}";
		String jsonString2 = "{\"firstName\":\"matt\",\"lastName\":\"hores\",\"accountNumber\":\"4321\"}";
		repo.createAccount(jsonString);
		repo.createAccount(jsonString2);
		assertEquals("failed", 1 ,repo.getNumberFirstName("dave"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		
		String jsonString = "{\"firstName\":\"dave\",\"lastName\":\"clayton\",\"accountNumber\":\"5432\"}";
		String jsonString2 = "{\"firstName\":\"dave\",\"lastName\":\"hores\",\"accountNumber\":\"1234\"}";
		String jsonString3 = "{\"firstName\":\"dave\",\"lastName\":\"well\",\"accountNumber\":\"2468\"}";
		repo.createAccount(jsonString);
		repo.createAccount(jsonString2);
		repo.createAccount(jsonString3);
		assertEquals("failed", 3 ,repo.getNumberFirstName("dave")); 
		
	}

}

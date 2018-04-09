package org.proj.BankApp;

import static org.junit.Assert.*;

import org.junit.Test;

public class Banktest {

	@Test
	public void depostTest() 
	{
		
		Bank_details b=new Bank_details();
		assertEquals(1000,b.deposit(500,500));
		
	}

}

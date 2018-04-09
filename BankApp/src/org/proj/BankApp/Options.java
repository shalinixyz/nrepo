package org.proj.BankApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Options {

	public void optionMenu() 
	{
		Scanner sc = new Scanner(System.in);
		Bank_details b = new Bank_details();
		boolean choice = true;
		try{
     
		do {
			System.out.println("1.Create Account\n2.Deposit\n3.Withdraw\n4.check_details\n5.Last Transaction\n6.Transaction Summary\n7.Simple interest\n8.compound Interest");
			System.out.println("Enter your choice");
			int ch = sc.nextInt();
		
			switch (ch) {
			case 1:
				b.create();
				break;
			case 2:
				b.deposit();
				break;
			case 3:
				b.withdraw();
				break;
			case 4:
				b.check_details();
				break;
			case 5:
				b.getLastTransaction();
				break;
			case 6:
				b.getInfo();
				break;
			case 7:b.simpleInterest();
			    break;
			case 8:
				b.compundInterest();
				break;
			default:System.out.println("Invalid Option");

			}
		
			System.out.println("if u want to continue press 1 else 0");
			int ans = sc.nextInt();
			if (ans == 0)
				choice = false;
			else
				choice = true;
		} while (choice==true);
	}
	
	catch(InputMismatchException e)
		{
		System.out.println("Improper choice");
		}
}
}
package org.proj.BankApp;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

public class Bank_details extends Variables implements Account1 
{

	@Override
	public void create() 
	{
		try{


			System.out.println("Enter name");
			name = sc.next();
			System.out.println("Enter initial amount");
			double temp = sc.nextDouble();
			if((temp%100)!=0){
				System.out.println("please enter amount in multiples of 100");
				System.out.println("Try again");
				temp=sc.nextDouble();
			}
			if(temp<min_balance)
			{
				System.out.println("minimum balance should be 500");
				System.out.println("try again");
				temp=sc.nextDouble();

			}

			acc_num++;
			balance=(int) temp;
			Customers newcust = new Customers(acc_num,name,balance);
			cust[i++] = newcust;
			System.out.println("Account created");
			System.out.println("Hi "+cust[i-1].name+" your account number is "+cust[i-1].acc_num);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid input");
		}
	}
	@Override
	public void deposit() 
	{
		System.out.println("enter acc_num");
		int temp_accnum= sc.nextInt();
		try{
			for (int i = 0; i < cust.length;i++) 
			{

				if(temp_accnum==cust[i].acc_num)
				{
					System.out.println("enter amount to be deposited");
				  // double temp_amount = sc.nextDouble();
					int temp_amount=sc.nextInt();
					if((temp_amount%100)!=0)
					{
						System.out.println("please enter amount in multiples of 100");
						System.out.println("Try again");
					//	temp_amount=sc.nextDouble();

					}
					cust[i].balance=deposit(cust[i].balance,temp_amount);
					
					System.out.println("after deposit=" + cust[i].balance);
					Total_transactions++;
					dl.add("deposited "+temp_amount);
					m.put(cust[i].acc_num,dl);
					break;
				}

			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid inut");
		}
		catch(NullPointerException e)
		{
			System.out.println("account number doesnt exists");
		}
	}

	@Override
	public void withdraw() 
	{

		try
		{
			System.out.println("enter acc_num");
			int temp_accnum= sc.nextInt();
			for (int i = 0; i < cust.length; i++) 
			{
				if (cust[i].acc_num==temp_accnum) 
				{

					System.out.println("enter amount to be withdrawn");
					double temp_amount = sc.nextDouble();
					if((temp_amount%100)!=0)
					{
						System.out.println("please enter amount in multiples of 100");
						System.out.println("tryagain");
						temp_amount=sc.nextDouble();
					}
					if(temp_amount>cust[i].balance)
					{
						System.out.println("cannot withdraw..Insufficient balance");

					}
					else 
					{
						//cust[i].balance =cust[i].balance - temp_amount;
						System.out.println("after withdraw=" +cust[i]. balance);
						Total_transactions++;
						dl.add("withdraw of  "+temp_amount);
						m.put(cust[i].acc_num,dl);
						break;
					}
				}
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Enter proper input");
		}
		catch(NullPointerException e)
		{
			System.out.println("Account number does not exist");

		}
	}



	void check_details() 
	{

		try{

			System.out.println("enter acc_num");
			int temp_accnum = sc.nextInt();
			for (int i = 0; i < cust.length; i++) 
			{
				if (cust[i].acc_num == temp_accnum) 
				{
					System.out.println("Name="+cust[i].name);
					System.out.println("Account No ="+cust[i].acc_num);
					System.out.println("Balance= "+cust[i].balance);
					break;

				}


			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("invalid imput");
		}
		catch(NullPointerException e){
			System.out.println("account number doesnt exist");
		}



	}
	void getTransaction_count()
	{
		System.out.println("Trnsactions="+Total_transactions);
	}
	void getLastTransaction()
	{

		System.out.println("enter accno");
		int temp=sc.nextInt();
		if(m.containsKey(temp))
		{
			LinkedList l1=(LinkedList) m.get(temp);
			System.out.println(l1.getLast());
		}
	}
	void getInfo()
	{
		System.out.println("enter accno");
		int temp=sc.nextInt();
		if(m.containsKey(temp))
		{
			List l1=(List) m.get(temp);

			for(int i=0;i<l1.size();i++)
			{
				System.out.println(l1.get(i));
			}

		}

	}
	void simpleInterest()
	{

		System.out.println("enter acc_num");
		int temp_accnum = sc.nextInt();
		for (int i = 0; i < cust.length; i++) 
		{
			if (cust[i].acc_num == temp_accnum) 
			{
				System.out.println("Enter Number of Years");
				int years=sc.nextInt();
				double si=(cust[i].balance*years*0.04)/100;
				System.out.println("Simple interest for 4% "+si);
				System.out.println("After 4% simple interest Amount is "+(cust[i].balance+si));

				break;

			}


		}

	}

	void compundInterest()
	{
		System.out.println("enter acc_num");
		int temp_accnum = sc.nextInt();
		try{
			for (int i = 0; i < cust.length; i++) 
			{
				if (cust[i].acc_num == temp_accnum) 
				{
					System.out.println("Enter Number of Years");
					int years=sc.nextInt();
					double ci=cust[i].balance * Math.pow((1 + 0.07 / 100), years);
					System.out.println("Compound interest for 7% "+ci);
					break;

				}
				else
				{
					throw new NullPointerException();
				}

			}
		}
		catch(NullPointerException e)
		{
			System.out.println("Account number doesnt exists");
		}
	}

	//for testing
	int deposit(int actual_amount, int deposit_amount)
	{
		
		return actual_amount+deposit_amount;
	
	}
	
    }

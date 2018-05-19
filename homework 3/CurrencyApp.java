//TJ Liggett
//Homework 3
//CurrencyApp.java

import java.util.Scanner;

public class CurrencyApp
{
	
	//Input: User first enters $US amount (double)
	//       The user later inputs $HK amount (double)
	//Desc: User supplies $US and $HK amounts (double) and 
	//     	program converts amounts to other currency, then
	//      displaying them on the screen
	//Output: Displays currency in both its original currency and
	//       converted one.
	public static void main(String[] args)
	{
	Scanner input = new Scanner(System.in);
	System.out.print("Please enter a $US amount:");			
	double us = input.nextDouble();
	double hk = CurrencyExchange.usToHk(us);
	System.out.printf("US$%.2f=HK$%.2f%n", us, hk);
	System.out.print("Please enter a $HK amount:");			
	hk = input.nextDouble();
	us = CurrencyExchange.hkToUs(hk);
	System.out.printf("HK$%.2f=US$%.2f%n", hk, us);
	}






}
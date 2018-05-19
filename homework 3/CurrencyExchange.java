//TJ Liggett
//Homework 3
//CurrencyExchange.java


public class CurrencyExchange
{
	//Input: US dollar amount
	//Desc: Converts USD to HK and returns HK amount
	public static double usToHk(double us)
	{
		return us*7.8;
	}
	
	//Input: HK dollar amount
	//Desc: Converts HK to USD and returns USD amount
	public static double hkToUs(double hk)
	{
		return hk/7.8;
	}
}
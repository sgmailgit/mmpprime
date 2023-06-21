package javaprograms;

public class Calculator {
	
	public static int add(int a,int b)
	{
		int c =a+b;
		return c;
	}
	public int subtract(int a , int b)
	{
		if(a>b)
		{
			int c = a-b;
			return c;
		}
		else
		{
			int c = b-a;
			return c;
		}
	}	
	public int multiply(int a, int b)
	{
		int c =a*b;
		return c;
	}
	public int divide(int a,int b)
	{
		int c =a/b;
		return c;
	}

}

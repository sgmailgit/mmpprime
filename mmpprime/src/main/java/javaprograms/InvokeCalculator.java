package javaprograms;

public class InvokeCalculator {

	public static void main(String[] args) {
		//calling static method from Calculator class
		int actual=Calculator.add(10, 5);
		int expected=15;
		if(actual==expected)
		{
			System.out.println("Add functionality is working fine");
		}
		else
		{
			System.out.println("Add functionality is not working fine");
		}
		
		//calling non static methods of calculator
		//create object of thar class
		
		Calculator cal = new Calculator();
		 actual = cal.divide(10, 5);
		 expected = 2;
		if(actual==expected)
		{
			System.out.println("Divide functionality is working fine");
		}
		else
		{
			System.out.println("Divide functionality is not  working fine");
		}
		
	}
}

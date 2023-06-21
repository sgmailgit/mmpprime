package javaprograms;

public class StringEx {

	public static void main(String[] args) {
		//https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html
		
			String s = new String("Selenium");
			int count = s.length();
			System.out.println("length of the String:::  " + count);
			//----------------------------------------
			//immutable
			String s1 = new String("WebDriver");
			String s2 = s.concat(s1);
			System.out.println("The value of s is :::: " + s);
			System.out.println("The concantenated String ::: "+ s2);
			System.out.println(s + s1);
			System.out.println(2+s);
			System.out.println(2+3);
			//------------------------------------------------------
			//JAva is case sensitive
			String s3="Selenium";
			String s4="selenium";
			boolean result = s3.equals(s4);
			System.out.println(result);
			//-----------------------------------------------------
			String s5="192-123-123-123";
			
			//The first char value of the sequenceis at index 0, the next at index 1,and so on, as for array indexing. 
			System.out.println(s5.charAt(6));
			//beginIndex the beginning index, inclusive.
			//endIndex the ending index, exclusive(endIndex - 1)
			System.out.println(s5.substring(8, 11));
			String ip[] = s5.split("\\-");
			System.out.println("The length of the String array : " +ip.length);
			System.out.println("Printing the String array values");
			for(int i=0 ;i<ip.length;i++)
			{
				System.out.println(ip[i]);
			}
			//-------------------------------------------------------------
			String s6=" Selenium  ";
			System.out.println(s6.trim());
			System.out.println("Uppercase: "+s6.toUpperCase());
			System.out.println("Lowercase : "+ s6.toLowerCase());
			
			//-------------------------------------------------------------
			String s7="123.55$";
			System.out.println(s7.replace("$",""));
			System.out.println(s7);
			//-------------------------------------------------
			String s10="Selenium";
			System.out.println("The last index of Selenium is " + s10.lastIndexOf(101));
			//----------------------------------------------------
			//String s8 = null;
			//System.out.println(s8.length());
			

			

			
					





			


	}

}

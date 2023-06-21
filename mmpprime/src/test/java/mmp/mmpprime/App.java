package mmp.mmpprime;

public class App {
	
	String drName;
	String s ="Hello $drName$";
	

	public static void main(String[] args) {
		App a1 = new App();
		a1.display("Charlie");
		
	}
	public void display(String drName)
	{
		this.drName = drName;
		System.out.println("Display value stored in s : " + s.replace("$drName$", drName));
	}
}

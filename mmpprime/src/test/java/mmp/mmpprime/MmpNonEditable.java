package mmp.mmpprime;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MmpNonEditable {
	@Test
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
		
		WebElement  fname = driver.findElement(By.id("fname"));
		System.out.println("Is First Name field Non-editable: " + fname.getAttribute("readonly"));
		WebElement  lname = driver.findElement(By.id("lname"));
		System.out.println("Is Last Name field Non-editable: " + lname.getAttribute("readonly"));
		WebElement  licence = driver.findElement(By.id("licn"));
		System.out.println("Is Licence field Non-editable: " + licence.getAttribute("readonly"));
		WebElement  ssn = driver.findElement(By.id("ssn"));
		System.out.println("Is SSN field Non-editable: " + ssn.getAttribute("readonly"));
		WebElement  address = driver.findElement(By.id("addr"));
		System.out.println("Is Address field Non-editable: " + address.getAttribute("readonly"));
		WebElement  age = driver.findElement(By.id("age"));
		System.out.println("Is Age  field Non-editable: " + age.getAttribute("readonly"));
		
		
		
		
		
		

			
		
	}
	
}

package org.mmp.patientmodule;

import org.mmp.methods.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MMP_002_LoginTest extends BaseClass {
WebDriver driver;
	
		
	@Parameters({"url","username","password"})
	@Test
	public void TC_001_validateLogin(String url,String username,String password)
	{
		 
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		String actual =driver.findElement(By.xpath("//h3[normalize-space()='Patient Portal']")).getText();
		String expected="Patient Portal";
		Assert.assertEquals(actual, expected);
		driver.findElement(By.xpath("//span[normalize-space()='Logout']")).click();			
	}
	@Parameters({"url","invusername","invpassword"})
	@Test
	public void TC_003_invalidateLogin(String url,String invusername,String invpassword)
	{
		 
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(invusername);
		driver.findElement(By.id("password")).sendKeys(invpassword);
		driver.findElement(By.name("submit")).click();
		Alert alrt = driver.switchTo().alert();
		String actual =alrt.getText().trim();
		String expected="Wrong username and password.";
		Assert.assertEquals(actual, expected);
			
	}
}

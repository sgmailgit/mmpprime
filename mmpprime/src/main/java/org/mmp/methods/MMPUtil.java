package org.mmp.methods;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MMPUtil extends BaseClass{
	//driver in blue color denotes its a global variable
	//driver value is null here
	WebDriver driver;
	
	public MMPUtil(WebDriver driver) 
	{
		//driver in red color denotes its a local variable
		//we are assigning value here
		
		this.driver=driver;
	}

	public void launchBrowser(String url)
	{
		driver.get(url);
		
	}
	

	public static WebElement explicitTimeOut(WebDriver driver,int timeinSecs,By locator)
{
	Duration d =Duration.ofSeconds(timeinSecs);
  	WebDriverWait wait = new WebDriverWait(driver, d);
  	WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  	return e;
	}
}

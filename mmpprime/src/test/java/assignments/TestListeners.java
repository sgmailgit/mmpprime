package assignments;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(testngListeners.ListenersLog.class)

public class TestListeners  {
	WebDriver driver;
	@BeforeClass
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://demo.openmrs.org/openmrs/login.htm");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void login()
	{
		
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		String actual = driver.findElement(By.xpath("//h4[normalize-space()='Logged in as Super User (admin) at Inpatient Ward.']")).getText();
				
		String expected ="Logged in as Super User (admin) at Inpatient Ward.";
		AssertJUnit.assertEquals(actual.trim(), expected);
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
						
	}
	
	@Test
public void invalidLogin()
	{
			
		driver.findElement(By.id("username")).sendKeys("Test");
		driver.findElement(By.id("password")).sendKeys("Test123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
				       
        TakesScreenshot ts = (TakesScreenshot)driver;

       File file = ts.getScreenshotAs(OutputType.FILE);
       try {
           
             FileUtils.copyFile(file, new File("./ScreenShot_Folder/Test1_InvalidLogin.png"));
           } 
      catch (IOException e) {
          e.printStackTrace();
          }
      System.out.println("The Invalidlogin Page Screenshot is Taken");
			
	}
	@AfterClass
	public void closBrowser()
	{
		driver.quit();
	}

}

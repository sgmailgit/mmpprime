package assignments;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TakeScreenShot {
	//Screenshot in selenium
	public WebDriver driver;
	@BeforeClass
	public void login()
	{
	WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver();
	}
	@Test
	public void loginTest() {
        
		//define the url
		driver.get("https://demo.openmrs.org/openmrs/login.htm");	
		
                             //maximize the window
		//driver.manage().window().maximize();
		
                             //delete the cookies saved
		driver.manage().deleteAllCookies();
                             
				
		//get the title of the webpage
		String pageTitle = driver.getTitle();							 
		System.out.println("The title of this page is ===> " +pageTitle);
							
		//enter the locator of username and clear the input field before entering any value
		driver.findElement(By.id("username")).clear();	

                              //enter the username			
		driver.findElement(By.id("username")).sendKeys("Admin");		
		
		//enter the locator of password and clear the input field
		driver.findElement(By.id("password")).clear();
		
		//enter the value of password
		driver.findElement(By.id("password")).sendKeys("admin123");		
		
                             //downcast the driver to access TakesScreenshot method
		TakesScreenshot ts = (TakesScreenshot)driver;

                             //capture screenshot as output type FILE
		File file = ts.getScreenshotAs(OutputType.FILE);
		
		try {
                             //save the screenshot taken in destination path
			FileUtils.copyFile(file, new File("./ScreenShot_Folder/LoginTest_Login.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("the login page screenshot is taken");
	}
	@AfterClass
	public void tearDown() {
	driver.quit();
		}	
}

	

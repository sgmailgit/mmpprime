package assignments;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ExplicittWaitTest
{
	
	@Test
	public void waitForElement() throws Exception{
      
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	    WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));
	    element.click();
	    
	    
	    
	}

}

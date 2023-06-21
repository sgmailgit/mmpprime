package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods 
{
	
	@Test
    public void Navigate() throws Exception {
     
    	WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("btnK")).submit();
        Thread.sleep(2000);
        driver.navigate().to("https://facebook.com");
        driver.findElement(By.id("email")).sendKeys("aditya@gmail.com");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
    }
}



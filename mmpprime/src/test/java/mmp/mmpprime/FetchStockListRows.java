package mmp.mmpprime;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchStockListRows {
	@Test
	public void login() {
		
	
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		/*List <WebElement> tdList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println(tdList.size());
		for(int i =1;i <tdList.size(); i++)
		{
			System.out.println(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td["+i+"]")).getText());
		}*/
		
		List <WebElement> trList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println(trList.size());

		
		for(int j=0; j < trList.size(); j++)
		{
			List <WebElement> tdList  = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr["+j+"]/td"));
			
			for(int i =0;i <tdList.size(); i++)
			{
				System.out.println(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+j+"]/td["+i+"]")).getText());
			}
			
		}
		
		

}
	}
}

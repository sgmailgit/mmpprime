package mmp.mmpprime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchStockListParameterization {
	
    @Parameters({"stockName","stockName1","stockName2"})
	@Test
	public void login(String stockName,String stockName1,String stockName2)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		SoftAssert sa = new SoftAssert();
		boolean result = false;
		
	
			try {
				result=driver.findElement(By.xpath("//table[@class='dataTable']//a[contains(.,'"+stockName+"')]"))
						.isDisplayed();
				if(result)
				{
					System.out.println("Stock is available in the table::" +" "+ stockName );
					sa.assertTrue(result);
					
				}
			}
			catch(Exception e)
			{
				result = false;
				sa.assertTrue(result);
				System.out.println("Stock is not available in the table"+" " + stockName);
			}
			
			try {
				result=driver.findElement(By.xpath("//table[@class='dataTable']//a[contains(.,'"+stockName1+"')]"))
						.isDisplayed();
				if(result)
				{
					System.out.println("Stock is available in the table::" +" "+ stockName1 );
					sa.assertTrue(result);
					
				}
			}
			catch(Exception e)
			{
				result = false;
				sa.assertTrue(result);
				System.out.println("Stock is not available in the table"+" " + stockName1);
			}
			try {
				result=driver.findElement(By.xpath("//table[@class='dataTable']//a[contains(.,'"+stockName2+"')]"))
						.isDisplayed();
				if(result)
				{
					System.out.println("Stock is available in the table::" +" "+ stockName2 );
					sa.assertTrue(result);
					
				}
			}
			catch(Exception e)
			{
				result = false;
				sa.assertTrue(result);
				System.out.println("Stock is not available in the table"+" " + stockName2);
			}
			sa.assertAll();
		

	}	



}

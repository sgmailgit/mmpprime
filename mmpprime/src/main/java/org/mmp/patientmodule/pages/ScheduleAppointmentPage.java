package org.mmp.patientmodule.pages;

import java.util.HashMap;

import org.mmp.methods.JavaUtility;
import org.mmp.methods.MMPUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScheduleAppointmentPage {

	private WebDriver driver;
	private By ScheduleAppointmentlinkText = By.linkText("Schedule Appointment");
	private By Createnewappointmentbutton = By.cssSelector("input[value='Create new appointment']");
	private By datepickerID = By.id("datepicker");
	private By NextlinkText= By.linkText("Next");
	private By timeID = By.id("time");
	private By symID = By.id("sym");
	//Here drName is null
	
	//String doctorxpath = "//h4[normalize-space()='Dr.'$drName$']/ancestor::ul/following-sibling::button";
	
	//We are passing parameterized constructor
	//driver in red color denotes its a local variable
			//we are assigning value here
		
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public HashMap<String, String> bookAppointment(String drName)
	   
	{
		
			
	HashMap<String,String> sHMap = new HashMap<String,String>();
	driver.findElement(ScheduleAppointmentlinkText).click();
	driver.findElement(Createnewappointmentbutton).click();
	sHMap.put("doctor", drName);
	driver.findElement(By.xpath("//h4[normalize-space()='Dr."+drName+"']/ancestor::ul/following-sibling::button")).click();

	//driver.findElement(By.xpath(doctorxpath.replace("$drName$", drName))).click();
	driver.switchTo().frame("myframe");
	driver.findElement(datepickerID).click();
	driver.findElement(NextlinkText).click();
    driver.findElement(By.linkText("20")).click();
	sHMap.put("date", driver.findElement(By.id("datepicker")).getAttribute("value"));

	
	driver.findElement(timeID).click();
	{
		WebElement dropdown = driver.findElement(timeID);
	      dropdown.findElement(By.xpath("//option[. = '12Pm']")).click();

	}
	sHMap.put("time", driver.findElement(timeID).getAttribute("value"));
	//Explicit wait
	/*Duration d =Duration.ofSeconds(30);
	WebDriverWait wait = new WebDriverWait(driver, d);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ChangeHeatName")));*/
	/*By okStatus = By.id("ststus");
	WebElement okMessage= explicitTimeOut(driver,30,okStatus);
	System.out.println("Message in the pop - up "+ okMessage.getText());

	By continueButton = By.id("ChangeHeatName");
	WebElement continueWE = explicitTimeOut(driver,30,continueButton);
	continueWE.click();*/


	
	driver.findElement(By.id("ChangeHeatName")).click();
	driver.switchTo().defaultContent();
	driver.findElement(symID).click();
	driver.findElement(symID).sendKeys("Chest pain");
	sHMap.put("symptom", driver.findElement(symID).getAttribute("value"));
    driver.findElement(By.cssSelector("input[value='Submit']")).click();
	return sHMap;
}
	public HashMap<String,String> bookAppoitment(String drName,int noofDays)

	{

	HashMap<String,String> sHMap = new HashMap<String,String>();
	driver.findElement(ScheduleAppointmentlinkText).click();
	driver.findElement(Createnewappointmentbutton).click();
	String expectedDrName = drName;
	driver.findElement(By.xpath("//h4[normalize-space()='Dr."+expectedDrName+"']/ancestor::ul/following-sibling::button")).click();

	//driver.findElement(By.xpath(doctorxpath.replace("$drName$", expectedDrName))).click();
	sHMap.put("doctor", drName);
	driver.switchTo().frame("myframe");
	driver.findElement(datepickerID).click();
	String result = JavaUtility.getFutureDate(noofDays,"MMMM/dd/yyyy");
	String dateArr[]=result.split("/");
	String expectedYear=dateArr[2];
	String expectedMonth = dateArr[0];//Aug
	String expectedDay = dateArr[1];
	String actualYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();//June
	while(!(expectedYear.equals(actualYear)))
	{
	driver.findElement(NextlinkText).click();
	actualYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
	}

	String actualMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();//June
	while(!(expectedMonth.equals(actualMonth)))
	{
	driver.findElement(NextlinkText).click();
	actualMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
	}

	driver.findElement(By.linkText(expectedDay)).click();
	String expectedDate = driver.findElement(By.id("datepicker")).getAttribute("value");
	sHMap.put("date", expectedDate);
	driver.findElement(timeID).click();
	{

	WebElement dropdown = driver.findElement(timeID);
	dropdown.findElement(By.xpath("//option[. = '12Pm']")).click();
	}

	String expectedTime=driver.findElement(timeID).getAttribute("value");
	sHMap.put("time", expectedTime);
	
	By okStatus = By.id("status");
	WebElement okMessage = MMPUtil.explicitTimeOut(driver,30,okStatus);
	System.out.println("message in the pop-up: " + okMessage.getText());
	
	By continueButton = By.id("ChangeHeatName");
	WebElement continueWE = MMPUtil.explicitTimeOut(driver,30,continueButton);
	continueWE.click();
	System.out.println("Continue Clicked");
	
	driver.switchTo().defaultContent();
	driver.findElement(symID).click();
	driver.findElement(symID).sendKeys("Chest pain");
	String expectedSym = driver.findElement(symID).getAttribute("value");
	sHMap.put("symptom", expectedSym);
	driver.findElement(By.cssSelector("input[value='Submit']")).click();

	return sHMap;

	}

public HashMap<String, String> fetchPatientData()
{
	    
	HashMap<String,String> pHMap = new HashMap<String,String>();
	pHMap.put("doctor", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(4)")).getText());
	pHMap.put("date",driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(1)")).getText());
	pHMap.put("time", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).getText());
	pHMap.put("symptom", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(3)")).getText());
	return pHMap;
	
	
}

	
}

package org.mmp.patientmodule;

import java.util.HashMap;

import org.mmp.methods.BaseClass;
import org.mmp.methods.HelperClass;
import org.mmp.methods.MMPUtil;
import org.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class MMP_002_ScheduleAppointment extends BaseClass {
	MMPUtil mmpUtil;
	ScheduleAppointmentPage spage;
	@BeforeMethod
public void preRequestie()
{
		mmpUtil = new MMPUtil(driver);
		mmpUtil.launchBrowser(pro.getProperty("patientURL"));
		HelperClass helperobj = new HelperClass(driver);
		helperobj.Login(pro.getProperty("patientUserName"),pro.getProperty("patientPassword"));
		spage= new ScheduleAppointmentPage(driver);
	}
		
	@Parameters({"drName"})
	@Test
	public void TC_001_validateScheduleAppointment(String drName)

	{
		//We are creating object of the MMPUtil here
		//So that we call the methods of MMPUtil here
		
		HashMap<String,String> expectedHMap= spage.bookAppointment(drName);
		HashMap<String,String> actualHMap = spage.fetchPatientData();
		Assert.assertEquals(actualHMap, expectedHMap);
		
		
	}
	
	@Parameters({"drName"})
	@Test
	public void TC_003_validateScheduleAppointment(String drName)
	{
	
		HashMap<String,String> expectedHMap= spage.bookAppoitment(drName, 10);
		HashMap<String,String> actualHMap = spage.fetchPatientData();
		Assert.assertEquals(actualHMap, expectedHMap);

	   
	}
	
}







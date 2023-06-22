package org.mmp.patientmodule;

import org.mmp.methods.BaseClass;
import org.mmp.methods.HelperClass;
import org.mmp.methods.MMPUtil;
import org.mmp.patientmodule.pages.ScheduleAppointmentPage;

public class MMP_004_SendMessages extends BaseClass {
	MMPUtil mmpUtil;
	ScheduleAppointmentPage spage;
	public void preRequestie()
	{
		
			mmpUtil = new MMPUtil(driver);
			mmpUtil.launchBrowser(pro.getProperty("patientURL"));
			HelperClass helperobj = new HelperClass(driver);
			helperobj.Login(pro.getProperty("patientUserName"),pro.getProperty("patientPassword"));
			spage= new ScheduleAppointmentPage(driver);
		}

}

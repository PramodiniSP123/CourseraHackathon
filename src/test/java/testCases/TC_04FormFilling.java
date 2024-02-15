package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.PO_04FormFilling;
import testBase.BaseClass;


public class TC_04FormFilling extends BaseClass {
	
	@Test(priority = 11,groups= {"testcase"})
	public void Enterprise()
	{
		logger.info("start to navigate to home page.");
		PO_04FormFilling chp=new PO_04FormFilling(driver);
		chp.navigatetohome();
		logger.info("successfully navigate to home page.");
		chp.clickEnterprise();
		logger.info("after navigating to home page  for enterprise is clicked .");
	}
	
	


	@Test(priority = 12,groups= {"testcase"})
	public void form() throws IOException
	{
		logger.info("start to navigate to form.");
		PO_04FormFilling chp=new PO_04FormFilling(driver);
		chp.navigatetoform();
		logger.info("successfully navigate to form .");
	}
	
	@Test(priority = 13,groups= {"testcase"})
	public void startfillingform() throws InterruptedException, IOException
	{
		logger.info("starts to fill the form.");
		PO_04FormFilling chp=new PO_04FormFilling(driver);
		chp.Namefilling();
		Thread.sleep(3000);
		logger.info("form filling is done successfully done as per the requirement.");

	
	}
	
	@Test(priority = 14,groups= {"testcase"})
	public void messageDisplay() throws InterruptedException
	{
		logger.info("starts to display and capture error message .");
		PO_04FormFilling chp=new PO_04FormFilling(driver);
		Thread.sleep(2000);
		chp.errormsgdisp();
		chp.errormsg1();
		logger.info("error message is displayed and captured .");
	}
}

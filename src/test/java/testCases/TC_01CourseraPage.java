package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.PO_01CourseraPage;
import testBase.BaseClass;

public class TC_01CourseraPage extends BaseClass{
	
	@Test(priority = 1 , groups={"sanity"})
	public void surveyvisibility()
	{
		logger.info(" starts to open coursera page.");
		PO_01CourseraPage cup = new PO_01CourseraPage(driver);
		cup.verifysurvey();
		logger.info(" survey alert is ignored.");
	}
	
	@Test(priority = 2,groups= {"sanity"})
	public void TitleVerification() throws IOException
	{
		logger.info("start to open coursera page.");
		PO_01CourseraPage cup = new PO_01CourseraPage(driver);
		String get_Page = cup.Verify_CourseraPage();
		Assert.assertEquals(get_Page, "Coursera","Coursera Page successfully displayed");
		logger.info("Coursera Page is successfully displayed.");
	}
}

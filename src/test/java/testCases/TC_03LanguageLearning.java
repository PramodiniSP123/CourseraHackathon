package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.PO_03LanguageLearning;
import testBase.BaseClass;

public class TC_03LanguageLearning extends BaseClass {
	
	@Test(priority = 9,groups= {"master"})
	public void search_Language()
	{
		try {
			logger.info("starts to search language learning .");
		PO_03LanguageLearning lobj=new PO_03LanguageLearning(driver);
		lobj.search_Languagelearning();
		logger.info("successfully searched language learning .");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
			logger.info("failed to searched language learning .");
		}
	}
	
	@Test(priority = 10,groups= {"master"})
	public void show_FiveCourses()
	{
		try {
			logger.info("starts to filter courses by selecting different level and language .");
			PO_03LanguageLearning lobj=new PO_03LanguageLearning(driver);
			lobj.LanguageOne();
			Thread.sleep(2000);
			logger.info("first language and different levels  are selected .");
			lobj.LanguageTwo();
			logger.info("second language and different levels are selected .");
			Thread.sleep(2000);
			lobj.LanguageThree();
			logger.info("third language and different levels are  selected .");
			Thread.sleep(2000);
			lobj.LanguageFour();
			logger.info("fourth language and different levels are  selected .");
			Thread.sleep(2000);
			lobj.LanguageFive();
			logger.info("fifth language and different levels are selected .");
			
			}catch(Exception e) {
				e.printStackTrace();
				logger.info("failed to select language and levels .");
	
				
			}
	}
	
}

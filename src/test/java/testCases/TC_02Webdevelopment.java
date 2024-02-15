package testCases;


import java.io.IOException;
import org.testng.annotations.Test;
import PageObjects.PO_02WebdevelopmentPage;
import testBase.BaseClass;

public class TC_02Webdevelopment extends BaseClass{
	
	@Test(priority = 3,groups= {"regression"})
	public void course_search() throws InterruptedException, IOException
	{
		logger.info("start to search webdevelopment courses in search box .");
		PO_02WebdevelopmentPage wb = new PO_02WebdevelopmentPage( driver);
		wb.searchwebdevelopment();
		logger.info("searching of webdevelopment courses is done successfully.");
	}
	
	@Test(priority = 4,groups= {"regression"})
	public void level_select()
	{
		logger.info("starts to select level.");
		PO_02WebdevelopmentPage wb = new PO_02WebdevelopmentPage( driver);
		wb.select_Level();
		logger.info("level is selected after searching webdevelopment.");
	}
	
	@Test(priority = 5,groups= {"regression"})
	public void language_select()
	{
		logger.info("starts to select language.");
		PO_02WebdevelopmentPage wb = new PO_02WebdevelopmentPage( driver);
		wb.lang_select();
		logger.info("language is successfully selected.");
	}
	
	
	@Test(priority = 6,groups= {"regression"})
	public void ScrolluptoSearch()
	{
		logger.info("starts to scroll up the page.");
		PO_02WebdevelopmentPage wb = new PO_02WebdevelopmentPage( driver);
		wb.scrolling_up();
		logger.info("page is scrolled up successfully.");
	}
	
	@Test(priority = 7,groups= {"regression"})
	public void firstcourseselect()
	{
		logger.info("starts to display the first course course details.");
		PO_02WebdevelopmentPage wb = new PO_02WebdevelopmentPage( driver);
		wb.getFirstCourseDetails();
		logger.info("first course details is displayed successfully.");
	}
	
	@Test(priority = 8,groups= {"regression"})
	public void secondcourseselect()
	{
		logger.info("starts to display the second course course details.");
		PO_02WebdevelopmentPage wb = new PO_02WebdevelopmentPage( driver);
		wb.getSecondCourseDetails();
		logger.info("second course details is displayed successfully.");
	}
	
}

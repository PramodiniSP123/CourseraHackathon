package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


	public class PO_01CourseraPage extends BasePage {
		
		public PO_01CourseraPage(WebDriver driver) {
			super(driver);
		}
		
		//survey elements
		
		@FindBy(xpath="//*[@id=\"surveyModal~title\"]")
		WebElement surveyElement;
		
		@FindBy(xpath="//img[@class=\"rc-CourseraLogo\"]")
		WebElement courseraLogo;
		
		@FindBy(xpath="//*[@id=\"rendered-content\"]/div/div[1]/div/div[2]/div[2]/div/button[1]")
		WebElement surveyThanks;
		
		//action methods
		
		//verify survey is displayed or not
		public void verifysurvey()
		{
			try {
				fluentWait(surveyElement);
				if(surveyElement.isDisplayed())
				{
					System.out.println("survey is displaying");
					screenShot("survey");
					fluentWait(surveyThanks);
					surveyThanks.click();
				}
				else {
					System.out.println("survey did not appear");
				}
			} catch (Exception e) {
				System.out.println("survey did not appear");
			}
		
			
		}
		
		//verify CourseraPage is displayed or not 
		public String Verify_CourseraPage() throws IOException {
			String get_title = courseraLogo.getAttribute("alt");screenShot("HomePage");
			System.out.println(get_title);
			return get_title;
		}
}

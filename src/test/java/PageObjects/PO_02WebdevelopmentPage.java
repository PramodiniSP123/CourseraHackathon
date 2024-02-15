package PageObjects;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtils;


public class PO_02WebdevelopmentPage extends BasePage{
	
	//constructor
	public PO_02WebdevelopmentPage(WebDriver driver)
	{
		super(driver);
	}
	
	String filepath= "C:\\Users\\2303457\\eclipse-workspace\\MyHackathon 3\\MyHackathon\\testdata\\Book.xlsx";
	//locators
	@FindBy(xpath="//input[@role=\"textbox\"]")
	WebElement TakeInput;
	
	
	@FindBy(xpath="//input[starts-with(@placeholder,'What do you')]")
	WebElement SearchOption;
	
	@FindBy(xpath="//button[@class=\"nostyle search-button\" and @aria-label=\"Submit Search\"]")
	WebElement SearchButton;

	
	@FindBy(xpath="//*[(text()='Beginner')]")
	WebElement LevelBeginner;
	
	@FindBy(xpath="(//span[text()=\"English\"])[1]")
	WebElement LangEng;
	
	
	@FindBy(xpath = "(//div[@class='cds-ProductCard-content']//h3)[1]")
	WebElement CourseName1;


	@FindBy(xpath = "(//*[@class=\"cds-119 css-11uuo4b cds-121\"])[1]")
	WebElement rating1;

	@FindBy(xpath = "(//div[@class=\"cds-CommonCard-metadata\"]/p)[1]")
	WebElement duration1;

	@FindBy(xpath = "(//div[@class='cds-ProductCard-content']//h3)[2]")
	WebElement CourseName2;

	@FindBy(xpath = "(//*[@class=\"cds-119 css-11uuo4b cds-121\"])[2]")
	WebElement rating2;

	@FindBy(xpath = "(//div[@class=\"cds-CommonCard-metadata\"]/p)[2]")
	WebElement duration2;

	@FindBy(xpath = "(//div[@class='cds-227 cds-formGroup-groupWrapper'])[3]//div[contains(@class, 'css-zf4w52')]")
	List<WebElement> TotalLevels;

	
	//action methods
	
	//search for web development 
	public void searchwebdevelopment() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", TakeInput);
		TakeInput.sendKeys("web development courses");
		screenShot("courseinput");
	    fluentWait(SearchButton);
	    js.executeScript("arguments[0].click();", SearchButton);
	    
	}
	
	//Selecting Level as Beginner 
		public void select_Level() {
			try {
				
				if(!LevelBeginner.isSelected())
				{
					System.out.println("Beginner Level is clicked");
					LevelBeginner.click();
					screenShot("levelselect");
				}
				else {
					System.out.println("Beginner Level is not clicked");
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
	//select English language
		
		public void  lang_select()
		{
			try {
				fluentWait(LangEng);
				JavascriptExecutor js = (JavascriptExecutor)driver; 
				
				if(!LangEng.isSelected()) {
				js.executeScript("arguments[0].click();", LangEng);
				screenShot("language select");
				System.out.println("English Language is clicked");
				}
				else 
				{
					System.out.println("English Language is not clicked");
				}
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
		//scrolling up to the search bar
				public void scrolling_up() {
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			}
			
		Pattern pattern;
		String[] matches;
		
		
		public void getFirstCourseDetails() {
			
			try {
				 fluentWait(CourseName1);

				System.out.println("Name of the Course:" + CourseName1.getText());
				ExcelUtils.setcelldata(filepath, "WebDev courses", 2, 0, CourseName1.getText());
				fluentWait(rating1);
				System.out.println("Rating: " + rating1.getText());
				ExcelUtils.setcelldata(filepath, "WebDev courses", 2, 1, rating1.getText());
				pattern = Pattern.compile(".·.");
				matches = pattern.split(duration1.getText());

				System.out.println("Duration: " + matches[2].trim());
				ExcelUtils.setcelldata(filepath, "WebDev courses", 2, 2, matches[2].trim());
				screenShot("First WebDevelopment course");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		
		public void getSecondCourseDetails() {
			try {
				fluentWait(CourseName2);
				System.out.println("Name of the Course:" + CourseName2.getText());
				ExcelUtils.setcelldata(filepath, "WebDev courses", 3, 0, CourseName2.getText());
				fluentWait(rating2);
				System.out.println("Rating: " + rating2.getText());
				ExcelUtils.setcelldata(filepath, "WebDev courses", 3, 1, rating2.getText());
				pattern = Pattern.compile(".·.");
				matches = pattern.split(duration2.getText());

				System.out.println("Duration: " + matches[2].trim());
				ExcelUtils.setcelldata(filepath, "WebDev courses", 3, 2, matches[2].trim());
				screenShot("Second WebDevelopment course");

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		
		

	}


				
			


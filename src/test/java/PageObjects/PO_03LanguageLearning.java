package PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtils;




public class PO_03LanguageLearning extends BasePage {

	public PO_03LanguageLearning(WebDriver driver) 
	{
		super(driver);
	}
	
	
	
	String filepath= "C:\\Users\\2303457\\eclipse-workspace\\MyHackathon 3\\MyHackathon\\testdata\\Book.xlsx";

	//locators
	@FindBy(xpath="//input[@placeholder=\"What do you want to learn?\"]")
	WebElement inputBox;
	
	@FindBy(xpath="//button[@aria-label=\"Show more Language options\"]")
	WebElement langShowmore;
	
	@FindBy(xpath="(//div[@class='cds-227 cds-formGroup-groupWrapper'])[3]//div[contains(@class, 'css-zf4w52')]/label/span/span/input")
    List<WebElement> total_levels;
	

	@FindBy(xpath="//div[contains(@data-testid,'search-filter-group-Level')]//div[contains(@class,'css-wns57a')]//div[contains(@class,'cds-formGroup-groupWrapper')]//div[contains(@class,'css-zf4w52')]//label/div/span")
	List<WebElement> Alllevels;

	
	@FindBy(xpath="//div[@data-testid='scroll-container']/div[3]/button[1]") WebElement applybtn;
	
	@FindBy(xpath="//div[@aria-label='Select Language options']/div[1]/label/div/span") WebElement clickLang ;
	
	@FindBy(xpath="//h2[@role='heading']/div/span") WebElement heading;
	
	
	@FindBy(xpath = "//button[@aria-label=\"Clear all filters\"]") WebElement clearfilterElement;
	
	@FindBy(xpath = "//div[@aria-label='Select Language options']/div[2]/label/div/span") WebElement clickLang2;
	
	@FindBy(xpath="//div[@aria-label='Select Language options']/div[6]/label/div/span") WebElement clickLang3;
	
	@FindBy(xpath="//div[@aria-label='Select Language options']/div[4]/label/div/span") WebElement clickLang4;
	
	@FindBy(xpath = "//div[@aria-label='Select Language options']/div[5]/label/div/span") WebElement clickLang5;
	
	//search for Language Learning
	public void search_Languagelearning() throws InterruptedException, IOException {
		fluentWait(inputBox);
		PO_02WebdevelopmentPage cobj = new PO_02WebdevelopmentPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		inputBox.clear();
		inputBox.sendKeys("Language Learning");
		Thread.sleep(3000);
		screenShot("Language Learning");
		js.executeScript("arguments[0].click();", cobj.SearchButton);
		
	}
	
	public void clickShow_Languages() throws InterruptedException
	{
		//clicking on show more
		fluentWait(langShowmore);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", langShowmore);
		
	}
	
	//Printing total levels available
		public void select_levels() 
		{
			List<WebElement> totalLevels =  total_levels;
			for(int i=0;i<1;i++)
			{
				//checking if selected 
				if(!totalLevels.get(i).isSelected()) {
					totalLevels.get(i).click();
					System.out.println("Level Selected:"+totalLevels.get(i).getText());
				}
				
			}
		}
	
		//scrolling up
		public void scrolling_up() {
			
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			}
			
		public void LanguageOne() throws InterruptedException, IOException {
			
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
			List<WebElement> levels = waits.until(ExpectedConditions.visibilityOfAllElements(Alllevels));
			
			Boolean getLang = false;
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			
			
			int count=2 ;
			for(WebElement ls: levels) {
				Thread.sleep(3000);
			
				String firstLevel = ls.getText();
				
				js.executeScript("arguments[0].click();",ls);
				
				
				if(!getLang)
				{
			    clickShow_Languages();
				System.out.println("Language Learning");
				System.out.println("Language Clicked: "+clickLang.getText());
				
				ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 0,clickLang.getText());
				

				js.executeScript("arguments[0].click();",clickLang);
				getLang=true;
							
			
				fluentWait(applybtn);
				applybtn.click();
				
				}		
				
				Thread.sleep(8000);	
				scrolling_up();
				screenShot("First Filtered courses");
				
				System.out.println(getLang==true? "For: "+firstLevel:"");
				ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 1,firstLevel);
				Pattern pattern = Pattern.compile(" ");
				String[] matches;
				Thread.sleep(5000);
				matches = pattern.split(heading.getText());
				System.out.println("Total Count: "+matches[0].trim());	
				ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 2,matches[0].trim());
				js.executeScript("arguments[0].click();",ls);
				count++;
				}
			
			
			fluentWait(clearfilterElement);
			js.executeScript("arguments[0].click();",clearfilterElement);
		}
		
	public void LanguageTwo() throws InterruptedException, IOException {
			
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
			List<WebElement> levels = waits.until(ExpectedConditions.visibilityOfAllElements(Alllevels));
			
			Boolean getLang = false;
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			int count=7;
			for(WebElement ls: levels) {
				Thread.sleep(3000);
				
				String firstLevel = ls.getText();
				js.executeScript("arguments[0].click();",ls);
				
				
				if(!getLang)
				{
			    clickShow_Languages();
				System.out.println("Language Learning");
				System.out.println("Language Clicked: "+clickLang2.getText());
				ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 0,clickLang2.getText());

				js.executeScript("arguments[0].click();",clickLang2);
				getLang=true;
							
				
				fluentWait(applybtn);
				applybtn.click();
				
				}		
				
				Thread.sleep(8000);	
				
				scrolling_up();
				screenShot("Second Filtered courses");
				
				System.out.println(getLang==true? "For: "+firstLevel:"");
				ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 1,firstLevel);
				
				Pattern pattern = Pattern.compile(" ");
				String[] matches;
				Thread.sleep(5000);
				matches = pattern.split(heading.getText());
				System.out.println("Total Count: "+matches[0].trim());	
				ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 2,matches[0].trim());
				js.executeScript("arguments[0].click();",ls);
				count++;
				
			}
			
			fluentWait(clearfilterElement);
			js.executeScript("arguments[0].click();",clearfilterElement);
		}
	
	public void LanguageThree() throws InterruptedException, IOException {
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
		List<WebElement> levels = waits.until(ExpectedConditions.visibilityOfAllElements(Alllevels));
		
		Boolean getLang = false;
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		int count=12;
		for(WebElement ls: levels) {
			Thread.sleep(3000);
			
			String firstLevel = ls.getText();
			js.executeScript("arguments[0].click();",ls);
			
			
			if(!getLang)
			{
		    clickShow_Languages();
			System.out.println("Language Learning");
			System.out.println("Language Clicked: "+clickLang3.getText());
			ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 0,clickLang3.getText());
			

			js.executeScript("arguments[0].click();",clickLang3);
			getLang=true;
						
			
			fluentWait(applybtn);
			applybtn.click();
			
			}		
			
			Thread.sleep(8000);	
			
			scrolling_up();
			screenShot("Third Filtered courses");
			
			System.out.println(getLang==true? "For: "+firstLevel:"");
			ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 1,firstLevel);
			
			Pattern pattern = Pattern.compile(" ");
			String[] matches;
			Thread.sleep(5000);
			matches = pattern.split(heading.getText());
			System.out.println("Total Count: "+matches[0].trim());
			ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 2,matches[0].trim());
			js.executeScript("arguments[0].click();",ls);
			count++;
			
		}
		
		fluentWait(clearfilterElement);
		js.executeScript("arguments[0].click();",clearfilterElement);
	}
	
public void LanguageFour() throws InterruptedException, IOException {
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
		List<WebElement> levels = waits.until(ExpectedConditions.visibilityOfAllElements(Alllevels));
		
		Boolean getLang = false;
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		int count=17;
		for(WebElement ls: levels) {
			Thread.sleep(3000);
			
			String firstLevel = ls.getText();
			js.executeScript("arguments[0].click();",ls);
			
			
			if(!getLang)
			{
		    clickShow_Languages();
			System.out.println("Language Learning");
			System.out.println("Language Clicked: "+clickLang4.getText());
			ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 0,clickLang4.getText());
			

			js.executeScript("arguments[0].click();",clickLang4);
			getLang=true;
						
			
			fluentWait(applybtn);
			applybtn.click();
			
			}		
			
			Thread.sleep(8000);	
			
			scrolling_up();
			screenShot("Fourth Filtered courses");
			
			System.out.println(getLang==true? "For: "+firstLevel:"");
			ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 1,firstLevel);
			
			Pattern pattern = Pattern.compile(" ");
			String[] matches;
			Thread.sleep(5000);
			matches = pattern.split(heading.getText());
			System.out.println("Total Count: "+matches[0].trim());
			ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 2,matches[0].trim());
			js.executeScript("arguments[0].click();",ls);
			count++;
			
		}
		
		fluentWait(clearfilterElement);
		js.executeScript("arguments[0].click();",clearfilterElement);
	}

public void LanguageFive() throws InterruptedException, IOException {
	
	WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
	List<WebElement> levels = waits.until(ExpectedConditions.visibilityOfAllElements(Alllevels));
	
	Boolean getLang = false;
	JavascriptExecutor js = (JavascriptExecutor)driver; 
	int count=23;
	for(WebElement ls: levels) {
		Thread.sleep(3000);
		
		String firstLevel = ls.getText();
		js.executeScript("arguments[0].click();",ls);
		
		
		if(!getLang)
		{
	    clickShow_Languages();
		System.out.println("Language Learning");
		System.out.println("Language Clicked: "+clickLang5.getText());
		ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 0,clickLang5.getText());
		

		js.executeScript("arguments[0].click();",clickLang5);
		getLang=true;
					
		
		fluentWait(applybtn);
		applybtn.click();
		
		}		
		
		Thread.sleep(8000);	
		
		scrolling_up();
		screenShot("Fifth Filtered courses");
		System.out.println(getLang==true? "For: "+firstLevel:"");
		ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 1,firstLevel);
		
		Pattern pattern = Pattern.compile(" ");
		String[] matches;
		Thread.sleep(5000);
		matches = pattern.split(heading.getText());
		System.out.println("Total Count: "+matches[0].trim());	
		ExcelUtils.setcelldata(filepath, "LangLearn courses", count, 2,matches[0].trim());
		js.executeScript("arguments[0].click();",ls);
		count++;
		
	}
	
	fluentWait(clearfilterElement);
	js.executeScript("arguments[0].click();",clearfilterElement);
}
}

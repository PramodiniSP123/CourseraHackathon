package PageObjects;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {
	
	WebDriver driver;
	
	//constructor
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//method to scroll to the webElement
	public void Scrollby(WebElement tothisElement)
	{
		Actions action = new Actions(driver);
		action.moveToElement(tothisElement).build().perform();
	}
	
	
	
	public void screenShot(String ss) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\2303457\\eclipse-workspace\\MyHackathon 3\\MyHackathon\\Screenshots\\" + ss + ".png");

		FileUtils.copyFile(src, trg);
	}

	public void scroll(WebElement toThisElement) {
		Actions ac = new Actions(driver);
		ac.scrollToElement(toThisElement);
	}

	
	//method to scroll to the bottom of the WebPage
	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}



	public void fluentWait(WebElement fwElement) {
		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver);
		fw.withTimeout(Duration.ofSeconds(10));
		fw.pollingEvery(Duration.ofSeconds(1));
		fw.ignoring(NoSuchElementException.class);	
		fw.until(ExpectedConditions.visibilityOf(fwElement));
	}

}

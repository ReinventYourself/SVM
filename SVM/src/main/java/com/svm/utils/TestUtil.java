package com.svm.utils;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.model.Log;
import com.svm.core.CoreClass;

public class TestUtil extends CoreClass {

	//public static FluentWait<WebDriver> wait;
	
	public void switchToFrame(String element)
	{
		driver.switchTo().frame(element);
	}
	
	
	  public void SelectValuesFromList (List<WebElement> ele, String value)
	  {
		 int flag =0; 
	    int count= ele.size();
	    System.out.println(count);
	    
	    for(int i=0;i<ele.size();i++)
		 {
			String optiontext= ele.get(i).getText();
			System.out.println(optiontext);
			if(optiontext.equals(value))
			{ flag=1;
				ele.get(i).click();
				break;
			}
		
		 }
		 if(flag==0)
		 {
			 System.out.println("Element is not available in the list");
		 }
		 
	   	  }
	  
	  public void waitForElementToBeVisible(WebDriver driver, List<WebElement>  ele) {
		    WebDriverWait wait = new WebDriverWait(driver, 60);
		     wait.until(ExpectedConditions.visibilityOfAllElements(ele));
		     }
		  
		     public WebElement waitForElementToBeVisible(WebElement ele) {
				    WebDriverWait wait = new WebDriverWait(driver, 60);
				     wait.pollingEvery(5, TimeUnit.SECONDS);
				     wait.until(ExpectedConditions.elementToBeClickable(ele));
				     return ele;
		     }
		     
		     
		  public void ClickbyAction(WebElement ele)
		  {
			  Actions action = new Actions(driver);
			  action.moveToElement(ele).click().perform();
		  }
			
		  public void ClickbyJavaScript(WebElement ele)
		  {
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			 // js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
			  js.executeScript("arguments[0].click();",ele);
			  
		  }
		  
	public void selectvaluefromdrop(WebElement ele, String value)
	{
		Select dd = new Select(ele);
		dd.selectByVisibleText(value);
		
	}	
	
	//Get Screenshot
		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}  
  
	
		     
		}
	

	
	
	
	
	


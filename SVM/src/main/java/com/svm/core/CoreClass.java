package com.svm.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.svm.utils.TestUtil;
import com.svm.utils.Xls_Reader;

public class CoreClass {

	public static WebDriver driver = null;
	public static Properties prop;
	public static Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir") + "\\src\\main\\resources\\testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentReports extent;
	public static ExtentTest extentTest;

  public CoreClass() 
   {
	prop = new Properties();
	FileInputStream FIS;
	try {
		FIS = new FileInputStream(System.getProperty("user.dir")
				+"//src//main//java//com//svm//config//Configuration.properties");
		
		prop.load(FIS);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
  
  @BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/SVMTestAutomationReport.html", true);
      extent.addSystemInfo("Host Name", "SEZ-10.india.rsystems.com");
		extent.addSystemInfo("User Name", System.getProperty("user.name"));
		extent.addSystemInfo("Environment", "QA");

	}

	@AfterTest
	public void endReport() {
		extent.flush();
		//extent.close();
	}
  
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS:- " + result.getName());
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS:- " + result.getThrowable());
            String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS:- " + result.getName());}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS:- " + result.getName());

		}
		extent.endTest(extentTest);	
	}
  
public void InitDriver()
{
	if(prop.getProperty("Browser").equals("FireFox"))
		driver = new FirefoxDriver();
	
	if(prop.getProperty("Browser").equals("chrome"))
{
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
       		+"//src//main//resources//chromedriver.exe");	
		driver= new ChromeDriver();
		log.debug("Browser launch successfully");
	}

driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get(prop.getProperty("QAUrl"));
}

}


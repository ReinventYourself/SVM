package com.svm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.svm.core.CoreClass;
import com.svm.pages.HomePage;
import com.svm.pages.LoginPage;
import com.svm.pages.OrderSearch;

public class HomepageTest extends HomePage {

	HomePage homepage;
	LoginPage loginpage;
	OrderSearch ordersearch;
	LoginpageTest loginpagetest;
	public HomepageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		InitDriver();
		loginpage = new LoginPage();
		homepage = new HomePage();
		loginpagetest = new LoginpageTest();
		loginpagetest.verifyLogin();
				
		
	}
	
	@Test
	public void ValidatepageTitle()
	{

		   extentTest = extent.startTest("ValidateHomepageTitle");
		
    String homepageTitle=homepage.ValidateHomePageTitle();
    Assert.assertEquals(homepageTitle, "SVM Enterprise Admin Portal");
	}
	
	@Test
	public void ValidateWelcomeImg()
	{
		 extentTest = extent.startTest("ValidateHomeWelcomeImage");
			
	boolean flag=homepage.ValidateWelcomeNote();
	homepage.welcomemsg.getText().contains("Welcome");
	}
	
	@Test
	public void verifyOrderTile()
	{
		 extentTest = extent.startTest("VerifyOrderTile");
			
	boolean flag=homepage.ValidateOrderTile();	
	Assert.assertTrue(flag);
	}
	
	@Test
	public void verifyClickOnOrder() throws InterruptedException
	{
		 extentTest = extent.startTest("VerifyClickOnOrderTile");
			
	ordersearch =	homepage.ClickOnOrderTile();
	Thread.sleep(10000);
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	}
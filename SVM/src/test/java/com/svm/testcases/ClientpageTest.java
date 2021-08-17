package com.svm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.svm.pages.ClientPage;

public class ClientpageTest extends ClientPage {

	LoginpageTest loginpagetest;
	ClientPage clientpage;
	public ClientpageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		InitDriver();
		clientpage = new ClientPage();
		loginpagetest = new LoginpageTest();
		//loginpagetest.verifyLogin();
		}
	
	@Test
	public void CreateClient() throws InterruptedException
	{

		   extentTest = extent.startTest("VerifyClientCreation");
		loginpagetest.verifyLogin();
		clientpage.ClickonClient();
		//Thread.sleep(10000);
		clientpage.ClickonCreateClient();
		clientpage.EnterClientName("Auto"+System.currentTimeMillis());
		clientpage.SelectClienttype("Program");
		clientpage.EnterEmail("gaurav.sharma1@rsystems.com");
		clientpage.EnterPhone("8130788778");
		clientpage.EnterAddress("AutoNoida");
		clientpage.Clickonsubmit();
		//Assert.assertEquals("Your Client has been created successfully.", clientpage.Confirmatontxt.getText());
		clientpage.ClickonOK();
	
	}
	
	   
	@AfterMethod
	public void teardown() {
	   driver.quit();
	}    	

	
	
}

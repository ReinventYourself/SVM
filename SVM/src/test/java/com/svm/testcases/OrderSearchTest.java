package com.svm.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.svm.core.CoreClass;
import com.svm.pages.HomePage;
import com.svm.pages.LoginPage;
import com.svm.pages.OrderSearch;
import com.svm.utils.TestUtil;

public class OrderSearchTest extends CoreClass {

	LoginPage login;
	HomePage homepage;
	OrderSearch OS;
	TestUtil util;
	public OrderSearchTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		InitDriver();
	 login = new LoginPage();
        OS = new OrderSearch();
        util=new TestUtil();
	}
	
	@Test
	public void listoptions() throws InterruptedException
	{
	
	homepage =	login.Login("Adminuser", "qazwsxed123!");
	homepage.ClickOnOrderTile();
	util.waitForElementToBeVisible(driver, OS.dateoptions);
	Thread.sleep(10000);
    OS.selectDate_OrderSearch("January");
    OS.selectPayment_OrderSearch("EFT");
    
	}
	}


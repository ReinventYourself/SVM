package com.svm.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.svm.core.CoreClass;
import com.svm.pages.HomePage;
import com.svm.pages.LoginPage;

public class LoginpageTest extends LoginPage {

	LoginPage loginpage ;
	HomePage homepage;
	public LoginpageTest() {
	       super();
	// loginpage = new LoginPage();
	}
	
    @BeforeMethod
	public void setup(){
    InitDriver();
   	 loginpage = new LoginPage();
    }
    
   @Test
    public void loginpageTitleTest()
    {
	   extentTest = extent.startTest("VerifyLoginPageTitle");
    String title=loginpage.ValidateLoginpageTitle();
    Assert.assertEquals(title, "SVM Enterprise Admin Portal");
    }
    
    @Test
    public void loginpageimgTest()
    {
    	 extentTest = extent.startTest("VerifyLoginPageImage");
        boolean flag= loginpage.ValidateLoginpageImage();
    	Assert.assertTrue(flag);
    }
    
    
   @Test
   public void verifyLogin()  {

	   extentTest = extent.startTest("VerifyLogin");
		 loginpage = new LoginPage();	   
	   homepage = loginpage.Login(excel.getCellData("LoginTest","UserName", 2), 
    		excel.getCellData("LoginTest","Password",2));
	    //Thread.sleep(1000);
	    Assert.assertTrue(homepage.SignoutBtn.getText().contains("Sign Out"));
	    log.debug("Login success");
	   
	   }
   
@AfterMethod
public void teardown() {
  driver.quit();
}    	

}

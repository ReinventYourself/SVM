package com.svm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import com.svm.core.CoreClass;
import com.svm.utils.TestUtil;

public class LoginPage extends TestUtil {
	
	@FindBy(name = "userName")
	WebElement username;
	
	@FindBy(name= "password")
	WebElement Password;

	@FindBy(id= "Submitlogin")
	WebElement Loginbtn;
	
	@FindBy(xpath="//img[@src='assets/images/logo_svm.png']")
	WebElement Logoimg;
	
	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

//=====================Actions====================	
	
	public String ValidateLoginpageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean ValidateLoginpageImage()
	{
		
	   return Logoimg.isDisplayed();
	}

	public HomePage Login(String un, String Pwd)	
	{
			username.clear();
			username.sendKeys(un);
			Password.clear();
		    Password.sendKeys(Pwd);
			Loginbtn.click();
			return new HomePage();
			
}

}
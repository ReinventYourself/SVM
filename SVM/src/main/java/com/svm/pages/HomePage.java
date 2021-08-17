package com.svm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.svm.core.CoreClass;
import com.svm.utils.TestUtil;

public class HomePage extends TestUtil {
@FindBy(xpath= "//h2[contains(text(), 'Welcome')]")
public WebElement welcomemsg;
@FindBy(xpath= "//p[text()='Order']")
WebElement ordertile;
@FindBy(xpath= "//p[text()='PAYMENT & SHIPPING']")
WebElement payment_shipping;
@FindBy(xpath= "//p[text()='Agent Tool']")
WebElement agenttooltile;
	
	@FindBy(xpath= "//p[text()='Fulfillment']")
	WebElement Fulfillmenttile;
	
	@FindBy(xpath= "//p[text()='Program']")
	WebElement programtile;

	@FindBy(xpath= "//p[text()='Client']")
	WebElement clienttile;

	@FindBy(xpath= "//p[text()='VENDOR']")
	WebElement vendortile;

	@FindBy(xpath= "//p[text()='Product']")
	WebElement producttile;
	
	@FindBy(xpath = "//div[text()= 'Sign Out']")
	public WebElement SignoutBtn;
	public HomePage()
	{
		
		PageFactory.initElements(driver, this);
	}

public boolean ValidateWelcomeNote()
{
	return welcomemsg.isDisplayed();
}


public String ValidateHomePageTitle()
{
String homepagetitle= driver.getTitle();
return homepagetitle;
}

public boolean ValidateOrderTile()
{

	 return ordertile.isDisplayed();
}

public boolean ValidateProgramTile()
{

return programtile.isDisplayed();
}

public boolean ValidateclientTile()
{

return clienttile.isDisplayed();
}

public OrderSearch ClickOnOrderTile()
{
ordertile.click();
return new OrderSearch();
}

public ClientPage ClickOnClientTile()
{
clienttile.click();
return new ClientPage();
}

}

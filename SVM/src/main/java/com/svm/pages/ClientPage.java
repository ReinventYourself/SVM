package com.svm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.svm.core.CoreClass;
import com.svm.utils.TestUtil;

public class ClientPage extends TestUtil {

	@FindBy(xpath="//p[text()='Client']")
	public WebElement clientTile;
	
	@FindBy(xpath= "//button[text()=' Create Client ']")
	public WebElement CreateClientBtn;
	
	@FindBy(xpath= "//h2[text()='NEW CLIENT']")
	public WebElement NewClientLabel;
	
	@FindBy(xpath = "//input[@formcontrolname='name']")
	public WebElement ClientNameTxtBox;
	
	@FindBy(xpath= "//select[@formcontrolname='clientType']")
	public WebElement ClientTypeDD;
	
	@FindBy(xpath= "//input[@formcontrolname='toEmail']")
	public WebElement EmailTxtBox;
	
	@FindBy(xpath="//div/p-inputmask/input")
	public WebElement PhonenumberTxt;
	
	@FindBy(xpath= "//input[@formcontrolname='address']")
	public WebElement AddressTxt;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitBtn;
	
	@FindBy(xpath="//div[text()='Your Client has been created successfully.']")
	public WebElement Confirmatontxt;
	
	
	
	@FindBy(xpath= "//button[text()=' Ok ']")
	public WebElement okbtn;
	public ClientPage()
	{
		PageFactory.initElements(driver, this);
		
	}
 
//====================================================	

public void ClickonClient()
{

	waitForElementToBeVisible(clientTile).click();	

}

public void ClickonCreateClient() {
	
	//ClickbyAction(CreateClientBtn);
	ClickbyJavaScript(CreateClientBtn);
}

public void EnterClientName(String name)
{
	waitForElementToBeVisible(ClientNameTxtBox).sendKeys(name);
}

public void SelectClienttype(String value)
{
	selectvaluefromdrop(waitForElementToBeVisible(ClientTypeDD), value);
}
	
public void EnterEmail(String value)
{
	waitForElementToBeVisible(EmailTxtBox).clear();
	waitForElementToBeVisible(EmailTxtBox).sendKeys(value);
}

public void EnterPhone(String value)
{
	waitForElementToBeVisible(PhonenumberTxt).clear();
	waitForElementToBeVisible(PhonenumberTxt).sendKeys(value);
}

public void EnterAddress(String value)
{
	waitForElementToBeVisible(AddressTxt).clear();
	waitForElementToBeVisible(AddressTxt).sendKeys(value);
}

public void Clickonsubmit()
{
	waitForElementToBeVisible(SubmitBtn).click();
	
}

public void ClickonOK()
{
	waitForElementToBeVisible(okbtn).click();
}
}

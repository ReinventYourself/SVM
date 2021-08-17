package com.svm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.svm.core.CoreClass;
import com.svm.utils.TestUtil;

public class OrderSearch extends CoreClass {
	
	@FindBy(xpath= "//span[text()='Search']")
	WebElement ordersearchbreadcrumb;

	@FindBy(xpath= "//form/div[2]/div/button")
	WebElement searchbutton;
	
	@FindBy(xpath= "//label[text()='Order Date']")
	WebElement orderdateradiobtn;
	
	@FindBy(xpath= "//label[text()='Update Date']")
	WebElement updateradiobtn;
	
//public By dateoptions = By.xpath("//div[1]/p-listbox/div/div[3]/ul/li");
//public By paymentoptions= By.xpath("//div[3]/p-listbox[1]/div/div[3]/ul/li");

   @FindBy(xpath = "//div[1]/p-listbox/div/div[3]/ul/li")
   public List<WebElement> dateoptions;
   

   @FindBy(xpath = "//div[3]/p-listbox[1]/div/div[3]/ul/li")
   public List<WebElement> paymentoptions;


   public OrderSearch()
   {
	   PageFactory.initElements(driver, this);
	   
   }
   
  TestUtil util = new TestUtil();
 
  public void selectDate_OrderSearch(String value)
{
try {
	util.SelectValuesFromList(dateoptions, value);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

public void selectPayment_OrderSearch(String value)
{
try {
	util.SelectValuesFromList(paymentoptions, value);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

public void ClickonSearchbtn()
{
	util.waitForElementToBeVisible(driver, searchbutton).click();
	
}


	}

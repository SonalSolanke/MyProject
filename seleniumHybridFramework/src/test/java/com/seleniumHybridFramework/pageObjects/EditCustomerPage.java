package com.seleniumHybridFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver driver;
	public EditCustomerPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Edit Customer']")
	WebElement EditCustLink;
	
	@FindBy(name="cusid")
	WebElement CustomerID;
	
	@FindBy(name="AccSubmit")
	WebElement EditCustSubmitBtn;

	
	
	
	public void cliclOnEditCustLink() {
		EditCustLink.click();
	}
	
	public void enterCustIdToEdit(String custid) {
		CustomerID.sendKeys(custid);
	}
	
	public void submitBtnClick() {	
		EditCustSubmitBtn.click();
	}
}



package com.seleniumHybridFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAccountPage {

	WebDriver driver;
	
	public AddAccountPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='New Account']")
	WebElement addAccountlink;
	
	
	@FindBy(name="cusid")
	WebElement customerID;
	
	@FindBy(name="selaccount")
	WebElement selectAccType;
	
	@FindBy(name="inideposit")
	WebElement initialDeposit;
	
	@FindBy(name="button2")
	WebElement submitBtn;
	
	public void addNewAccLinkClick() {
		addAccountlink.click();	
	}
	
	public void enterCustID(String custID) {
		customerID.sendKeys(custID);
	}
	
	public void selectAccType(String accTypeVal) {
		
		Select sel= new Select(selectAccType);
		sel.selectByValue(accTypeVal);		
	}
	
	public void setInitialDeposit(int initialDep) {
		initialDeposit.sendKeys(String.valueOf(initialDep));
	}
	
	public void submitData() {
		submitBtn.click();
	}
	
	
	
	
}

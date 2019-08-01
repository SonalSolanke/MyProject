package com.seleniumHybridFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {
	
	WebDriver driver;
	public DeleteAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Delete Account']")
	WebElement deleteAccountlink;
	
	@FindBy(name="accountno")
	WebElement accountNo;
	
	@FindBy(name="AccSubmit")
	WebElement submitBtn;
	
	public void clickOnDeleteAccount() {
		deleteAccountlink.click();	
	}
	
	public void enterAccNOToDelete(String accNO) {
		accountNo.sendKeys(accNO);
	}
	
	public void submitBtnClick() {
		submitBtn.click();
	}

}

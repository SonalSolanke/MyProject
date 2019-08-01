package com.seleniumHybridFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	WebDriver driver;
	
	public AddNewCustomerPage(WebDriver driver) {
		this .driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement linkAddnewCust;
	
	@FindBy(name="name")
	WebElement customerName;
	
	@FindBy(xpath="//input[@name='rad1']")
	WebElement radioBtnGender;

	@FindBy(id="dob")
	WebElement dateOfBirth;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pinno;
	
	@FindBy(name="telephoneno")
	WebElement telephoneno;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitBtn;
	
	//methods
	
	public void addCustomerLinkClick() {
		linkAddnewCust.click();
	}
	
	public void addCustomerName(String cName) {
		customerName.sendKeys(cName);
	}

	public void setCustGender() {
		radioBtnGender.click();
	}
	
	public void setDOB(String dd, String mm, String yyyy) {
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(yyyy);
	}
	
	public void addAddress(String addr) {
		address.sendKeys(addr);
	}
	
	public void addCity(String cityName) {
		city.sendKeys(cityName);
	}
	
	public void addState(String stateName) {
		state.sendKeys(stateName);
	}
	
	public void addPinNo(String pinNo) {
		pinno.sendKeys(pinNo);
	}
	
	/* If pin no is integer-as sendkeys accept only string
	public void addPinNo(int pinNo) {
		pinno.sendKeys(String.valueOf(pinNo));
	}
	*/
	
	public void addPhoneNo(String phoneNo) {
		telephoneno.sendKeys(phoneNo);
	}
	
	public void addEmailId(String emailId) {
		emailid.sendKeys(emailId);
	}
	
	public void addPasswordx(String passwordAdd) {
		password.sendKeys(passwordAdd);
	}	
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
}

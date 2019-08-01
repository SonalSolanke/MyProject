package com.seleniumHybridFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //page obj class
	
	WebDriver driver;  
	//create constructor for LoginPage class
	
	public LoginPage(WebDriver driver){
		this.driver=driver; //initiate driver
		
		//specify the page factory class
		
		PageFactory.initElements(driver, this);
			
	}
	
	//identify all the page elements
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(name="btnReset")
	WebElement btnReset;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logoutLink;
	
	
	public void setUserName(String uName) {
		txtUserName.sendKeys(uName);
	}
	
	public void setPassword(String uPassword) {
		txtPassword.sendKeys(uPassword);
	}
	
	public void loginBtnClick() {
		btnLogin.click();
	}
	
	public void resetBtnClick() {
		btnReset.click();
	}
	
	public void logoutApplication() {
		logoutLink.click();
	}
	
	
	

}

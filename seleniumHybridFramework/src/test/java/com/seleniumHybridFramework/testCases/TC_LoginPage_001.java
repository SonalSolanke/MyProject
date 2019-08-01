package com.seleniumHybridFramework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumHybridFramework.pageObjects.LoginPage;

public class TC_LoginPage_001 extends BaseClass {
	
	@Test
	public void LoginApplication() throws IOException {
		
		logger.info("URL is opened");
		
		LoginPage lpage = new LoginPage(driver);
		lpage.setUserName(userName);
		logger.info("Entered username");
		
		lpage.setPassword(password);
		logger.info("Entered password");
		
		lpage.loginBtnClick();
		logger.info("Clicked on login button");
		
		//check if home page is displayed after login
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePag")) {
			Assert.assertTrue(true);
			logger.info("Home page opened. Login test passed");
		}
		else {
			
			CaptureScreen(driver,"LoginTest");
			logger.info("Failed login. Home page not opened");
			Assert.assertTrue(false);
			
		}
		}
	

}

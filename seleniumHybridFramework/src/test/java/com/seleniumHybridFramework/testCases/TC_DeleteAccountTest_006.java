package com.seleniumHybridFramework.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.seleniumHybridFramework.pageObjects.DeleteAccountPage;

import junit.framework.Assert;

public class TC_DeleteAccountTest_006 extends BaseClass {
	
	@Test
	public void DeleteAccount() throws InterruptedException, IOException {
		
		TC_AddNewAccount_005 obj1= new TC_AddNewAccount_005();
		obj1.addNewCustomer();
		String str= obj1.getNewAccNo();
		
		System.out.println("Acc no obtained from add new acc test:  "+str);
		
		DeleteAccountPage DP=new DeleteAccountPage(driver);
		
		DP.clickOnDeleteAccount();
		logger.info("Clicked on delete account link");
		
		DP.enterAccNOToDelete(str);
		logger.info("Entered acc no to delete");
		
		DP.submitBtnClick();
		logger.info("Submit button clicked");
		
		if(isAlertPresent()) {
			
		driver.switchTo().alert().accept();
		
		String str1=driver.switchTo().alert().getText();
		System.out.println("Alert content is:  "+str1);
		
		logger.info("Accepted delete account alert");
		Thread.sleep(500);
		}
		
		if(isAlertPresent()) {
		driver.switchTo().alert().accept();

		String str2=driver.switchTo().alert().getText();
		System.out.println("Alert content is:  "+str2);
		
		logger.info("Moved to second alert");
		Thread.sleep(500);
		
		}
		
		if (driver.getPageSource().contains("Welcome To Manager's Page of Guru99 Bank")) {
			Assert.assertTrue(true);
			logger.info("Account deleted successfully");
			
		}
		else {
			
			logger.info("Error in deleting account. Plesae check");
			Assert.assertTrue(false);
		}
		
			
	}
	

	}
	
	



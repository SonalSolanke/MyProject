package com.seleniumHybridFramework.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumHybridFramework.pageObjects.AddAccountPage;
import com.seleniumHybridFramework.pageObjects.LoginPage;

public class TC_AddNewAccount_005 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException{
		
		TC_AddNewCustomerTest_003 obj1= new TC_AddNewCustomerTest_003();
		
		obj1.addNewCustomer();
		String str= obj1.getCustID();
		
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		AddAccountPage acc= new AddAccountPage(driver);
		
		logger.info("Add account Functionality Check: ");
		
		acc.addNewAccLinkClick();
		logger.info("Clicked on add account link successfully");
		
		acc.enterCustID(str);
		logger.info("Entered cust ID ");
		
		System.out.println("Custo ID got is " +str);
		
		acc.selectAccType("Current");
		logger.info("Enter the Acc type to select");
		
		
		acc.setInitialDeposit(1000);
		logger.info("Enter initial deposit amount");
		
		acc.submitData();
		logger.info("New account data submitted");
		
		
		if(driver.getPageSource().contains("Account Generated Successfully!!!")) {
			Assert.assertTrue(true);
			logger.info("New account created successfully");
			
		}
		else {
			
			logger.info("Error in creating new account. Please check");
			Assert.assertTrue(false);
		}
		
		String newAcc= getNewAccNo();
		System.out.println("Newly created acc no is: " + newAcc);
		
		getNewAccData();
	}
	
	public String getNewAccNo() {
		return driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText();
		
	}
	
	
	public void getNewAccData() {
		
		int rowCount= driver.findElements(By.xpath("//table[@name='account']/tbody/*")).size();
		System.out.println("Rowcount of Account table is: "+rowCount);
		
		int colCount= driver.findElements(By.xpath("//table[@name='account']/tbody/tr[4]/*")).size();
		System.out.println("Colcount of Account table is: "+ colCount);
		
		for(int i=4; i<rowCount ; i++) {
			
			for(int j=1; j<=colCount ; j++) {
				String val1= driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(val1 + "     ");
				
				//To find specific column and its value 
				/*
				String ele= driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr["+i+"]/td[1]")).getText();
			
				if( ele.equalsIgnoreCase("Customer ID")) {
					String val= driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr["+i+"]/td[2]")).getText();
					System.out.print(ele + "     val is:   "+ val);
					break;
				}
				*/
			}
			
			System.out.println();
		}
		
	}
	
}

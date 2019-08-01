package com.seleniumHybridFramework.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumHybridFramework.pageObjects.AddNewCustomerPage;
import com.seleniumHybridFramework.pageObjects.LoginPage;

public class TC_AddNewCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lpage = new LoginPage(driver);
		lpage.setUserName(userName);
		logger.info("Entered username");
		
		lpage.setPassword(password);
		logger.info("Entered password");
		
		lpage.loginBtnClick();
		logger.info("Clicked on login button");
		
		Thread.sleep(5000);
		
		logger.info("Navigate to add customer flow");
		AddNewCustomerPage addCust= new AddNewCustomerPage(driver);
		
		addCust.addCustomerLinkClick();
		Thread.sleep(5000);
		
		addCust.addCustomerName("sonal");
		
		addCust.setCustGender();
		
		addCust.setDOB("17", "05", "2016");
		
		addCust.addAddress("Pune Maharashtra");
		
		addCust.addCity("Pune");
		
		addCust.addState("Maharashtra");
		
		addCust.addPinNo("411102");
		
		addCust.addPhoneNo(randomNumber(10));
		
		addCust.addEmailId(randonString(6) + "@gmail.com");  // as email iod shgould not be repearted here
		
		addCust.addPasswordx("Abcd123");
		Thread.sleep(6000);
		logger.info("All Fields Added Successfully");
		addCust.clickSubmitBtn();
		Thread.sleep(6000);
		
		logger.info("Successfylly submitted data");
		
		boolean val= driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(val==true) {
			
			Assert.assertTrue(true);
			logger.info("Customer registered Successfully");
		}	
		else {
			CaptureScreen(driver, "addNewCustomer");
			logger.info("Error in registering customer. please check");
			Assert.assertTrue(false);	
		}
		
		String CustID= getCustID();
		System.out.println("Newly created Customer ID ia : "+ CustID);
		
		getNewCustomerData();
		
		
	}
	
	public String getCustID() {
		return driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();		
		
	}
	
	
	public void getNewCustomerData() {
		
		int rowCount= driver.findElements(By.xpath("//table[@name='customer']/tbody/*")).size();
		System.out.println("Rowcount is: "+rowCount);
		
		int colCount= driver.findElements(By.xpath("//table[@name='customer']/tbody/tr[4]/*")).size();
		System.out.println("Colcount is: "+ colCount);
		
		for(int i=4; i<rowCount ; i++) {
			
			for(int j=1; j<=colCount ; j++) {
				String val1= driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
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

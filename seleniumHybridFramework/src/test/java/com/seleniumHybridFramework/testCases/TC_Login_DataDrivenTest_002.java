package com.seleniumHybridFramework.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumHybridFramework.pageObjects.LoginPage;
import com.seleniumHybridFramework.utilities.XLUtils;

public class TC_Login_DataDrivenTest_002 extends BaseClass{
	
	
	//write test method and data provider method (to create 2D array same as excel. Read data from excel and store in 2D array)
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) {
		
		//to read array data and use multiple times
		
		LoginPage lp= new LoginPage(driver);  //use page obj class
		lp.setUserName(user);
		logger.info("DDT user is provided");
		
		lp.setPassword(pwd);
		logger.info("DDT password is provided");   //data driver test
		
		lp.loginBtnClick();
		//for invalid login alert popup will open. check that first. Create a method to check if alert is present
		
		if(isASlrtPresent()==true) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(false);                //failed login test case
			logger.warn("Login failed due to invalid credentials");
			
		}
		else {
			//login successful scenario - logout-accept alert  present-login again
			Assert.assertTrue(true);
			logger.info("Successful login");
			
			lp.logoutApplication();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}
		
	@DataProvider(name= "LoginData")
	String [][] getData() throws IOException{
		
		String path= System.getProperty("user.dir") + "/src/test/java/com/seleniumHybridFramework/testData/LoginData.xlsx" ;
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount= XLUtils.getCellCount(path, "Sheet1",1);
		
		String loginData[][]=new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++) {
			
			for(int j=0; j<colcount; j++){
				
				//if in xcel row no=1, in array index is 0 (i-1) . But col index is same
				
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);  //excel 1,0 stored to array 0,0
			}
			
		}
		
		return loginData;
	}

	
	public boolean isASlrtPresent() {            //this method can b put in base class if need to reuse
		
		try {					// if alert present, switch to alert. Throw exception if alert is not present
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;				//no alert. successful login
		}
		
	}
	
	
}

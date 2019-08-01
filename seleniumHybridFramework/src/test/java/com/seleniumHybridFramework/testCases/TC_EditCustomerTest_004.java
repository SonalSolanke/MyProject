package com.seleniumHybridFramework.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.seleniumHybridFramework.pageObjects.EditCustomerPage;

public class TC_EditCustomerTest_004 extends BaseClass {
	
	@Test
	public void EditCustomer() throws InterruptedException, IOException {
		
	TC_AddNewCustomerTest_003 obj1= new TC_AddNewCustomerTest_003();
	obj1.addNewCustomer();
	String CustId=obj1.getCustID();
	
	EditCustomerPage EC= new EditCustomerPage(driver);
	
	EC.cliclOnEditCustLink();
	
	EC.enterCustIdToEdit(CustId);
	
	EC.submitBtnClick();
	}
}

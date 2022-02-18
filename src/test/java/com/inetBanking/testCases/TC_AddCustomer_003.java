package com.inetBanking.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;




public class TC_AddCustomer_003 extends BaseClass {
	
	@Test
	public void addCustomer() throws InterruptedException, IOException {
		
		// to login
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(2000);
		
		
		//add customer
		AddCustomerPage ac = new AddCustomerPage(driver);
		
		ac.clickAddCustomer();
		
		ac.setAddress("new york");
		ac.setCity("hyd");
		ac.setDob("23", "09", "1994");
		ac.setCustomerName("Raghav");
		ac.setEmail(randomName());
		ac.clickGender();;
		ac.setNumber("9856874589");
		ac.setpin(500365);
		ac.setPwd("123456");
		ac.setstate("AP");
		logger.info("Entered details!!!!!");
		ac.clickSubmit();
		
		
		Thread.sleep(2000);
		
		logger.info("validation started");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true) {
			Assert.assertTrue(true);
			logger.info("Added customer");
		}else {
			getScreenshot(driver, "addCustomer");
			Assert.assertTrue(false);
			logger.info("Added customer failed !!!!!!!");
		}
	}
	
	

}

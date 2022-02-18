package com.inetBanking.testCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws IOException {
		
		
		LoginPage lp = new LoginPage(driver);
		logger.info("browser opened");
		lp.setUserName(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			getScreenshot(driver, "LoginTest");
			logger.info("Screenshot Taken");
			Assert.assertTrue(false,"Title Mismatched:");
			logger.info("Login test failed");
		}
	}
	
	

}

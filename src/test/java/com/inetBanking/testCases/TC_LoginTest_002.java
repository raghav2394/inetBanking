package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginTest_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		logger.info("details entered");
		lp.clickSubmit();
		Thread.sleep(2000);

		if (isAlertpresent() == true) {
			logger.info("Login failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		} else {
			logger.info("Login Success");
			Assert.assertTrue(true);
			Thread.sleep(2000);
			lp.clicklogout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertpresent() {

		try {
			driver.switchTo().alert();
			Assert.assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		XLUtils xl = new XLUtils();

		int rownum = xl.getRowCount(path, "Sheet1");
		System.out.println(rownum);
		int columncount = xl.getCellCount(path, "Sheet1", 1);
		System.out.println(columncount);
		String Logindata[][] = new String[rownum][columncount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < columncount; j++) {
				Logindata[i - 1][j] = xl.getCellData(path, "Sheet1", i, j);
			}
		}

		return Logindata;
	}

}

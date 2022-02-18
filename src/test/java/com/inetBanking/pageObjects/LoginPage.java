package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
		
	}
	
	@FindBy(how=How.NAME, using="uid") 
	@CacheLookup
	WebElement userName;
	
	@FindBy(name="password") WebElement password;
	@FindBy(name="btnLogin") WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a") WebElement logout;
	
	
	public void setUserName(String uname) {
		userName.sendKeys(uname);
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickSubmit() {
		btnLogin.click();;
	}
	
	public void clicklogout() {
		logout.click();;
	}
}
//User ID :	mngr386627
// Password : rAsudYv
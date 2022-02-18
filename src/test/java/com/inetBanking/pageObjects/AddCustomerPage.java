package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	
	WebDriver driver;  //local driver

	public AddCustomerPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a") 
	@CacheLookup
	WebElement addCustomerLink;
	
	
	@FindBy(how=How.NAME, using="name") 
	@CacheLookup
	WebElement custName;
	
	@FindBy(how=How.NAME, using="rad1") 
	@CacheLookup
	WebElement gender; 
	
	@FindBy(how=How.ID_OR_NAME, using="dob") 
	@CacheLookup
	WebElement dob;
	
	@FindBy(how=How.NAME, using="addr") 
	@CacheLookup
	WebElement addr;
	
	@FindBy(how=How.NAME, using="city") 
	@CacheLookup
	WebElement city;
	
	@FindBy(how=How.NAME, using="state") 
	@CacheLookup
	WebElement state;
	
	@FindBy(how=How.NAME, using="pinno") 
	@CacheLookup
	WebElement pin;
	
	
	@FindBy(how=How.NAME, using="telephoneno") 
	@CacheLookup
	WebElement telephoneno;
	
	@FindBy(how=How.NAME, using="emailid") 
	@CacheLookup
	WebElement emailid;
	
	@FindBy(how=How.NAME, using="password") 
	@CacheLookup
	WebElement password;	
	
	@FindBy(how=How.NAME, using="sub") 
	@CacheLookup
	WebElement submit;
	
	
	
	public void clickAddCustomer() {
		addCustomerLink.click();
	}
	
	public void setCustomerName(String cname) {
		custName.sendKeys(cname);
	}
	
	
	public void clickGender() {
		gender.click();
	}
	public void setDob(String dd,String mm,String yyyy) {
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
	}
	
	public void setAddress(String address) {
		addr.sendKeys(address);
	}
	
	
	public void setCity(String ccity) {
		city.sendKeys(ccity);
	}
	
	public void setstate(String cstate) {
		state.sendKeys(cstate);
	}
	
	public void setpin(int pinno) {
		pin.sendKeys(String.valueOf(pinno));
	}
	
	public void setNumber(String num) {
		telephoneno.sendKeys(num);
	}
	
	public void setEmail(String email) {
		emailid.sendKeys(email);
	}
	
	public void setPwd(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		submit.click();
	}
}

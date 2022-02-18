package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig =new ReadConfig();
	
	public String baseurl =readconfig.getApplicationUrl();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@Parameters("browsername")
	@BeforeClass
	public void setup(String browser) throws InterruptedException {
		//System.getProperty("user.dir")  ====>   C:\Users\Raghav\java-workspace\inetBanking\
		//System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		//Or we can use System.setProperty("webdriver.chrome.driver",  readconfig.chromepath());
		//driver = new ChromeDriver();
		
		//OR
		if(browser.toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.toLowerCase().equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseurl); 
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("C:\\Users\\Raghav\\java-workspace\\inetBanking\\log4j.properties");
	}
	
	
	@AfterClass
	public void teardown() {
		 driver.quit();
	}
	
	public static String getScreenshot(WebDriver driver, String TestcaseName) throws IOException {
		  //String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "/Screenshots/" + TestcaseName +".png";
		  File finalDestination = new File(destination);
		  FileUtils.copyFile(source, finalDestination);
		  return destination;
		 }
	
	public String randomName() {
		String email= RandomStringUtils.randomAlphabetic(6)+"@gmail.com";
		return email;
	}
	
	public String randomNumber() {
		String num= RandomStringUtils.randomNumeric(6);
		return num;
	}

}

package com.inetBanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@Override
	public void onStart(ITestContext testContext) {
		
		String timestamp= new SimpleDateFormat("yyy.mm.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-report-"+timestamp+".html";
		
		// specify location of the report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/"+reportName);
		htmlReporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);

		// Passing General information
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Raghav");
		htmlReporter.config().setDocumentTitle("InetBanking Test Report"); // Tile of report
		htmlReporter.config().setReportName("Functional Testing report"); // Name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);


	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String Screentshotpath = System.getProperty("user.dir") + "\\Screenshots\\"+tr.getName()+".png";
		File f = new File(Screentshotpath);
		if(f.exists()) {
			try {
				logger.fail("Screentshot is below:"+logger.addScreenCaptureFromPath(Screentshotpath));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailedWithTimeout(tr);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	}

}

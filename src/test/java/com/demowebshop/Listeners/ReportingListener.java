package com.demowebshop.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.demowebshop.Utils.PageActions;
import com.demowebshop.Utils.ReporterNG;

public class ReportingListener  implements ITestListener{

	ExtentReports extent=ReporterNG.getReporter();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest   test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, result.getThrowable());
		try {
			String path = PageActions.getScreenshot();
			extentTest.get().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(path).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
	
}

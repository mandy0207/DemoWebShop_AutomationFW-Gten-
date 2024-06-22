package com.demowebshop.Utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demowebshop.Context.Constants;

public class ReporterNG {

	static ExtentReports extent;
	public static ExtentReports getReporter()  {
			String reportPath= System.getProperty("user.dir")+"//Reports//AutomationReport.html";
			ExtentSparkReporter reporter= new ExtentSparkReporter(reportPath);
			try {
				reporter.loadXMLConfig(Constants.extentConfigFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		    extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("QA Name", "Zahid");
			extent.setSystemInfo("Brand", "DEMO SHOP");
			return extent;
		}
	}


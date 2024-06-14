package com.demowebshop.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\InfoBahn\\eclipse-workspace\\DemoWebshopAutomation\\src\\main\\resources\\Configurations\\config.properties");
		prop.load(fis);
		return prop;
	}
}

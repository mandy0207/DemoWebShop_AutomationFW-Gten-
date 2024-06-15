package com.demowebshop.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UniqueGenerator {

	
	public static String getUniqueEmail() {
		return "demouser"+ getCurrentDateTime() +"@yopmail.com";
	}
	
	
	public static String getCurrentDateTime() {
		
		 String dateTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
		 return dateTime.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");
	}
}

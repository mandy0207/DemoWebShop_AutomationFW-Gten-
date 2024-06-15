package com.demowebshop.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demowebshop.Context.Constants;
import com.demowebshop.models.Person;

public class ExcelReader {

	public static List<Person> readData() throws IOException {
		
		List<Person> personList = new ArrayList<Person>();
		System.out.println(personList);
		FileInputStream fis = new FileInputStream(Constants.excelFile);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);    // will give me sheet number
		int lastRowNum=sheet.getLastRowNum();
		for(int rowIndex=1; rowIndex<=lastRowNum;rowIndex++) {
			
			Row row = sheet.getRow(rowIndex);
			String firstName= row.getCell(0).getStringCellValue();
			String lastName= row.getCell(1).getStringCellValue();
			String email=row.getCell(2).getStringCellValue();
			String password= row.getCell(3).getStringCellValue();
			String confirmPassword= row.getCell(4).getStringCellValue();
			System.out.println(firstName + " "+ lastName+" "+email+" "+password+" "+confirmPassword);
			
			Person person = new Person(firstName, lastName, email, password, confirmPassword);
			personList.add(person);
			
		}
		
		return personList;
		
	
		
		
		
		
	}
}

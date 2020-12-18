package com.atmecs.sdet.yatra.project.testdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.atmecs.sdet.yatra.project.constants.Constants;

public class DataProviderClass {

	@DataProvider(name = "cruiseData")
	public static Object[][] getCruiseData() throws IOException {
		XlsReader xls = new XlsReader(Constants.EXCELPATH);
		Object[][] data = xls.readExcelData("yatrasheet");
		System.out.println(data);
		return data;
	
	}
}

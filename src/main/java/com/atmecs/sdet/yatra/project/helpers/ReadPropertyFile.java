package com.atmecs.sdet.yatra.project.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadPropertyFile {

	WebDriver driver;

	Properties prop1;
	
	public ReadPropertyFile(String filepath) throws IOException  {
		
		prop1 = new Properties();
		try {
			prop1.load(new FileInputStream(new File(filepath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String get(String key) {
		return prop1.getProperty(key);
	}
}
	
	
	
	


	













package com.atmecs.sdet.yatra.project.testbase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.atmecs.sdet.yatra.project.constants.Constants;
import com.atmecs.sdet.yatra.project.helpers.ReadPropertyFile;

public class Base{

	public WebDriver driver;
	public static ReadPropertyFile reader;

	@BeforeMethod
	@Parameters("browser")
	public void browserSetUp(String browser) throws FileNotFoundException, IOException {
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
			driver = new ChromeDriver();
			
			reader = new ReadPropertyFile(Constants.CONFIG);
			String url = reader.get("url");
			driver.get(url);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_PATH);
			driver = new FirefoxDriver();
			reader = new ReadPropertyFile(Constants.CONFIG);

			String url = reader.get("url");
			driver.get(url);

			driver.manage().window().maximize();

		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	
	}

}

	/*public WebDriver driver;
	Properties properties;
	String baseUrl;
	String browserUrl;
	
	ReadPropertyFile readfile= new ReadPropertyFile();
	
@BeforeMethod

	@Parameters("browser")

	public void beforeTest(String browser) throws InterruptedException, IOException
	{
	properties = readfile.readProperty();
	
	baseUrl = properties.getProperty("application_url");//yatra.com
	
	browserUrl = properties.getProperty("browser"); //chrome

	if (browserUrl.equalsIgnoreCase("chrome"))
	{
	System.setProperty(Constants.CHROME_DIR, Constants.CHROME_PATH);
	
	driver = new ChromeDriver();
	
	driver.get(baseUrl);
	}
	}

	/*else if(browserUrl.equalsIgnoreCase("firefox"))
	{
	System.setProperty(Constants.GECKO_DIR, Constants.GECKO_PATH);
	driver = new FirefoxDriver();
	driver.get("application_url");
	}

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);

	}*/
	
	



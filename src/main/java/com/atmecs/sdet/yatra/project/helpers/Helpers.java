package com.atmecs.sdet.yatra.project.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.atmecs.sdet.yatra.project.testbase.Base;

public class Helpers extends Base {

WebDriver driver;
	
	public Helpers(WebDriver driver)
	{
		
		this.driver=driver;
		
		//System.out.println(driver);
		
	}
	public static void PerformClick(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	
	}
		public static void waitAndSelect(WebDriver driver,String xpath) throws InterruptedException
		{
			Thread.sleep(4000);
			driver.findElement(By.xpath(xpath)).click();
			
		}

		public static void closeAd(WebDriver driver,String iFrameXpath,String closeXpath)
		{
			driver.switchTo().frame(driver.findElement(By.xpath(iFrameXpath)));
			driver.findElement(By.xpath(closeXpath)).click();
			driver.switchTo().parentFrame();
		}

		public static boolean checkIfDisplayed(WebDriver driver,String xpath) {
			return driver.findElement(By.xpath(xpath)).isDisplayed();

		}

	
}


	
	

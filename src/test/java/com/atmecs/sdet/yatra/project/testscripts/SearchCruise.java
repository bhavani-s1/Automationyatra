package com.atmecs.sdet.yatra.project.testscripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.atmecs.sdet.yatra.project.constants.Constants;
import com.atmecs.sdet.yatra.project.helpers.Helpers;
import com.atmecs.sdet.yatra.project.helpers.ReadPropertyFile;
import com.atmecs.sdet.yatra.project.testbase.Base;

public class SearchCruise extends Base {

	ReadPropertyFile locators;

	@Test
	public void searchCruise() throws InterruptedException, IOException

	{
		Reporter.log("Opening Home Page");
		locators = new ReadPropertyFile(Constants.LOCATORS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*if (Helpers.checkIfDisplayed(driver, locators.get("iFrameXpath"))) {
			driver.switchTo().frame(driver.findElement(By.xpath(locators.get("iFrameXpath"))));
			Helpers.PerformClick(driver, locators.get("iFrameCloseXpath"));
			driver.switchTo().parentFrame();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (Helpers.checkIfDisplayed(driver, locators.get("iFrameXpath"))) {
			driver.switchTo().frame(driver.findElement(By.xpath(locators.get("iFrameXpath"))));
			Helpers.PerformClick(driver, locators.get("iFrameCloseXpath"));
			driver.switchTo().parentFrame();			

		}*/
		
		Helpers.PerformClick(driver, locators.get("moreLinkXpath"));
		Helpers.PerformClick(driver, locators.get("cruiseLinkXpath"));

		Reporter.log("Selecting Destination/River ");
		Thread.sleep(10000);

		Helpers.waitAndSelect(driver, locators.get("destinationXpath"));
		Helpers.waitAndSelect(driver, locators.get("destinationValueXpath"));
		Reporter.log("Selecting Dates ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Helpers.waitAndSelect(driver, locators.get("dateXpath"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Helpers.waitAndSelect(driver, locators.get("dateValueXpath"));
		Reporter.log("Selecting Days ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Helpers.waitAndSelect(driver, locators.get("daysXpath"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Helpers.waitAndSelect(driver, locators.get("daysValueXpath"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Selecting Cruise Lines ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Helpers.waitAndSelect(driver, locators.get("cruiselineXpath"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Helpers.waitAndSelect(driver, locators.get("cruiselineValueXpath"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Helpers.PerformClick(driver, locators.get("searchButtonXpath"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				Reporter.log("Switched to Child Window");
				driver.switchTo().window(child_window);

			}

		}

		String expectedDestination = "South Africa";
		String actualDestination = driver.findElement(By.xpath(locators.get("destinationVerifyXpath"))).getText();
		Assert.assertEquals(expectedDestination, actualDestination);
		Reporter.log("Destination Verified");
		String expectedDays = "5";
		String actualDays = driver.findElement(By.xpath(locators.get("daysVerifyXpath"))).getText();
		Assert.assertEquals(expectedDays, actualDays);
		Reporter.log("Number of days Verified");
		Helpers.PerformClick(driver, locators.get("bookXpath"));
		Helpers.PerformClick(driver, locators.get("itineraryXpath"));


	}
}
	
	
	


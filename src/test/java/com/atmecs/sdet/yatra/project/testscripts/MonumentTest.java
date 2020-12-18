package com.atmecs.sdet.yatra.project.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.atmecs.sdet.yatra.project.constants.Constants;
import com.atmecs.sdet.yatra.project.helpers.Helpers;
import com.atmecs.sdet.yatra.project.helpers.ReadPropertyFile;
import com.atmecs.sdet.yatra.project.testbase.Base;

public class MonumentTest extends Base {

	ReadPropertyFile locators;

	@Test
	public void displayMonuments() throws InterruptedException, IOException {

		locators = new ReadPropertyFile(Constants.LOCATORS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Helpers.PerformClick(driver, locators.get("moreLinkXpath"));

		Helpers.PerformClick(driver, locators.get("monumentLinkPath"));
		
		
		if(Helpers.checkIfDisplayed(driver, locators.get("iFrameXpath")))
		{
			Helpers.closeAd(driver, locators.get("iFrameXpath"), locators.get("iFrameCloseXpath"));


		}
		

		
		boolean topMonuments = Helpers.checkIfDisplayed(driver, locators.get("topMonumentsXpath"));

		Assert.assertEquals(true, topMonuments);
		if (topMonuments == true) {
			Reporter.log("Top Monuments Section  has been Displayed");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean qutubMinarstatus = Helpers.checkIfDisplayed(driver, locators.get("qutubMinarXpath"));
		Assert.assertEquals(true, qutubMinarstatus);
		if (qutubMinarstatus == true) {
			Reporter.log("Qutub Minar has been Displayed");
		}
		boolean tombStatus = Helpers.checkIfDisplayed(driver, locators.get("humayunsTombXpath"));
		Assert.assertEquals(true, tombStatus);
		if (tombStatus == true) {
			Reporter.log("Humayuns Tomb has been Displayed");
		}
	}
	
	
}

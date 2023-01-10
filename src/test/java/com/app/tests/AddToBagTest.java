package com.app.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.pages.LandingPage;
import com.app.pages.LoginPage;

public class AddToBagTest {
	WebDriver driver;
	@Test
	
	public void addTobag() throws Exception {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		String rootFolder = System.getProperty("user.dir");
		Properties propObj = new Properties();
		propObj.load(new FileInputStream(rootFolder+"//src/test//resources//data.properties"));
		driver.get(propObj.getProperty("loginurl"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterCredentials();
		Thread.sleep(4000);
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.searchItem();
		Thread.sleep(4000);
		String expectedProduct= propObj.getProperty("product");
		String actualProduct= driver.findElement(By.xpath("//div[@class='itemContainer-base-brand']")).getText();
		Assert.assertEquals(actualProduct, expectedProduct,"Bag does not contain that product");
		driver.quit();
		
	}	
}

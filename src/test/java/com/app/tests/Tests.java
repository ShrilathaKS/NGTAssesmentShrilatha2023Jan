package com.app.tests;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.HomePage;
import com.app.pages.LandingPage;
import com.app.pages.LoginPage;

public class Tests {
	WebDriver driver;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() throws Exception {
		driver= new ChromeDriver();
		homepage= new HomePage(driver);
		driver.manage().window().maximize();
		String rootFolder = System.getProperty("user.dir");
		Properties propObj = new Properties();
		propObj.load(new FileInputStream(rootFolder+"//src/test//resources//data.properties"));
		driver.get(propObj.getProperty("url"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void verifySearchResults() throws Exception {
		homepage.searchProduct();
		 String expectedPageTitle = "Redmi 10 - Buy Redmi 10 online in India";
		 String actualPageTitle = driver.getTitle();
		 Assert.assertEquals(actualPageTitle, expectedPageTitle,"Search Page not loaded");
	}
	
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
		
		
	}	
		
	
	}


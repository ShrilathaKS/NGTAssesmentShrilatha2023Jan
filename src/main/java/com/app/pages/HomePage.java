package com.app.pages;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage {
	WebDriver driver;
	String rootFolder = System.getProperty("user.dir");
	

	 public HomePage(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}
	 
	 @FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	 private WebElement searchInput;
	 
	 public void searchProduct() throws Exception {
		 Properties propObj = new Properties();
		 propObj.load(new FileInputStream(rootFolder+"//src/test//resources//data.properties"));
		 searchInput.click();
		 searchInput.sendKeys(propObj.getProperty("keyword"));
		 searchInput.sendKeys(Keys.ENTER);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	 }


	 
}

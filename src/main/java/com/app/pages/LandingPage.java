package com.app.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	String rootFolder = System.getProperty("user.dir");
	

	 public LandingPage(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}
	 
		@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
		private WebElement searchBar;
		
		@FindBy(xpath="//img[@title='DressBerry Lavender Textured Structured Mobile Pouch']")
		private WebElement product;
		
		public void searchItem() throws Exception {
			Properties propObj = new Properties();
			propObj.load(new FileInputStream(rootFolder+"//src/test//resources//data.properties"));
			driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys(propObj.getProperty("keyword"));
			driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			product.click();
			 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		 
		    driver.switchTo().window(newTb.get(1));
			driver.findElement(By.xpath("//body/div[@id='mountRoot']/div/div/main[@class='pdp-pdp-container']/div[@class='pdp-details common-clearfix']/div[@class='pdp-description-container']/div/div[2]/div[1]/div[1]")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Bag']")).click();
			
		}
		
		
}

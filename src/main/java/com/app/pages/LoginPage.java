package com.app.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	String rootFolder = System.getProperty("user.dir");
	

	 public LoginPage(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}
	 
	@FindBy(xpath="//input[@id='mobileNumberPass']") 
	private WebElement mobileNumber ; 
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn primary  lg block submitButton']")
	private WebElement login;
	

	
	public void enterCredentials() throws Exception {
		Properties propObj = new Properties();
		propObj.load(new FileInputStream(rootFolder+"//src/test//resources//data.properties"));
		mobileNumber.sendKeys(propObj.getProperty("mobnumber"));
		password.sendKeys(propObj.getProperty("password"));
		login.click();
		Thread.sleep(34000);
		login.click();
	}
	 
	
		
	
	
}

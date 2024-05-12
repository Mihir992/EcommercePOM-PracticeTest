package com.itlearn.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itlearn.utility.ConfigDataProvider;

public class AccountRegisterPage {
	
	WebDriver driver;
	WebDriverWait wait;
	//constructor
		public AccountRegisterPage(WebDriver lDriver)
		{
			this.driver=lDriver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//a[@data-test='register-link']") 
		WebElement registerAccountlink1;
		
		@FindBy(id="//input[@id='first_name']") 
		WebElement inputFirstName;
		
		@FindBy(id="//input[@id='last_name']") 
		WebElement inputLastName;
		
		@FindBy(id="//input[@id='dob']']") 
		WebElement inputDOB;
		
		@FindBy(id="//input[@id='address']") 
		WebElement inputAddress;
		
		@FindBy(id="//input[@id='postcode']") 
		WebElement inputPostcode1;
		
		@FindBy(id="//input[@id='city']") 
		WebElement inputCity;
		
		@FindBy(id="//input[@id='state']") 
		WebElement inputState;
		
		@FindBy(id="//select[@id='country']") 
		WebElement selectCountry;
		
		@FindBy(id="//input[@id='phone']") 
		WebElement inputPhone;
		
		@FindBy(id="//input[@id='email']") 
		WebElement inputEmail;
		
		@FindBy(id="//input[@id='password']") 
		WebElement inputPassword;
		
		@FindBy(xpath="//button[@type='submit']") 
		WebElement btnRegister;
		
		
		// Method to register
	    public void register(ConfigDataProvider configDataProvider) {
	        registerAccountlink1.click(); // Click on the register link
	        // Fill in registration form
	        inputFirstName.sendKeys(configDataProvider.pro.getProperty("fname"));
	        inputLastName.sendKeys(configDataProvider.pro.getProperty("lname"));
	        inputDOB.sendKeys(configDataProvider.pro.getProperty("dob"));
	        inputAddress.sendKeys(configDataProvider.pro.getProperty("address"));
	        inputPostcode1.sendKeys(configDataProvider.pro.getProperty("postcode"));
	        inputCity.sendKeys(configDataProvider.pro.getProperty("city"));
	        inputState.sendKeys(configDataProvider.pro.getProperty("state"));
	        selectCountry.sendKeys(configDataProvider.pro.getProperty("country")); // Assuming this is a dropdown, you might need to select by visible text or value
	        inputPhone.sendKeys(configDataProvider.pro.getProperty("phone"));
	        inputEmail.sendKeys(configDataProvider.pro.getProperty("eml"));
	        inputPassword.sendKeys(configDataProvider.pro.getProperty("pwd"));
	        btnRegister.click(); // Click on the register button
	    }
	    
	    public String getTitle(WebDriver driver) {
			String text = driver.getTitle();
			System.out.println("Title of the page is: \""+text+"\"");
			return text;
		}


}

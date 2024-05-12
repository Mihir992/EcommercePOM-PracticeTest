/*package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.itlearn.utility.ConfigDataProvider;

public class LoginPage {
	
	WebDriver driver;
	CartPage cartpage;
	//constructor
	public LoginPage(WebDriver lDriver)
	{
		this.driver=lDriver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="//input[@id='email']") 
	WebElement inputEmail;
		
	@FindBy(id="//input[@id='password']") 
	WebElement inputPassword;
		
	@FindBy(xpath="//input[@type='submit']") 
	WebElement btnLogin;

	//@FindBy(xpath="//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a") WebElement logoutclick;
	
	
		// Method to login
	    public void Login(ConfigDataProvider configDataProvider) {
	        // Fill in Login form
	        inputEmail.sendKeys(configDataProvider.pro.getProperty("eml"));
	        inputPassword.sendKeys(configDataProvider.pro.getProperty("pwd"));
	        btnLogin.click(); // Click on the Login button
	        cartpage.viewCart();
	    }
	
	//public void logout()
	//{
	//	logoutimage.click();
		//logoutclick.click();
	//}

}*/


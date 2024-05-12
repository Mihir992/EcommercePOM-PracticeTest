package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pages.AccountRegisterPage;
import com.itlearn.pages.BaseTest;
import com.itlearn.utility.ConfigDataProvider;

public class RegisterFunctionality extends BaseTest {
    
    @Test(description = "User can register and able to procced checkout")
    public void registrationFunctionality(ConfigDataProvider configDataProvider) {
        AccountRegisterPage registrationPage = new AccountRegisterPage(driver);
        registrationPage.register(configDataProvider);
        registrationPage.getTitle(driver);
        
    }
}

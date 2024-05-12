package com.itlearn.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.CartPage;

public class CartFunctionality extends BaseTest {
    
    @Test(description = "User can add product to cart")
    public void addToProductInCart() throws InterruptedException {
    	// Creating an instance of CartPage class
        CartPage cartPage = new CartPage(driver);
        cartPage.selectProduct();
        cartPage.clickOnAddToCart();
        cartPage.viewCart();
        cartPage.checkCalculationInCart();
        cartPage.verifyProceedToCheckOutButton();
    }
}
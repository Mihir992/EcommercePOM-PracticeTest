package com.itlearn.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	double price = 0.0; // Initialize price variable
	
	//constructor
		public CartPage(WebDriver lDriver)
		{
			this.driver=lDriver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//img[@alt='Combination Pliers']") 
		WebElement imgProduct;
		
		@FindBy(xpath="//span[@aria-label='unit-price']")
		WebElement productPrice;
		
		@FindBy(xpath="//i[@class='fa fa-plus']") 
		WebElement btnPlus;
		
		@FindBy(xpath="//i[@class='fa fa-minus']") 
		WebElement btnMinus;
		
		@FindBy(xpath="//button[@data-test='add-to-cart']") 
		WebElement btnAddToCart;
		
		@FindBy(xpath="//a[@aria-label='cart']")
		static WebElement btnViewCart;
		
		@FindBy(xpath="//i[@class='fa fa-remove']")
		WebElement removeItems;
		
		 @FindBy(xpath="p[contains(text(),'The cart is empty. Nothing to display.')]")
		 WebElement msgCartEmpty;
		
		@FindBy(xpath="//button[@class='btn btn-success']")
		WebElement btnproceedToCheckout;
		
		public void selectProduct() throws InterruptedException {
		    Actions action = new Actions(driver);
		    action.moveToElement(imgProduct).click().perform();
		    Thread.sleep(10000); // Add a brief pause to ensure the action completes before moving on
		}
		
		public void clickOnAddToCart() throws InterruptedException {
		    // Parsing the initial quantity from the 'min' attribute
			// Locate the input element by ID
	        WebElement quantityInput = driver.findElement(By.id("quantity-input"));

	        // Retrieve the initial quantity value
	        int initialQuantity = Integer.parseInt(quantityInput.getAttribute("value"));

	        // Output the initial quantity value
	        System.out.println("Initial Quantity Value: " + initialQuantity);
	        
	        // Parsing the price from the productPrice WebElement
	        try {
	            String priceText = productPrice.getText().replace("$", "").replace(",", "");
	            price = Double.parseDouble(priceText); // Assign parsed price to the price variable
	            // Output the parsed price
	            System.out.println("Product Price: $" + price);     
	        } catch(NumberFormatException e) {
	            System.err.println("Error parsing price: " + e.getMessage());
	        }
	                
	        // Clicking to increase quantity
	        Actions action = new Actions(driver);
	        action.moveToElement(btnPlus).click().perform();
	            
	        // Waiting for the quantity to be updated
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.attributeToBe(quantityInput, "value", String.valueOf(initialQuantity + 1)));
	        
	        // Adding item to cart
		    btnAddToCart.click();		    
		}
		
		public void viewCart() {
		    // Clicking to view cart
		    btnViewCart.click();
		}
		
		public void checkCalculationInCart() {
		    WebElement tblquantityInput = driver.findElement(By.xpath("//input[@class='form-control quantity']"));
		    // Getting the updated quantity from the 'value' attribute
	        int updatedQuantity = Integer.parseInt(tblquantityInput.getAttribute("value"));

	        WebElement tblProductPrice = driver.findElement(By.xpath("//td[@class='col-md-2 text-end'][1]"));
	        try {
	            String priceText = tblProductPrice.getText().replace("$", "").replace(",", "");
	            price = Double.parseDouble(priceText); // Assign parsed price to the price variable
	            // Output the parsed price
	            System.out.println("Product Price: $" + price);     
	        } catch(NumberFormatException e) {
	            System.err.println("Error parsing price: " + e.getMessage());
	        }
	        
	        // Calculating total price after increasing quantity
	        double totalPrice = calculateTotalPrice(updatedQuantity, price);

	        // Output the updated quantity and total price
	        System.out.println("Updated Quantity: " + updatedQuantity);
	        System.out.println("Total Price after increasing quantity: $" + totalPrice);
		    
		    // Validating total price
		    double totalPriceExpected = calculateTotalPrice(updatedQuantity, price);
		    if (totalPrice == totalPriceExpected) {
		        System.out.println("Total price is calculated correctly after increasing quantity.");
		    } else {
		        System.out.println("Total price is not calculated correctly after increasing quantity.");
		    }
		}

		// Assuming the calculateTotalPrice method is defined elsewhere in your code
		private double calculateTotalPrice(int quantity, double unitPrice) {
		    return quantity * unitPrice;
		}

		public void verifyProceedToCheckOutButton(){
			btnproceedToCheckout.click();
			wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Increase the wait time to 60 seconds
		 }
		 
		public String removingItemsFromCart() throws InterruptedException {
		        Thread.sleep(1200);
		        removeItems.click();
		        Thread.sleep(1200);
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		        //need to wait as it takes time to load.
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'The cart is empty. Nothing to display.')]")));
		        return msgCartEmpty.getText();
		 }
}
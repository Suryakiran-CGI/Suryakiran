package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class CheckOutPage extends TestBase{

	
	// Scenario - 1
    public void user_is_on_home_page_by_logging_with_and(String email, String password) {
		IntializeBrowser();
		Login(email,password);
	}

	
	public void user_clicks_on_shopping_cart_button() {
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
	}

	
	public void select_and_enter_and_and(String country, String state, String code){
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='CountryId']"));
		Select sel1 = new Select(dropdown1);
		sel1.selectByVisibleText(country);

		WebElement dropdown2 = driver.findElement(By.id("StateProvinceId"));
		Select sel2 = new Select(dropdown2);
		sel2.selectByVisibleText(state);

		driver.findElement(By.id("ZipPostalCode")).sendKeys(code);
	}

	
	public void click_estimate_shipping_button() {
		driver.findElement(By.xpath("//div[@class='inputs']/input[@name='estimateshipping']")).click();
	}

	
	public void click_on_checkout_button() {
		driver.findElement(By.xpath("//input[@name='termsofservice']")).click();
		driver.findElement(By.xpath("//div[@class='checkout-buttons']/button")).click();
		
	}

	
	public void user_should_see_billing_page() {
		boolean flag = driver.findElement(By.xpath("//h1[text()='Checkout']")).isDisplayed();
        if(flag==true) {
        	System.out.println("User is on billing page....");
        }else {
        	System.out.println("User is on Shopping Cart...");
        }
        
       QuitBrowser();
	}


}

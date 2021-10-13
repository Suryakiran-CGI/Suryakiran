package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import com.base.TestBase;


public class UpdateCartPage extends TestBase {

	//WebDriver driver;
	char actual, expected;

    //Scenario - 1
    
    public void user_is_on_demo_web_shop_home_page_with_login_and(String email, String password) {
		IntializeBrowser();
		Login(email,password);
	}

	
	public void user_clicks_on_shopping_cart() {
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	}

	
	public void user_selects_in_cart(String productname) {
		String path = "//td[@class='product']//a[text()=\'%s\']";
		WebElement target = driver.findElement(By.xpath(String.format(path, productname)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
	}

	
	public void user_checks_the_respective_checkbox_of_that(String productname) {
		String del = "//a[text()=\'%s\']//parent::td//preceding-sibling::td/input";
		driver.findElement(By.xpath(String.format(del, productname))).click();
	}

	
	public void user_clicks_on_update_shopping_cart_for_removing_product() {
		actual = driver.findElement(By.xpath("//a[@class='ico-cart']/span[2]")).getText().charAt(1);
		driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
	}
	
	
	public void checked_item_should_be_removed_from_cart() throws InterruptedException {
		expected = driver.findElement(By.xpath("//a[@class='ico-cart']/span[2]")).getText().charAt(1);

		if (actual > expected) {
			System.out.println("Status of UpdatingCart : \'Deleting items...\'");
			System.out.println("Items in Cart Before Update : " + actual);
			System.out.println("Items in Cart After Update : " + expected);
		} else {
			System.out.println("Status of UpdatingCart : \'Adding items...\'");
			System.out.println("Items in Cart Before Update : " + actual);
			System.out.println("Items in Cart After Update : " + expected);
		}
		
		Thread.sleep(3000);
		QuitBrowser();

	}
	
	//Scenario - 2
	
	public void user_enters_value_of_itemquantity_box(String quantity, String productname) {
		String add = "//table[@class='cart']//child::a[text()=\'%s\']//following::td[@class='qty nobr']/input";
		driver.findElement(By.xpath(String.format(add, productname))).sendKeys(Keys.ARROW_RIGHT);
		driver.findElement(By.xpath(String.format(add, productname))).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(String.format(add, productname))).sendKeys(quantity);

	}

	
	public void user_clicks_on_update_shopping_cart_button_for_adding_update() throws Throwable {
		driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
	}

	
    public void user_entered_item_quantity_is_updated(String productname, String quantity) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		System.out.println("AddQuantity update is successful");
		
		Thread.sleep(4000);
		QuitBrowser();
	}

}

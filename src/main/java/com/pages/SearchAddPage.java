package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.base.TestBase;


public class SearchAddPage extends TestBase{
    
	// Scenario - 1
	public void user_should_be_on_home_page_by_loggingin_using_and(String email, String password) {
		IntializeBrowser();
		Login(email,password);
	}


	public void user_enters_in_search_bar(String productname) {
		driver.findElement(By.id("small-searchterms")).sendKeys(productname);
	}


	public void user_clicks_on_search_button() {
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/**
		 * JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript(null,
		 * null)
		 * driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[1]/h1")).click();
		 **/
	}


	public void user_clicks_on_add_to_cart_button() {
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		boolean flag = driver.findElement(By.xpath("//div[@class='bar-notification success']")).isDisplayed();
		String out = flag == true ? "The product has been added to your shopping cart successfully"
				: "Please Specify and then add to cart!";
		System.out.println(out);

	}

	// table//td[@class='product']
	public void user_added_should_be_added_to_shoppingcart(String productname) throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='shopping cart']")).click();
		String path = "//table//tr[@class='cart-item-row']//td[@class='product']//a[text()=\'%s\']";
		String flag = driver.findElement(By.xpath(String.format(path, productname))).getText();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		if (flag.equals(productname)) {
			System.out.println("Searched item found inside cart...");
		} else {
			System.out.println("No records found!...");
		}
		Thread.sleep(3000);
		QuitBrowser();

	}

	// Scenario - 2
	public void user_gets_search_results() throws InterruptedException {
		boolean flag = driver.findElement(By.xpath("//div[@class='search-results']/strong[1]")).isDisplayed();
		if (flag == true) {
			System.out.println("No products were found that matched your criteria.");
		} else {
			System.out.println("loading searched items...");
		}

		Thread.sleep(3000);
		QuitBrowser();
	}

}

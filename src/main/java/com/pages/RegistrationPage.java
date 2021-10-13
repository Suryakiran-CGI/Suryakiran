package com.pages;

import org.openqa.selenium.By;

import com.base.Base;
import com.base.TestBase;


public class RegistrationPage extends TestBase{

	public void user_is_on_demo_web_shop_page(){
		IntializeBrowser();

	}
	
	public void user_click_on_register_button() {
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}
	
	public void user_is_on_registration_page() {
		String Expected_Title = "Demo Web Shop. Register";
		String Actual_Title = driver.getTitle();
		if (Expected_Title.equals(Actual_Title)) {
			System.out.println("Registration page opened succesfully");
		} else {
			System.out.println("Registration page not opened");
		}
		QuitBrowser();
	}
	
	public void user_clicks_on_the(String gender) {
		if (gender.equals("male")) {
			driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		} else if (gender.equals("female")) {
			driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		} else {
			System.out.println("The gender was not selected");
		}
	}
	
	public void user_enters_and(String firstname, String lastname) {
		driver.findElement(By.id("FirstName")).sendKeys(firstname);
		driver.findElement(By.id("LastName")).sendKeys(lastname);
	}
	
	public void user_types(String email) {
		driver.findElement(By.id("Email")).sendKeys(email);

	}
	
	public void user_Types_(String password, String confirmpass) {
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmpass);

	}
	
	public void user_Clicks_on_register_button() {
		driver.findElement(By.id("register-button")).click();

	}
	
	public void user_is_succesfully_registered() {
		String Expected_Result = "Your registration completed";
		String Actual_Result = driver.findElement(By.xpath("//div[@class='result']")).getText();
		if (Expected_Result.equals(Actual_Result)) {
			System.out.println("Entered valid Details");
		} else {
			System.out.println("Entered invalid Details");
		}
		QuitBrowser();
	}
	
	public void user_should_not_able_to_registered() {

		String Expected_Result = "Demo Web Shop. Register";
		String Actual_Result = driver.getTitle();
		if (Expected_Result.equals(Actual_Result)) {
			System.out.println("Oops!invalid data,please try with valid data");
		} else {
			System.out.println("Website Error");
		}
		/*
		 * boolean flag =
		 * driver.findElement(By.xpath("//div[@class='result']")).isDisplayed();
		 * if(flag) { System.out.println("Website Error"); } else {
		 * System.out.println("User entered invalid data"); }
		 */
		QuitBrowser();
	}
	
	

}

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;


public class LoginPage extends TestBase{
	/*@FindBy(id="Email")
	WebElement email;
	@FindBy(id="Password")
	WebElement password;
	@FindBy(xpath="//a[text()='Log in']")
	WebElement loginbtn;
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}*/

	public void user_should_be_on_home_page() {
        IntializeBrowser();
	}
	
	
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
	}

   
    public void user_should_enter_registered_and(String email, String password)  {
    	driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
    }

	
	public void user_should_click_on_log_in_button() {
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
	}

	
	public void user_should_be_able_to_logged_in_successfully()  {
		WebElement Logout = driver.findElement(By.xpath("//a[text()='Log in']"));
		boolean flag = Logout.isDisplayed();
		String display = (flag==true) ? "Logged in Successfully!" : "No User Found!";
		System.out.println(display);
		QuitBrowser();
	}

	
	public void user_should_enter_unregistered_and(String email, String password) {
		user_should_enter_registered_and(email,password);
		//driver.findElement(By.id("Email")).sendKeys(email);
		//driver.findElement(By.id("Password")).sendKeys(password);
	}

	
	public void user_should_not_be_able_to_logged_in(){
		WebElement Login = driver.findElement(By.xpath("//a[text()='Log in']"));
		boolean flag = Login.isDisplayed();
		String display = (flag==true) ?  "No User Found!" : "Logged in Successfully!";
		System.out.println(display);
		QuitBrowser();
	}
	
}

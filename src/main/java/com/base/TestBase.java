package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public void IntializeBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// info

	}

	public void Login(String email,String password){
		driver.findElement(By.xpath("//div[@class='header-links']/ul/li[2]/a")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		//info
	}

	public void QuitBrowser() {
		// info
		driver.quit();
	}

}

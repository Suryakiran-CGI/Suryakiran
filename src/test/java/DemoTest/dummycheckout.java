package DemoTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dummycheckout {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		String email = "johnfletcher@gmail.com";
		String password = "mypass1234$";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='header-links']/ul/li[2]/a")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");

		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='CountryId']"));
		String country = "India";
		String state = "Other (Non US)";
		String postalCode = "535591";
		Select sel = new Select(dropdown1);
		sel.selectByVisibleText(country);

		WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='StateProvinceId']"));
		sel.selectByVisibleText(state);

		driver.findElement(By.id("ZipPostalCode")).sendKeys(postalCode);
        
		driver.findElement(By.xpath("//div[@class='inputs']/input[@name='estimateshipping']")).click();

	}

}

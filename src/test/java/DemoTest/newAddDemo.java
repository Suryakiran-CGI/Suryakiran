package DemoTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newAddDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String productname="14.1-inch Laptop";
		String quantity = "10";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='header-links']/ul/li[2]/a")).click();
		driver.findElement(By.id("Email")).sendKeys("johnfletcher@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("mypass1234$");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

		//a[@class='ico-cart']/span[2]
		
		String path = "//td[@class='product']//a[text()=\'%s\']";
		WebElement target = driver.findElement(By.xpath(String.format(path,productname)));
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		act.moveToElement(target).build().perform();
		String add = "//table[@class='cart']//child::a[text()=\'%s\']//following::td[@class='qty nobr']/input";
		driver.findElement(By.xpath(String.format(add, productname))).sendKeys(Keys.CLEAR);
		driver.findElement(By.xpath(String.format(add, productname))).sendKeys(quantity);
		
		char actual = driver.findElement(By.xpath("//a[@class='ico-cart']/span[2]")).getText().charAt(1);
		
		driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
		
		char  expected = driver.findElement(By.xpath("//a[@class='ico-cart']/span[2]")).getText().charAt(1);
		
		
       
        if(actual >expected) {
        	System.out.println("Status of UpdatingCart : \'Deleting items...\'");
        	System.out.println("Items in Cart Before Update : "+actual);
        	System.out.println("Items in Cart After Update : "+expected);
        }
        else {
        	System.out.println("Status of UpdatingCart : \'Adding items...\'");
        	System.out.println("Items in Cart Before Update : "+actual);
        	System.out.println("Items in Cart After Update : "+expected);
        }
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}

package DemoTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAdv {

	public static void main(String[] args) {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='header-links']/ul/li[2]/a")).click();
		driver.findElement(By.id("Email")).sendKeys("johnfletcher@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("mypass1234$");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.navigate().to("http://demowebshop.tricentis.com/customer/addresses");
		List<WebElement> addresslist = driver.findElements(By.xpath("//div[@class='address-list']"));
		
	    String reference = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]")).getText();
		if (reference.equals("No addresses ")) {
			for (int i = 1; i <= addresslist.size(); i++) {
				String path = "//div[@class='address-list']/div[%d]/div[2]/input[2]";
				driver.findElement(By.xpath(String.format(path, i))).click();
				driver.switchTo().alert().accept();
				System.out.println("All saved records deleted successfully!....");
			}
		}else {
			System.out.println("Oops! No records Found....");
		}
		
    driver.quit();
	}

}
































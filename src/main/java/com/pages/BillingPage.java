package com.pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class BillingPage extends TestBase{


	public void user_is_on_home_page_by_logging_in_by_using_the_and(String email, String password) {
		IntializeBrowser();
		Login(email,password);
	}

	
	public void user_loggedin_navigate_to_billing_page() {
		driver.navigate().to("http://demowebshop.tricentis.com/onepagecheckout");
	}

	
	public void now_enter_respective(String company) {
		driver.findElement(By.id("BillingNewAddress_Company")).sendKeys(company);
	}

	
	public void select_the_and(String country, String state) {
		WebElement dropdown1 = driver.findElement(By.id("BillingNewAddress_CountryId"));
		WebElement dropdown2 = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
		Select sel1 = new Select(dropdown1);
		Select sel2 = new Select(dropdown2);
		sel1.selectByVisibleText(country);
		sel2.selectByVisibleText(state);
	}

	
	public void enter_the_name(String city) {
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys(city);
	}

	
	public void user_enter_the_details(String address) {
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address);
		driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys(address);
	}

	
	public void now_enter_the(String postalcode) {
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(postalcode);
	}

	
	public void enter_in_the_field(String phonenumber) {
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(phonenumber);
	}

	
	public void at_last_enter_the(String faxnumber) {
		driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys(faxnumber);
	}

	
	public void user_clicks_on_continue_button() {
		driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();
	}

	
	public void user_enters_to_shipping_step() throws InterruptedException {
		Thread.sleep(2000);
		boolean flag = driver.findElement(By.xpath("//div[@id='shipping-buttons-container']")).isDisplayed();
		if (flag == true) {
			System.out.println("User is on Shipping page...");
		} else {
			System.out.println("User is on Billing page...");
		}
	}

	
	public void user_select_a_shipping_address_from_your_address_book_or_enter_a_new_address() {
		WebElement dropdown = driver.findElement(By.id("shipping-address-select"));
		Select sel = new Select(dropdown);
		String Address = driver.findElement(By.xpath("//select[@id='shipping-address-select']/option[1]")).getText();
		sel.selectByVisibleText(Address);
	}

	
	public void clickon_the_continue_button() {
		driver.findElement(By.xpath("//div[@id='shipping-buttons-container']/input")).click();
	}

	
	public void go_to_shipping_method() {
		boolean flag = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input"))
				.isDisplayed();
		if (flag == true) {
			System.out.println("User is on Shipping Method");
		} else {
			System.out.println("please wait while redirecting...");
		}
	}

	
	public void click_on_the_type_of_shipping_method_and_tick_the_continue_button() {
		String path = "//*[@id=\"shippingoption_%s\"]";
		int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
		driver.findElement(By.xpath(String.format(path, randomNum))).click();
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
	}

	
	//public void select_the_of_payment_method_and_press_the_continue_button(String typeofpayment) 
	public void select_the_of_payment_method_and_press_the_continue_button(String typeofpayment)throws InterruptedException {
		Thread.sleep(3000);

		// if (typeofpayment.equals("COD") || typeofpayment.equals("MO")) {
		if (typeofpayment.equals("COD")) {
			driver.findElement(By.xpath("//label[text()='Cash On Delivery (COD) (7.00)']//preceding-sibling::input")).click();
			driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/input")).click();
			driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/input")).click();
			System.out.println("Type of payment is COD ...");
		} else if (typeofpayment.equals("MO")) {
			driver.findElement(By.xpath("//label[text()='Check / Money Order (5.00)']//preceding-sibling::input")).click();
			driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/input")).click();
			driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/input")).click();
			System.out.println("Type of payment is MO ...");
		} else{
			//int randomNum = ThreadLocalRandom.current().nextInt(123456, 999999);
			//String num = "\"%d\"";
			driver.findElement(By.xpath("//label[text()='Purchase Order']//preceding-sibling::input")).click();
			driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/input")).click();
			//driver.findElement(By.xpath("//*[@id='PurchaseOrderNumber']")).sendKeys(String.format(num, randomNum));
			driver.findElement(By.xpath("//*[@id='PurchaseOrderNumber']")).sendKeys("2257624873548569");
			driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/input")).click();
			System.out.println("Succesfully entered PO number...");
		}

	}


	public void press_the_confirm_order_button() {
		driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
	}

	
	public void user_is_able_to_see_placed_order_details() throws InterruptedException {
		boolean popup = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/h1")).isDisplayed();
		if (popup == true) {
			System.out.println("Your order has been successfully processed!");
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a")).click();

			String orderdetails = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div")).getText();
			System.out.println("Order Summary : \n" + orderdetails);

			driver.navigate().to("http://demowebshop.tricentis.com/customer/addresses");
			List<WebElement> addresslist = driver.findElements(By.xpath("//div[@class='address-list']"));

			String reference = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]"))
					.getText();

			// while(addresslist.size()!=0) {
			for (int i = 1; i <= addresslist.size(); i++) {
				String path = "//div[@class='address-list']/div[%d]/div[2]/input[2]";
				driver.findElement(By.xpath(String.format(path, i))).click();
				driver.switchTo().alert().accept();
				System.out.println("All saved records deleted successfully!....");
			}
			
			try 
			{
				if (addresslist.size() > 0)
				{
					driver.navigate().to("http://demowebshop.tricentis.com/customer/addresses");
					String path = "//div[@class='address-list']/div[%d]/div[2]/input[2]";
					driver.findElement(By.xpath(String.format(path, addresslist.size()))).click();
					driver.switchTo().alert().accept();
					
			    }

			}
			catch(Exception e) {
				if(driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]")).isDisplayed()==true)
				{
					System.out.println("Please wait!..we are closing all tabs...");
					QuitBrowser();
				}
			}
			// }
		}
	}
	
}

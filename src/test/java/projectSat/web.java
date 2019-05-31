package projectSat;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class web {
	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();

		Faker faker = new Faker();
		String name = faker.name().fullName();
		String street = faker.address().streetName();
		String city = faker.address().city();
		String state = faker.address().state();
		String zip = faker.address().zipCode();

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();
		Thread.sleep(2000);
		// random number
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("" + random.nextInt(100));
		
		Thread.sleep(2000);
		// Faker
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
		Thread.sleep(1000);
		// random zip
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("" + random.nextInt(90000 + 10000));
		Thread.sleep(1000);


		

    long card = random.nextInt(3);

		// visa
		if (card == 0) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
			long first14 = (long)(Math.random() *10000000000000L);
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("4"+first14);
			Thread.sleep(1000);
		}

		// masterCard
		
		if (card == 1) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
			long first15 = (long)(Math.random() *10000000000000L);
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("5"+first15);
			Thread.sleep(1000);
		}

		// AmericanExpress
		if (card == 2) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
			long first16 = (long)(Math.random() *10000000000000L);
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("3"+first16);
			
			Thread.sleep(1000);
		}

		// expdate
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("05/25");
		Thread.sleep(2000);

		// process
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		Thread.sleep(1000);
	}

}

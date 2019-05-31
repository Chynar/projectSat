package projectSat;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	public static void main(String[] args) throws InterruptedException {
		
	Random num = new Random();
     WebDriver web;
    WebDriverManager.chromedriver().setup();
    web=new ChromeDriver();
  
	web.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    Thread.sleep(2000);
	web.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
	Thread.sleep(1000);
	web.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	Thread.sleep(1000);
	web.findElement(By.id("ctl00_MainContent_login_button")).click();
	web.findElement(By.xpath("//a[@href='Process.aspx']")).click();
	Thread.sleep(1000);
}
}
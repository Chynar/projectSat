package projectSat;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Expedia { 
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver expedia;
		WebDriverManager.chromedriver().setup();
		expedia = new ChromeDriver();
		
	    expedia.get("https://www.expedia.com/");
		expedia.findElement(By.id("tab-car-tab-hp")).click();
		expedia.findElement(By.id("car-pickup-hp-car")).sendKeys("Los Angeles LAX");
		Thread.sleep(5000);
		
		expedia.findElement(By.id("car-dropoff-hp-car")).sendKeys("New York");
		Thread.sleep(2000);
		expedia.findElement(By.id("car-pickup-date-hp-car")).sendKeys("05/31/2019");
		Thread.sleep(2000);
		expedia.findElement(By.id("car-dropoff-date-hp-car")).sendKeys("06/26/2019");
		Thread.sleep(2000);
	   expedia.findElement(By.id("gcw-submit-car")).click();
	   // by Xpath //button[.='Search'] 
	  
	   List<WebElement> carList= expedia.findElements(By.xpath("//div[@class='car-model']"));
	   Assert.assertEquals(carList, 25);   
	   System.out.println(carList);
	  if(carList.size()==25) {
		  System.out.println("Great job");
	  }else {
		  System.out.println("Try again. You founf " + carList.size() + " but expected 88. ");
	  }
	  	
	}
			
		
	}


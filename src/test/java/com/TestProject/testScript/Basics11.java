package com.TestProject.testScript;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Basics11 {

	@Test(priority = 1)
	public void BC() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);  //Normal Wait or Hard coded wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String exptTitle = "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(exptTitle, actTitle);
		Assert.assertTrue(exptTitle.equals(actTitle), actTitle);
		driver.quit();
	}
	
	@Test(priority = 2)
	public static void AB() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);  //Normal Wait or Hard coded wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String acturl = driver.getCurrentUrl();
		String expUrl = "https://www.redbus.in/";
		System.out.println(acturl);
		Assert.assertEquals(expUrl, acturl);
		driver.quit();
		
	}
	
	
	
}

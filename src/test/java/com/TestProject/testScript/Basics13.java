package com.TestProject.testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basics13 {

	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void startBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\firefox.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\91798\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else{
			System.out.println("We do not support this broswer!!!");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void BC() throws Exception {
	
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);  //Normal Wait or Hard coded wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String exptTitle = "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(exptTitle, actTitle);
		Assert.assertTrue(exptTitle.equals(actTitle), actTitle);
	}
	
	@Test(priority = 2)
	public void AB() throws Exception {
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);  //Normal Wait or Hard coded wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String acturl = driver.getCurrentUrl();
		String expUrl = "https://www.redbus.in/";
		System.out.println(acturl);
		Assert.assertEquals(expUrl, acturl);
		
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
	
	
}

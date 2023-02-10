package com.TestProject.testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Basics14 {

	WebDriver driver;
	
	@BeforeClass
	public void startBrowser()
	{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider = "cred")
	public void BC(String username, String pwd) throws Exception {
	
		WebElement user =  driver.findElement(By.name("username"));
		Assert.assertTrue(user.isDisplayed());
		user.sendKeys(username);
		WebElement pwds =  driver.findElement(By.name("password"));
		Assert.assertTrue(pwds.isDisplayed());
		pwds.sendKeys(pwd);
		WebElement loginBtn =  driver.findElement(By.xpath("//*[@type='submit']"));
		loginBtn.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard/index"));
		System.out.println("User Successfully Logged In....!!!!!!!!");
	}
	
	@DataProvider(name="cred")
	public Object[][] getData(){
		
		Object data[][] = new Object[4][2];
		
		data[0][0] = "abc@gmail.com";
		data[0][1]="admin";
		data[1][0] = "xyz@gmail.com";
		data[1][1]="admin123";
		data[2][0] = "qwerty@gmail.com";
		data[2][1]="admin456";
		data[3][0] = "Admin";
		data[3][1]="admin123";
		
		return data;
		
	}
	
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
	
	
}

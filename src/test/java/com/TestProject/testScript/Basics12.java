package com.TestProject.testScript;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Basics12 {

	@Test()
	public static void AB() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		Thread.sleep(3000);  //Normal Wait or Hard coded wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String acturl = driver.getCurrentUrl();
		String expUrl = "https://demoqa.com/frames";
		System.out.println(acturl);
		Assert.assertEquals(expUrl, acturl);
		driver.switchTo().frame("frame1");
		WebElement heading = driver.findElement(By.id("sampleHeading"));
		
		System.out.println(heading.getText());
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//header/a")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
		
		driver.quit();
		
		//Alert alert = driver.switchTo().alert();
	}

	
}

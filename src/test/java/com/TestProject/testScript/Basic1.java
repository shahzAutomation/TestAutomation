package com.TestProject.testScript;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic1 {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//li[@class=\"msite-login\"]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("signInName")).sendKeys("pfyzyvlrpkcvyfhaqm@tmmbt.net");
//		Thread.sleep(5000);
//		driver.findElement(By.name("password")).sendKeys("foundit");
//		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//a[@class='ntc__chip-wrapper']"));
		System.out.println(ele);
		System.out.println();
		List<WebElement> lstEle= driver.findElements(By.xpath("//a[@class='ntc__chip-wrapper']"));
		System.out.println(lstEle);
		Thread.sleep(3000);
		driver.close();
	}

	
}

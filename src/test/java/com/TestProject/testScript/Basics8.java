package com.TestProject.testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basics8 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://flippa.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);  //Normal Wait or Hard coded wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//WebElement blog = driver.findElement(By.xpath("//div[@class='hero-scrollable-text__container']/div[1]/span/a[text()='Blogs']"));
		//blog.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='hero-scrollable-text__item']/a[contains(@href,'inventory')]")));
		driver.findElement(By.xpath("//span[@class='hero-scrollable-text__item']/a[contains(@href,'inventory')]")).click();
		//String bl = driver.findElement(By.xpath("//span[@class='hero-scrollable-text__item']/a[contains(@href,'inventory')]")).getText();
		//System.out.println(bl);
		driver.quit();
	}

}

package com.TestProject.testScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics9 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);  //Normal Wait or Hard coded wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("onward_cal")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@class='next']/button")).click();
		
		Thread.sleep(3000);
		List<WebElement> calendarDate = driver.findElements(By.xpath("//table/tbody/tr/td"));
		
		System.out.println(calendarDate.size());
		
		for(int i=0;i<calendarDate.size();i++) {
			String date = calendarDate.get(i).getText();
			System.out.println(date);
			if(date.equalsIgnoreCase("10")) {
				calendarDate.get(i).click();
				System.out.println("Selected Date : "+date);
				break;
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}

}

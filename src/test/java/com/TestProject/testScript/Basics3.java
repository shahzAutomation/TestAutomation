package com.TestProject.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver dr = new ChromeDriver();
		dr.get("https://www.amazon.com/");
		dr.manage().window().maximize();
		
		Thread.sleep(10000);
		
		JavascriptExecutor jsx = (JavascriptExecutor)dr;
		
		jsx.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		jsx.executeScript("window.scrollBy(0,-1500)");
		Thread.sleep(4000);
		
		dr.findElement(By.id("twotabsearchtextbox")).sendKeys("refrigerator");
		dr.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		WebElement pagination =  dr.findElement(By.xpath("//span[@class='s-pagination-strip']"));
		
		if(pagination.isDisplayed())
		{
			jsx.executeScript("arguments[0].scrollIntoView();",pagination);
			System.out.println("Scrolled to Pagination is successfull.....");
		}
		else
		{
			System.out.println("Unable to locate Element");
		}
		
		jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(4000);
		
		dr.quit();
		
	}

}

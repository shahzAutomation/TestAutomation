package com.TestProject.testScript;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver dr = new ChromeDriver();
		dr.get("https://www.lowes.com/");
		dr.manage().window().maximize();
		
		Thread.sleep(5000);
		String parentWindowId = dr.getWindowHandle(); 
		System.out.println("Parent Window Id "+parentWindowId);
		
		WebElement footer = dr.findElement(By.xpath("//div[@id='footerApp']"));
		
	    JavascriptExecutor jsx = (JavascriptExecutor)dr;
	    
	    jsx.executeScript("arguments[0].scrollIntoView();", footer);
		
		Thread.sleep(5000);
		WebElement hrClk =  dr.findElement(By.xpath("//div[@class='sc-krih58-1 jxmzCv']//ul[@class='list-menu']/li/a[@id='https://corporate.lowes.com/who-we-are']"));
		hrClk.click();
		Set<String> allWindowId = dr.getWindowHandles(); 
		System.out.println("All Window Id"+allWindowId);
		
		for(String child : allWindowId) 
		{
		   if(!parentWindowId.equalsIgnoreCase(child)) {
			dr.switchTo().window(child);
			Thread.sleep(5000);
			String expected = "who-we-are";
			String hrUrl = dr.getCurrentUrl();
			if(hrUrl.contains(expected))
			{
				System.out.println("Url expected Matched");
			}
			else
			{
				System.out.println("Url expected Not Matched");
			}
			   dr.close();
		   }
		   dr.switchTo().window(parentWindowId);
		}
		
		System.out.println(dr.getCurrentUrl());
		Thread.sleep(5000);
		dr.quit();
		
		
	}

}

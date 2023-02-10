package com.TestProject.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Basics7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		Thread.sleep(5000);
		act.dragAndDrop(source, target).build().perform();
		
		Thread.sleep(10000);
		String expectedTxt="Dropped!";
		String actText = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
		
		if(expectedTxt.equals(actText)) {
			System.out.println("Dropped Successfully!!!");
		}
		else {
			System.out.println("Test Failed..."); 
		}
		act.contextClick(driver.findElement(By.xpath("//div[@id='droppable']"))).build().perform();
		Thread.sleep(5000);
		driver.close();
	}

}

package com.TestProject.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Basics5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.foundit.in/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement Skill = driver.findElement(By.xpath("//a[@href='/skillyst']"));
		WebElement PS = driver.findElement(By.xpath("//a[@href='/web/en/career-services']"));
		WebElement RB = driver.findElement(By.xpath("//a[@href='/seeker/resume-builder']"));
		
		act.moveToElement(Skill).build().perform();
		Thread.sleep(3000);
		act.moveToElement(PS).build().perform();
		Thread.sleep(3000);
		RB.click();
		
		driver.close();
	}

}

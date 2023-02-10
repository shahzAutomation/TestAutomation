package com.TestProject.testScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Basics4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver dr = new ChromeDriver();
		dr.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		dr.manage().window().maximize();
		
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement month = dr.findElement(By.name("birthday_month"));
		
		Select obj = new Select(month);
		
		obj.selectByIndex(6);
		Thread.sleep(3000);
		obj.selectByVisibleText("Aug");
		Thread.sleep(3000);
		obj.selectByValue("1");
		
		List<WebElement> lst = obj.getOptions();
		
		System.out.println(lst);
		String expValue = "Apr";
		for(int i=0;i<lst.size();i++)
		{
			String actValue = lst.get(i).getText();
			System.out.println(actValue);
			if(actValue.equals(expValue))
			{
				obj.selectByIndex(i);
				break;
			}
		}
		Thread.sleep(5000);
		
		dr.quit();
		
		
	}

}

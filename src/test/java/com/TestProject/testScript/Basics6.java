package com.TestProject.testScript;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Basics6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91798\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement FN = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement LN = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement Email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		
		act.sendKeys(FN, "John").build().perform();
		Thread.sleep(5000);
		
		act.click(LN).sendKeys("99897979888").build().perform();
		Thread.sleep(5000);
		act.keyDown(LN,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		act.keyDown(LN,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		act.keyDown(Email,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		driver.close();
	}

}

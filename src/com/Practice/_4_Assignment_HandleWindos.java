package com.Practice;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_Assignment_HandleWindos {

	public static void main(String[] args) {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		//Click on 'Multiple windows' link and then on 'click here' link
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		//Switch to child window
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> it = allWindows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		//Switch back to parent window
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		

	}

}

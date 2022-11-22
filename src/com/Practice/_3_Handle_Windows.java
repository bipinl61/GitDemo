package com.Practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_Handle_Windows {

	public static void main(String[] args) {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		
		//Click on the 'Free access...' link
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		//Get window ids of parent and child window
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> it = allWindows.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		//Switch focus of webdriver to child window
		driver.switchTo().window(childWindowId);
		
		//Find webelement to get the text
		WebElement completeMessage = driver.findElement(By.cssSelector("p.im-para.red"));
		System.out.println("Complete message text is: " +completeMessage.getText());
		//Parse the text to get only email id from the complete message
		String emailId = completeMessage.getText().split("at ")[1].split(" ")[0].trim();
		System.out.println("Email id is: " +emailId);
		
		//Move webdriver focus to parent window and close the browser
		driver.switchTo().window(parentWindowId);
		driver.quit();

	}

}

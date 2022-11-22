package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _7_Assignment_Frames {

	public static void main(String[] args) {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		//Click on the Nested Frames link
		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
		
		//Identify the parent frame and switch driver focus to that frame
		//WebElement topFrame = driver.findElement(By.name("frame-top"));
		driver.switchTo().frame("frame-top");	// Frame name is "frame-top"
		
		////Identify the child frame and switch driver focus to that frame and print the 'Middle' text
		//WebElement middleFrame = driver.findElement(By.name("frame-middle"));
		driver.switchTo().frame("frame-middle");	// Frame name is "frame-middle"
		String textOnFrame = driver.findElement(By.id("content")).getText();
		System.out.println(textOnFrame);

	}

}

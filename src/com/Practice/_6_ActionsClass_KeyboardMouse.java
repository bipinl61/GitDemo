package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _6_ActionsClass_KeyboardMouse {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		//Type username in capital letters
		WebElement usernameTextbox = driver.findElement(By.id("username"));
		Actions action = new Actions(driver);
		action.moveToElement(usernameTextbox).click().keyDown(Keys.SHIFT).sendKeys("rahul").build().perform();
		Thread.sleep(2000);
		
		//Copy the entered username using shortcut 'ctrl + a' and paste it in password textbox using shortcut 'ctrl + v'
		action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		Thread.sleep(2000);
		
		WebElement passwordTextbox = driver.findElement(By.id("password"));
		passwordTextbox.click();
		action.keyDown(Keys.CONTROL).sendKeys("v").build().perform();			//Paste i.e.'ctrl + v' not working
		Thread.sleep(2000);
		
		

	}

}

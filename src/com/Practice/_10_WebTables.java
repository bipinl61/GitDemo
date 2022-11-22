package com.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _10_WebTables {

	public static void main(String[] args) {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		//Identify the locator for all the amount values using parent child relationship of css selector
		List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		//Get the text of the amounts from amount column.
		//Since the amounts are of string type convert it into int and perform addition
		int sum = 0;
		for(int i=0; i<amounts.size(); i++)
		{
			sum = sum + Integer.parseInt(amounts.get(i).getText());
		}
		
		//Get sum of amounts displayed on web page
		WebElement totalAmount = driver.findElement(By.cssSelector("div.totalAmount"));
		int sumOfAmounts = Integer.parseInt(totalAmount.getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, sumOfAmounts);
		
	}

}

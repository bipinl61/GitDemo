package com.Practice;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_AddItemsInCart_ {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		// Store the items we want to add in the cart into an array 
		String[] itemsToAdd = {"Brocolli", "Cucumber", "Carrot"};
		addItems(driver, itemsToAdd);
		
	}

	public static void addItems(WebDriver driver, String[] itemsToAdd) throws InterruptedException {
		int j=0;
		
		//convert array of vegetable we want to add to cart into array list for easy search
		List itemsNeededList = Arrays.asList(itemsToAdd);
		
		// Identify the list of all the items available on the web page 
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		
		// Split the item names we got from web page, trim it and store it in the list
		for(int i=0; i<items.size(); i++) 
		{
			String[] itemName = items.get(i).getText().split("-");
			String formattedName = itemName[0].trim();
			
			// Check if the formatted name is present in the array list of vegetables we want to add into cart
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsToAdd.length)
				{
					break;
				}
			}
		}
		Thread.sleep(2000);
	}
	
}


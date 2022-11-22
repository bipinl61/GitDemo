package com.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _12_AutoSuggestiveDropdown_Assignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//Type 'uni' in the Select Countries textbox
		WebElement autoSuggestTextbox = driver.findElement(By.id("autocomplete"));
		autoSuggestTextbox.sendKeys("uni");
		Thread.sleep(2000);
		
		//
		List<WebElement> listOfCountries = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
		
		for(int i=0; i<listOfCountries.size(); i++)
		{
			if(listOfCountries.get(i).getText().equals("United Kingdom (UK)"))
			{
				Actions action = new Actions(driver);
				action.moveToElement(listOfCountries.get(i)).click().build().perform();
				Thread.sleep(1000);
				System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
				
			}
		}
		
	}

}

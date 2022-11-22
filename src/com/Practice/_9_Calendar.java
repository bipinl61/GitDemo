package com.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _9_Calendar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		//Click on the departure text to open dropdown
		driver.findElement(By.cssSelector("label[for='departure']")).click();
		Thread.sleep(2000);
		
		WebElement nextMonthBtn = driver.findElement(By.cssSelector("span[aria-label='Next Month']"));
		
		//Get the text of the month displayed in first calendar ui and click on next month button until 'December' is displayed in first calendar ui
		while(!driver.findElement(By.cssSelector("div[class='DayPicker-Caption']:first-child")).getText().contains("December")) {
			nextMonthBtn.click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		
		//Identify list of all the dates displayed in both the calendars
		List<WebElement> dates = driver.findElements(By.cssSelector("div.dateInnerCell p:first-child"));
		int countOfDates = dates.size();
		System.out.println(countOfDates);
		
		//Get the text of the dates and click when the date matches 31
		for(int i=0; i<countOfDates; i++)
		{
			if(dates.get(i).getText().equals("31"))
			{
				dates.get(i).click();
				break;
			}
		}

	}

}

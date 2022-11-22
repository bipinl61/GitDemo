package com.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _8_Links {

	public static void main(String[] args) {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//Print total no. of links on the page
		System.out.println("No. of links on webpage: "+driver.findElements(By.tagName("a")).size());
		
		//Print no. of links available in footer by identifying the locator using parent-child relationship
		System.out.println("No. of links in footer (using locator) : "+driver.findElements(By.xpath("//table[@class='gf-t'] //a")).size());
		
		//Another way to identify no. of links available under footer section by limiting the scope of webdriver
		//First identify the webelement for footer section and then identify the locator to get all the links available under footer using the footer webelement
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println("No. of links in footer (by limiting webdriver scope): " +footer.findElements(By.tagName("a")).size());
		
		//Click on the links available under 'Discount Coupons' section in footer
		WebElement discountSection = driver.findElement(By.xpath("//tr/td[1]/ul"));
		List<WebElement> linksUnderDiscuontSection = discountSection.findElements(By.tagName("a"));
		
		for(int i=0; i<discountSection.findElements(By.tagName("a")).size(); i++)
		{
			linksUnderDiscuontSection.get(i).click();
		}
		

	}

}

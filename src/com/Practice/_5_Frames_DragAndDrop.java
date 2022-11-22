package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _5_Frames_DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		//Click on 'droppable' link
		driver.findElement(By.xpath("//a[contains(text(),'Droppable')]")).click();
		
		//Identify the no of frames available in the page
		System.out.println("Frames available on page: " + driver.findElements(By.tagName("iframe")).size());
		
		//Switch driver focus to frame and perform drag and drop
		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		WebElement draggableElement = driver.findElement(By.id("draggable"));
		WebElement droppableElement = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(draggableElement, droppableElement).build().perform();
		Thread.sleep(2000);
		
		//Switch the driver focus to default window
		driver.switchTo().defaultContent();
		
		//Click on the 'Accept' link on the main window
		driver.findElement(By.xpath("//a[contains(text(),'Accept')]")).click();

	}

}

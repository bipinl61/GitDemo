package com.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.remote.strprotocol.AbstractRemoteTestRunnerClient.ServerConnection;

public class _11_WebTables_Assignment {

	public static void main(String[] args) {
		System.setProperty("driver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//Print no. of rows in table
		List<WebElement> countOfRowsInTable = driver.findElements(By.cssSelector(".table-display tr"));
		System.out.println("No. of rows: " +countOfRowsInTable.size());
		
		//Print no. of columns in table
		List<WebElement> countOfColumnsInTable = driver.findElements(By.cssSelector(".table-display th"));
		System.out.println("No. of columns: " +countOfColumnsInTable.size());

		//Print content of 2nd row of the table in 1 line
		WebElement secondRowContent = driver.findElement(By.cssSelector(".table-display tr:nth-child(3)"));
		System.out.println("Content of 2nd row is: \n" + secondRowContent.getText());
		
		//Print content of 2nd row for each column separately
		List<WebElement> secondRowContentColumnwise = driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));
		System.out.println(secondRowContentColumnwise.get(0).getText());
		System.out.println(secondRowContentColumnwise.get(1).getText());
		System.out.println(secondRowContentColumnwise.get(2).getText());
	}

}

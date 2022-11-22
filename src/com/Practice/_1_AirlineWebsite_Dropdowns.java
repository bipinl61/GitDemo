package com.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _1_AirlineWebsite_Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		/*#################################### Handle auto suggestive dropdown #############################################
		 ############ Type 'ind' in the country textbox and select 'India' from the auto suggestive dropdown #############*/
		
		WebElement countryTxtbox = driver.findElement(By.id("autosuggest"));
		countryTxtbox.sendKeys("Ind");
		List<WebElement> countryList = driver.findElements(By.cssSelector("li.ui-menu-item a"));
		
		for (int i=0; i<countryList.size(); i++)
		{
			if(countryList.get(i).getText().equalsIgnoreCase("India"))
			{
				countryList.get(i).click();
				break;
			}
		}
		
		
		// Click on Round trip radio button
		WebElement roundTripRadioBtn = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		roundTripRadioBtn.click();
		Thread.sleep(2000);
		
		// Select Pune as the departure city in dropdown
		WebElement departureDropdwn = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		departureDropdwn.click();
		WebElement dropdwnOptionPune = driver.findElement(By.cssSelector("a[value='PNQ']"));
		dropdwnOptionPune.click();
		
		
		/*#################################### Handle dynamic dropdown ############################################################
		 * Select 'Mumbai' in the To dropdown using xpath using parent child relationship ####################################*/
		WebElement dropdwnOptionMumbai = driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BOM']"));
		dropdwnOptionMumbai.click();
		
		//Handle Calender -- Select current date as departure date
		WebElement departDate = driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight"));
		departDate.click();
		
		
		/*#################################### Handle dropdown - use for loop to click multiple times to add passangers ########################
		 * Click on Passangers dropdown and add 6 adults & 2 infants ####################################*/
		WebElement passangerDropdwn = driver.findElement(By.id("divpaxinfo"));
		passangerDropdwn.click();
		
		for(int i=0; i<5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		for(int j=0; j<2; j++)
		{
			driver.findElement(By.id("hrefIncInf")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
		/*#################################### Handle static dropdown having Select tag ####################################
		 * Select currency as INR in currency dropdown ####################################################################*/
		WebElement currencyDropdwn = driver.findElement(By.cssSelector("select[id*='DropDownListCurrency']"));
		
		Select select = new Select(currencyDropdwn);
		select.selectByVisibleText("INR");
		
		//Check Friends and Family checkbox
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		Thread.sleep(5000);
		
		//Click on search button
		driver.findElement(By.cssSelector("input[name*='FindFlights']")).click();
		
		driver.close();
	}

}

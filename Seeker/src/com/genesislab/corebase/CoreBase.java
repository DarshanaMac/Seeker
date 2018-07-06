package com.genesislab.corebase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CoreBase {
   
	@org.junit.Test
	public void Facebook_Login() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "E:/GenesisLab/GoogleChromeDriver/chromedriver.exe"); //E:\GenesisLab\Google Chrome Driver
		WebDriver unitDriver = new ChromeDriver(options);
		
		
		String userid="https://www.facebook.com/100003585110606";
		// Declaring and initialising the HtmlUnitWebDriver
		// HtmlUnitDriver unitDriver = new HtmlUnitDriver(BrowserVersion.CHROME);
		unitDriver.manage().window().maximize();
		 //unitDriver.setJavascriptEnabled(true);
		unitDriver.get("https://www.facebook.com/");
		// find the search edit box on the google page
		WebElement usernametextfield = unitDriver.findElement(By.id("email"));
		// type in Selenium
		usernametextfield.sendKeys("seeker19931@gmail.com");

		WebElement passwordtextfield = unitDriver.findElement(By.id("pass"));
		passwordtextfield.sendKeys("SeekAdmin19931");

		WebElement loginbutton = unitDriver.findElement(By.xpath("//input[@value='Log In']"));
		loginbutton.click();
		
		unitDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		JavascriptExecutor js=(JavascriptExecutor)unitDriver;
		js.executeScript("window.open('"+userid+"', '_blank');");
		unitDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//double check UI object
		
//		WebElement linkabout = unitDriver.findElement(By.xpath("//div[@id='fbTimelineHeadline']/div[2]/ul/li[2]/a"));
//		linkabout.click();
		
		unitDriver.quit();
	}
	
	@org.junit.Test
	public void initializeFetching()
	{
		
	}
}

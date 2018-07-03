package com.genesislab.corebase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CoreBase {

	@Test
	public void Facebook_Login(){
		
    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
        String baseUrl = "https://www.facebook.com/profile.php?id=100003585110606";
       
        driver.get(baseUrl);
       // driver.findElement(By.xpath("//a[text()='About']")).click();
        
        driver.close();
	}
}

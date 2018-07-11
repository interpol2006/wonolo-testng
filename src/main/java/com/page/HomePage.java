package com.page;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
public class HomePage {
	WebDriver driver ;
	By newJobOption = By.id("nav-new-job");
	public HomePage(WebDriver driver)
	{
		this.driver = driver ;
		
	}
	
	public void clickNewJob()
	{
		driver.findElement(newJobOption).click();
	}
	
	
}

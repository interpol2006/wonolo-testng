package com.page.jobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActiveJobs {
	WebDriver driver;
	By keywordField = By.id("user_name");
	By searchButton = By.id("search-jobs");
	By detailIcon = By.xpath("//div/table/tbody/tr/td[@class='request_actions']/div/div[1]/a/div/span");
	
	public ActiveJobs(WebDriver driver)
	{
		this.driver = driver ;
	}
	
	
	public void open()
	{
		driver.get("https://wonolo-qa.herokuapp.com/job_requests/active");
	}
	
	public void Click(WebElement Element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(Element);
		actions.click().build().perform();
	}
	
	public void inputKeyword(String keyword)
	{
		WebElement keyWordField = driver.findElement(By.xpath("//div[@id='user_name']/input[@placeholder='keyword']"));
		Click(keyWordField);
		//WebDriverWait wait3 = new WebDriverWait(driver, 10);
		//wait3.until(ExpectedConditions.elementToBeClickable(keywordField));
		//driver.findElement(keywordField).click();
		keyWordField.sendKeys(keyword);
		//driver.findElement(keywordField).sendKeys(keyword);
	}
	
	public void clickSearchButton()
	{
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.elementToBeClickable(searchButton));
		
		driver.findElement(searchButton).click();
	}
	
	public void inputKeywordToSearch(String keyword)
	{
		inputKeyword(keyword);
		clickSearchButton();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void clickDetailIcon()
	{
		WebElement element = driver.findElement(detailIcon);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
			
		
	}
	
	
}

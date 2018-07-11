package com.page.jobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class JobDetails {

	WebDriver driver;
	By jobDetailTable = By.xpath("//div[@id='job_request_details_panel']/div/table/tbody");
	By searchButton = By.id("search-jobs");
	By detailIcon = By.xpath("//div/table/tbody/tr/td[@class='request_actions']/div/div[1]/a");
	
	public JobDetails(WebDriver driver)
	{
		this.driver = driver ;
	}
	
	public void verifyJobName(String jobName)
	{
		String s = driver.findElement(By.xpath("//div[@id='job_request_details_panel']/div/table/tbody/tr[4]/td[2]")).getText();
		Assert.assertEquals(jobName, s);
	}
	
	
	
	
}

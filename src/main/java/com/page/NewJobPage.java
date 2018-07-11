package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewJobPage {

	WebDriver driver ;
	By templateDropList = By.id("job_request_template_id");
	// What area
	By classification = By.id("nav-new-job");
	By jobNameFiled = By.id("job_request_request_name");
	By requestorDropList = By.id("job_request_employer_id");
	By categoryDropList = By.id("job_request_category");
	By taskToBePerformedTextBox = By.id("job_request_description_tasks");
	By requirementsField = By.className("string optional form-control");
	By companydescField = By.id("job_request_description_company");
	By traveltipsField = By.id("job_request_description_travel");
	By arrivalInstructionsField = By.id("job_request_description_arrival");
	By noOfWonoloNeededField = By.id("job_request_slots");
	// Where area
	By venueField = By.id("job_request_venue");
	By addressField = By.id("job_request_address");
	By cityField = By.id("job_request_city");
	By zipField = By.id("job_request_zip");
	// When area
	By flexibleStartTimeCheckBox = By.id("job_request_has_flexible_start_time");
	By multiDayJobCheckBox = By.id("job_request_multi_day");
	By startTimeDatePicker = By.id("jri_job_form_start_time");
	By estimatedJobDurationHour = By.xpath("//div/select[@id='job_request_duration_hours']");
	By estimatedJobDurationMinute = By.id("job_request_duration_minutes");
	// Pay area
	By payField = By.id("job_request_wage");
	
	By postJobBtn = By.xpath("//div/input[@id='post_job_button']");
	
	
	public NewJobPage(WebDriver driver)
	{
		this.driver = driver ;
		
	}
	
	public void selectTemplate(String template)
	{
		driver.findElement(templateDropList).click();
		Select templateList = new Select(driver.findElement(templateDropList));
		templateList.selectByVisibleText(template);
	}
	
	public void inputJobName(String jobName)
	{
		driver.findElement(jobNameFiled).sendKeys(jobName);
	}
	
	public void selectCategory(String category)
	{
		driver.findElement(categoryDropList).click();
		Select categoryList = new Select(driver.findElement(categoryDropList));
		categoryList.selectByValue(category);
	}
	
	public void inputTaskToBePerformed(String desc)
	{
		driver.findElement(taskToBePerformedTextBox).sendKeys(desc);
	}
	
	public void inputRequirements(String desc)
	{
		driver.findElement(requirementsField).sendKeys(desc);
	}
	
	public void inputCompanyDesc(String desc)
	{
		driver.findElement(companydescField).sendKeys(desc);
	}
	
	public void inputTravelTips(String desc)
	{
		driver.findElement(traveltipsField).sendKeys(desc);
	}
	
	public void inputArrivalInstructions(String desc)
	{
		driver.findElement(arrivalInstructionsField).sendKeys(desc);
	}
	
	public void inputVenue(String venue)
	{
		driver.findElement(venueField).sendKeys(venue);
	}
	
	public void inputAddress(String address)
	{
		driver.findElement(addressField).sendKeys(address);
	}
	
	public void inputCity(String city)
	{
		driver.findElement(cityField).sendKeys(city);
	}
	public void inputZip(String zip)
	{
		driver.findElement(zipField).sendKeys(zip);
	}
	
	public void clickFlexibleStartTime()
	{
		driver.findElement(flexibleStartTimeCheckBox).click();
	}
	
	public void clickMultiDayJob()
	{
		driver.findElement(multiDayJobCheckBox).click();
	}
	
	public void selectEstimatedJobDurationHour(String hour)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.elementToBeClickable(estimatedJobDurationHour));
		
		Select hourList = new Select(driver.findElement(estimatedJobDurationHour));
		hourList.selectByVisibleText(hour);
	}
	
	public void selectEstimatedJobDurationMinute(String minute)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.elementToBeClickable(estimatedJobDurationMinute));
		
		Select minuteList = new Select(driver.findElement(estimatedJobDurationMinute));
		minuteList.selectByVisibleText(minute);
	}
	
	public void selectEstimatedJobDuration(String hour ,String minute)
	{
		selectEstimatedJobDurationHour(hour);
		selectEstimatedJobDurationMinute(minute);

	}
	
	public void inputPay(String pay)
	{
		driver.findElement(payField).sendKeys(pay);
	}
	
	public void clickPostJob()
	{
//		WebDriverWait wait3 = new WebDriverWait(driver, 10);
//		wait3.until(ExpectedConditions.visibilityOfElementLocated(postJobBtn)).click(); ;
		WebElement element = driver.findElement(postJobBtn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		//driver.findElement(postJobBtn).click();
	}

	public void selectRequestor(String requestor) {
		driver.findElement(requestorDropList).click();
		Select templateList = new Select(driver.findElement(requestorDropList));
		templateList.selectByVisibleText(requestor);
	}
}

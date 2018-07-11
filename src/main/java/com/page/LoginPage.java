package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	By emailField = By.id("user_email");
	By passwordField = By.id("user_password");
	By signInButton = By.name("commit");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver ;
	}
	
	public void inputEmail(String email )
	{
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void inputPassword(String password )
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLogin()
	{
		driver.findElement(signInButton).click();
	}
	
	public void loginWonolo(String email, String password)
	{
		this.inputEmail(email);
		this.inputPassword(password);
		this.clickLogin();
	}
}

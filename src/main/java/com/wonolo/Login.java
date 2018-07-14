package com.wonolo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

import javax.mail.Message;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import com.page.LoginPage;
import com.page.HomePage;
import com.page.NewJobPage;
import com.page.jobs.ActiveJobs;
import com.page.jobs.JobDetails;


public class Login {
  
	private WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	NewJobPage jobPage;
	ActiveJobs activeJob;
	JobDetails jobDetail;
	
	private static EmailUtils email;
//  @BeforeClass
//  public void beforeClass() {
//	 driver = new ChromeDriver();
//	 driver.get("https://wonolo-qa.herokuapp.com/home");
//	  driver.manage().window().maximize();
//	  loginPage = new LoginPage(driver);
//	  loginPage.loginWonolo("ndmtri.nt@gmail.com", "Abc123456");
//	  
//  }
  
	@BeforeClass
	public static void connectToEmail()
	{
		try {
			email = new EmailUtils("tri.nguyen@nfq.asia","Su22051990" , "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
		} catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
  
  
  
//  @Test
//  public void loginWonoloPage() {
//	  
//	  homePage = new HomePage(driver);
//	  
//	  
//	  homePage.clickNewJob();
//	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	  jobPage = new NewJobPage(driver);
////	  
////	
////	  //jobPage.selectTemplate("Children");
//	  jobPage.inputJobName("New Wonolo Job");
//	  jobPage.selectRequestor("Tri Nguyen");
//	  jobPage.selectCategory("Nursing");
//	  jobPage.inputTaskToBePerformed("This is a test");
//	  
//	  //jobPage.inputRequirements("Test requirements");
//	  jobPage.inputCompanyDesc("Test company");
//	  jobPage.inputTravelTips("Travel tips");
//	  jobPage.inputArrivalInstructions("Arrival Instructions");
//	  //Input data for Where area
//	  jobPage.inputVenue("Venue");
//	  jobPage.inputAddress("Address");
//	  jobPage.inputCity("City");
//	  jobPage.inputZip("12345");
//	  
//	//Input data for When area
//	  //jobPage.clickFlexibleStartTime();
//	  //jobPage.clickMultiDayJob();
//	  jobPage.selectEstimatedJobDuration("12", "30");
//	 
//	 //Input data for Pay
//	  jobPage.inputPay("100");
//	  
////	//Click post job
//	  jobPage.clickPostJob();
//	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	  verifyInfo();
//
//  }
//  
//  @Test
//  public void verifyInfo()
//  {
//	   activeJob = new ActiveJobs(driver);
//	   jobDetail = new JobDetails(driver);
//	   
//	   activeJob.open();
//	   activeJob.inputKeywordToSearch("New Wonolo Job");
//	   activeJob.clickDetailIcon();
//	 
//	  jobDetail.verifyJobName("New Wonolo Job");
//  }
  
  @Test
  public void testVerificationCode()
  {
	  try
	  {
		 // Message mail = email.getMessagesBySubject("Grab", true, 5)[0];
		 // Assert.assertTrue(email.isTextInMessage(mail, "You have been approved"));
		 // Assert.assertEquals("Approval message is not in email", email.isTextInMessage(mail, "You have been approved"));
		  Message mail = email.getLatestMessage();
		 // String content = email.getTextFromMessage(mail);
		  String content = email.getMessageContent(mail);
		 Assert.assertTrue(email.isTextInMessage(mail, "2019-11-09"));
		  System.out.println(content);
	  }
	  catch (Exception e)
	  {
		  e.printStackTrace();
		  Assert.fail(e.getMessage());
	  }
  }
  
  @AfterClass
  public void afterClass() {
	 // driver.quit();
  }
}

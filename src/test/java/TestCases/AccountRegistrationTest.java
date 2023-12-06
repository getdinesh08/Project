package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Homepage;
import PageObjects.RegistrationPage;
import TestBase.Baseclass;

public class AccountRegistrationTest extends Baseclass {
	
	@Test(groups={"Master","Sanity"})
	public void test_registration() throws InterruptedException 
	{
		//logger.debug("application logs......");
		
		logger.debug("application logs......");
		logger.info("Getting started");
		
 try {
		Homepage hp=new Homepage(driver);
		
		hp.clickonmyAccount();
		
		hp.clickonregister();
		
		logger.info("Clicked on register");
		RegistrationPage rp=new RegistrationPage(driver);
		
		rp.setfirstname(RandomString());
		
		 rp.setlastname(RandomString());
		
		rp.setemail(RandomAlphanumeric()+"@gmail.com");
		
	
		
		rp.setpassword(RandomAlphanumeric());
		
		rp.clickonagree();
		
		
		rp.clickoncontinue();
		
		logger.info("clicked on continue");
		String string=rp.getconfirmation();
		logger.info("Validating");
		
		Assert.assertEquals(string, "Congratulations! Your new account has been successfully created!");
		
		
	 }
		catch(Exception e)
		{
			e.printStackTrace();
			
			System.out.println(e.getMessage());
			System.out.println("it failed");
			
			Assert.fail();
		}
		
		
		
	}}
	
	
	
	
	
	
	



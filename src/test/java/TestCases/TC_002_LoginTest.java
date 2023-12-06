package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Homepage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.Baseclass;


public class TC_002_LoginTest extends Baseclass
{
	@Test(groups={"Regression","Sanity"})
	public void test_Login()
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{				
			Homepage hp=new Homepage(driver);
			
			hp.clickonmyAccount();
						
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rc.getString("email")); // valid email, get it from properties file
			
			lp.setPassword(rc.getString("password")); // valid password, get it from properties file
			
			lp.clickLogin();
			
			MyAccountPage macc=new MyAccountPage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");
		
	}
	
	
}



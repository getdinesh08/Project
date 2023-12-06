package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Homepage;
import TestBase.Baseclass;


public class TC_003_LoginDataDrivenTest extends Baseclass {

	@Test(dataProvider = "LoginData", dataProviderClass = TestBase.DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			Homepage hp = new Homepage(driver);
			hp.clickonmyAccount();
			hp.clickLogin();

			PageObjects.LoginPage lp = new PageObjects.LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			PageObjects.MyAccountPage macc=new PageObjects.MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();// this method is created MyAccountPage

			if (exp.equals("Valid")) {
				if (targetpage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					PageObjects.MyAccountPage myaccpage = new PageObjects.MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_003_LoginDataDrivenTest");

	}

}

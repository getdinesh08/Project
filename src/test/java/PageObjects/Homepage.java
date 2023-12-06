package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {
	
	
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement myaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement register;
	
	@FindBy(linkText = "Login")   // Login link added in step6
	WebElement linkLogin;
	public void clickonmyAccount()
	{
		myaccount.click();
	}
	
	public void clickonregister()
	{
		register.click();
	}
	public void clickLogin()    // added in step6
	{
		linkLogin.click();
	}
	
	
	
	
	

}

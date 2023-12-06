package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage  extends BasePage{
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	

	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement input_firstname;
	
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement input_lastname;

	
	@FindBy(xpath="//input[@id='input-email']") WebElement input_email;
	
	
	
	@FindBy(xpath="//input[@id='input-password']") WebElement input_password;
	
	
	@FindBy(xpath="//input[@name='agree']") WebElement radio_agree;
	
	
	@FindBy(xpath="//button[normalize-space()='Continue']") WebElement btn_Continue;
	
	@FindBy(xpath="//p[contains(text(),'Congratulations')]") WebElement confirmation;
	
	

	


	
	public void setfirstname(String firstname)
	{
		input_firstname.sendKeys(firstname);
	}
	
	public void setlastname(String lastname)
	{
		input_lastname.sendKeys(lastname);
	}
	
	public void setemail(String email)
	{
		input_email.sendKeys(email);
	}
	
	public void setpassword(String password)
	{
		input_password.sendKeys(password);
	}
	
	public void clickonagree()
	{
		radio_agree.click();
	}
	
	public void clickoncontinue()
	{
		btn_Continue.click();
	}
	
	
	public String getconfirmation()
	{
		
		String data=confirmation.getText();
		return data;
	}
	
}

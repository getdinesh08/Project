package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	
	public static WebDriver driver;
	public ResourceBundle rc;
	public Logger logger;
	@BeforeClass(groups = { "Master", "Sanity", "Regression" })
	@Parameters ("Browser")
	public void setup(String br)
	{
		rc=rc.getBundle("config");
		
		logger=LogManager.getLogger(this.getClass());
		
		if(br.equals("Chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("Edge"))
				{
			driver=new EdgeDriver();
				}
		else if(br.equals("Firefox"))
		{
		driver=new FirefoxDriver();
	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/");
	}
	@AfterClass(groups = { "Master", "Sanity", "Regression" })
	public void teardown()
	{
		driver.quit();
	}
	
	
	public String RandomString()
	{
		
		String generatedstr=RandomStringUtils.randomAlphabetic(9);
		
		return generatedstr;
	}
	public String RandomInt()
	{
		
		String generatedint=RandomStringUtils.randomNumeric(10);
		
		return generatedint;
	}
	
	public String RandomAlphanumeric()
	{
		String generatedstrn=RandomStringUtils.randomAlphanumeric(8);
		
		
		return generatedstrn;
		
	}
	public String captureScreen(String tname) throws IOException {
		
		SimpleDateFormat sm=new SimpleDateFormat("ddmmyyyy");
		
		Date dt=new Date();
		
		String timestamp=sm.format(dt);
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String destination=System.getProperty("user.dir") + "\\screenshots\\"  + tname+ " _ "+  timestamp  +"_" +".png";
		try {
		FileUtils.copyFile(source, new File(destination));
		}
	 catch (Exception e) {
		e.getMessage();
	}
	return destination;

		
		
		
		
		
	}
	


	
	
	
	
	
	
}

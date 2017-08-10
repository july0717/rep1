package yahoo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ConfigurationListener.class,MethodListener.class,ATUReportsListener.class})
public class Home extends Driverclass
{
		
	{
		System.setProperty("atu.reporter.config","d:\\atu.properties");
	}
    public void open()
	{
		driver.manage().window().maximize();
		driver.get("http://www.yahoomail.com");
	}
	public void login() throws Exception
	{
		open();
		driver.findElement(By.name("username")).sendKeys("venkat123456a");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("mqq987654");
		driver.findElement(By.name("verifyPassword")).click();
		Thread.sleep(5000);
	}
	
	public void createacc() throws Exception
	{
		open();
		driver.findElement(By.id("createacc")).click();
		Thread.sleep(5000);
		try
		{
			if(driver.findElement(By.name("firstName")).isDisplayed())
			{
				//Reporter.log("<font color='green'><b>Reg page is displayed</b></font>");
				ATUReports.add("Reg page is displayed",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		}
		catch(Exception e)
		{
			ATUReports.add("Reg page NOT displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}
}

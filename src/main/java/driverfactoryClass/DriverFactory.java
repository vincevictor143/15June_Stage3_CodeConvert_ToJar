package driverfactoryClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory 
{
	static WebDriver driver;

	public WebDriver initBrowser(String browserName) throws MalformedURLException
	{
		if(browserName.equals("Chrome"))
		{
			 driver=new ChromeDriver();
			
			
		}
		else if(browserName.equals("Firefox"))
		{
			driver=new FirefoxDriver();
			
		}

		
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	

}

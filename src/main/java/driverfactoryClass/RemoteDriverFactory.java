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

public class RemoteDriverFactory 
{
	static WebDriver driver;

	public WebDriver initBrowser(String browserName) throws MalformedURLException
	{
		Capabilities capabilities = null;
		
		if(browserName.equals("Chrome"))
		{
			
			capabilities=new ChromeOptions();
			
		}
		else if(browserName.equals("Firefox"))
		{
			capabilities=new FirefoxOptions();
			
		}
		
		 driver=new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"),capabilities);
	
		
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	

}

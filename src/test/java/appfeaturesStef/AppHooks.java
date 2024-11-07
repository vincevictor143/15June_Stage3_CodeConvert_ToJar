package appfeaturesStef;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactoryClass.DriverFactory;
import driverfactoryClass.RemoteDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ConfigReader;

public class AppHooks 
{
	WebDriver driver;
	RemoteDriverFactory rdf ;
    
	@Before
	public void initiateBrowser() throws IOException
	{
		ConfigReader cr=new ConfigReader();
		
		String browserName = cr.readConfig("browserName");
		
		String maven_browsername=System.getProperty("clibrowser");
		
		if(maven_browsername!=null)
		{
			browserName=maven_browsername;
		}
		
		rdf = new RemoteDriverFactory();
		driver=rdf.initBrowser(browserName);
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@After
	public void afterScenario(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("D:\\Pinspire\\ATT_15 June_Morning\\"+scenario.getName()+".png"));
		}
	}

}

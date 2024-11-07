package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader 
{
	public String readConfig(String valueToBeRead) throws IOException
	{
		Properties prop=new Properties();
		String file="Config\\config.properties";
	    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
	    prop.load(inputStream);
	    String value = prop.getProperty(valueToBeRead);

	    return value;
	    
	}
	

	
}

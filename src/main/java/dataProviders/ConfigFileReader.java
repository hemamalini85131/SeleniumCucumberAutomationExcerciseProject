package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;

public class ConfigFileReader {

	
	private Properties properties;
	private final String propertyFilePath="src/test/resources/configs/configuration.properties";
	
	public ConfigFileReader()
	{
		BufferedReader reader;
		try
		{
			reader=new BufferedReader(new FileReader(propertyFilePath));
			properties=new Properties();
			
			try
			{
				properties.load(reader);
				reader.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			throw new  RuntimeException("Configuration.properties not fount at -->" +propertyFilePath);
		}
		
	}
	
	 
	
	public String getDriverPath()
	{
		String driverPath=properties.getProperty("driverPath");
		if(driverPath!=null)
			return driverPath;
		else
			throw new RuntimeException("driverPath is not specified in the Configuration.properties file");
	}
	
	public long getImplicitlyWait()
	{
		String implicitlyWait=properties.getProperty("implicitlyWait");
		if(implicitlyWait!=null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait is not specified in Configuration.properties file");
					
	}
	public String getUrl()
	{
		String url=properties.getProperty("url");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("url is not specified in Configuration.properties file");
	}
	
	public DriverType getBrowser()
	{
		String browserName=properties.getProperty("browser");
		if(browserName==null||browserName.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("fireFox"))
			return DriverType.FIREFOX;
		else if(browserName.equalsIgnoreCase("internetExplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException("browser key value is not specified in Configuration.properties file");
	}
	
	public Boolean getWindowMaximize()
	{
		String windowMaximize=properties.getProperty("windowMaximize");
	    if(windowMaximize!=null)
	    	return Boolean.valueOf(windowMaximize);
	    else
	    	throw new RuntimeException("windowMaximize is not specified in Configuration.properties file");
	}
 }
 
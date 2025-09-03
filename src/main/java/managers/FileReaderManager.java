package managers;

import dataProviders.ConfigFileReader;
import managers.FileReaderManager;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager=new FileReaderManager();
	private static ConfigFileReader configFileReader;
	
	private FileReaderManager()
	{}
	
	public static FileReaderManager getInstance()
	{
		 
		 return fileReaderManager;
	}
	
	public  ConfigFileReader getConfigFileReader()
	{
		if (configFileReader==null)
		{
			configFileReader= new ConfigFileReader();
			
		}
		
		
		return configFileReader;
		
		
	}
	
	

}


package managers;
import dataProviders.ConfigFileReader;

public class FileReaderManager {
	
	private static ConfigFileReader configFileReader;
	
	private static FileReaderManager fileReaderManager  = new FileReaderManager();
	
	private FileReaderManager() {
		
	}
	 public static FileReaderManager getInstance()
	 {
		 return fileReaderManager;
	 }
	
	 public ConfigFileReader getConfigFileReader()
	 {
		 
		 return (configFileReader == null) ? new ConfigFileReader():configFileReader;
		 
	 }
	 
	 

}

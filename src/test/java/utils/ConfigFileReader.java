package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath= "src/test/resources/uat.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("properties file not found at " + propertyFilePath);
		}		
	}
	

	public String getApplicationUrl() {
		String url = properties.getProperty("web.url");
		if(url != null) return url;
		else throw new RuntimeException("web url not specified in the properties file.");
	}
	
	//String port = properties.getProperty("port");
	
}

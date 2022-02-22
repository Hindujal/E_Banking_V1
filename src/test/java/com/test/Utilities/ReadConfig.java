package com.test.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties configProperties;
	
	public ReadConfig() {
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream f=new FileInputStream(src);
			configProperties=new Properties();
			configProperties.load(f);
		}catch (Exception e) {
			System.out.println("Exception is :"+e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url=configProperties.getProperty("baseURL");
		return url;		
	}
	public String getUserName() {
		String name=configProperties.getProperty("userName");
		return name;		
	}
	public String getPassword() {
		String password=configProperties.getProperty("password");
		return password;		
	}
	public String getChromePath() {
		String chromepath=configProperties.getProperty("chromePath");
		return chromepath;
	}
	public String getFFPath() {
		String FFpath=configProperties.getProperty("ffPath");
		return FFpath;
	}
}

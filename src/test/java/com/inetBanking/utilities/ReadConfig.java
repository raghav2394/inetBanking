package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties property;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			property =new Properties();
			property.load(fis);
	
		}catch(Exception e) {
			System.out.println("exception is:"+ e);
		}
	}
	
	public String getApplicationUrl() {
		String url =property.getProperty("baseurl");
		return url;
	}
	
	public String getusername() {
		String username =property.getProperty("username");
		return username;
	}
	
	public String getpassword() {
		String password =property.getProperty("password");
		return password;
	}
	
	public String getchromepath() {
		String chromepath =property.getProperty("chromepath");
		return chromepath;
	}
}

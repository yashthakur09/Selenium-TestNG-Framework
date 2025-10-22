package com.utility;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import com.constants.Env;

public class PropertyUtil{
	
	public static String readProperties(Env env, String url) {
		File propFile=new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");
		FileReader fileReader = null;
		Properties properties=new Properties();
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String value=properties.getProperty(url.toUpperCase());
		return value;
		
	}
}

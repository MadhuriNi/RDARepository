package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
	
	public Properties read() 
	{
		Properties prop=null;
		try {
			File src=new File(".//Configuration//Config.property");
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} 
		
		catch (Exception e) {
			System.out.println("The exception is "+e);
		} 
		
		return prop;
	}

}

package SeleniumRDA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Utility.readConfig;
//import org.testng.annotations.Test;

public class base {
	
	public static WebDriver driver;
	Properties prop;
	
	
	public WebDriver initializeDriver() throws Exception
	{
		readConfig rc=new readConfig();
		prop=rc.read();
		
		String Browser=prop.getProperty("Browser");
				
		if(Browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty(prop.getProperty("FirefoxDriverPath"),prop.getProperty("FirefoxDriver"));
			 driver=new FirefoxDriver();			
		}
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(prop.getProperty("ChromeDriverPath"), prop.getProperty("ChromeDriver"));
			driver=new ChromeDriver();
		}
		
		if(Browser.equalsIgnoreCase("ie"))
		{
			System.setProperty(prop.getProperty("IEDriverPath"), prop.getProperty("IEDriver"));
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		return driver;
		
	}
	

}

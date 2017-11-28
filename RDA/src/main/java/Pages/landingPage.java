package Pages;

import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import Utility.logged;
import Utility.readConfig;

public class landingPage {
	
	
	WebDriver driver;
	Logger logger;
	Properties prop;
	
	public landingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By tracking_id=By.xpath("//em[text()='Tracking # / Trans Id']");
	By tracking_text=By.cssSelector("input[id='trackingNumberForm:trkNbrTxt']");
	//By tracking_text=By.xpath(".//*[@id='trackingNumberForm:trkNbrTxt']");
	By search=By.xpath(".//*[@id='trackingNumberForm:searchBtn']");
	
	public void tracking_info(String trackingNo)
	{
		logged log=new logged();
		logger=log.getlogged("landingPage");
		
		readConfig rc=new readConfig();
		prop=rc.read();
		
		driver.navigate().refresh();
		
		driver.findElement(tracking_id).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		String Browser=prop.getProperty("Browser");
		
		
		if(Browser.equalsIgnoreCase("firefox"))
		{
		driver.findElement(tracking_text).sendKeys(trackingNo);
		}
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	/*	if(Browser.equalsIgnoreCase("chrome"))
		{
			String val=trackingNo;
		
			 for (int i = 0; i < val.length(); i++)
			 {
			        char c = val.charAt(i);
			        String s = new StringBuilder().append(c).toString();
			        driver.findElement(tracking_text).sendKeys(s);
			        
			   }
			 }*/
		driver.findElement(search).click();		
		
	

}
}

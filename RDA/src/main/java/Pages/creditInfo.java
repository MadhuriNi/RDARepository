package Pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.logged;

public class creditInfo {
	
	WebDriver driver;
	Logger logger;
	
	public creditInfo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void getCreditInfo()
	{
		
		logged log=new logged();
		logger=log.getlogged("creditInfo");
		
		By credit_card = By.xpath("//input[@value='Credit CD/Direct DR']");
		Boolean en2=driver.findElement(credit_card).isEnabled();
		logger.info("The status of credit element is "+en2);
		
		if(en2==true)
		{
			logger.info("Credit CD/Direct DR is enabled");
		}
		else
		{
			logger.info("Credit CD/Direct DR is disabled");
		}
	}

}

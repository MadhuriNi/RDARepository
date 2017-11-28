package Utility;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class childWindow {
	
	String parent_window;
	Logger logger;
	
	public WebDriver getChildWindow(WebDriver driver)
	{
		
		logged log=new logged();
		logger=log.getlogged("childWindow");
		
		parent_window=driver.getWindowHandle();
		logger.info("The parent window is "+parent_window);
	
		Set<String> s1=	driver.getWindowHandles();
		logger.info("The size of window handles are  "+s1.size());
		
		
		if(s1.size()>1)
		{
		Iterator<String> li=s1.iterator();
		
		while(li.hasNext())
		{
			String child_window=li.next();
			logger.info("The child window is "+child_window);
			
			if(!parent_window.equalsIgnoreCase(child_window))
			{
				driver.switchTo().window(child_window);
				logger.info("Switched to parent window !!!");
			}
		}
	}
		
		return driver;
	}

	
	public void switchParentWindow(WebDriver driver)
	{
		driver.switchTo().window(parent_window);

	}

}

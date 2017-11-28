package Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class logged {
	
	public Logger getlogged(String className)
	{
		Logger logger=Logger.getLogger(className);
		PropertyConfigurator.configure("Log4j.properties");
		return logger;
	}

}

package SeleniumRDA;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Pages.creditInfo;
import Pages.finalDisplay;
import Pages.intlChargeDetail;
import Pages.landingPage;
import Pages.loginPage;
import Pages.transactionInfo;
import Utility.DBselect;
import Utility.logged;

public class mainClass extends base{
	
	Logger logger;
	ResultSet rs;
	
	@Test
	public void baseNavigation() throws Exception
	{
		logged log=new logged();
		logger=log.getlogged("mainClass");
		
		logger.info("--- In the main Class ---");
		driver=initializeDriver();
		
		if(prop.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
		driver.get("chrome://settings/content/popups");
			Thread.sleep(4000);	
		driver.get(prop.getProperty("URL"));
		}
		else
		{
			driver.get(prop.getProperty("URL"));
		}
		
		logger.info("--- Calling login Page ---");		
		loginPage lp=new loginPage(driver);
		lp.login("862711","862711");
		
		logger.info("--- Calling the dbconnection class ---");
		DBselect db=new DBselect();
		rs=db.verifyDB();
		
		logger.info("returned from db connection class");
		
		while(rs.next())
		{
		
		String job_id=rs.getString("job_id");
		String device=rs.getString("device");
		int test_id=rs.getInt("test_id");
		String trkng=rs.getString("trkng_nbr");
		
		logger.info("The job_id is ^^^^^^^^^^^^^^^^^^^"+job_id);
		logger.info("The device is ^^^^^^^^^^^^^^^^^^"+device);
		logger.info("The test_id is ^^^^^^^^^^^^^^^^^"+test_id);
		logger.info("The tracking number is ^^^^^^^^^^^^^^^^^^^^^^^^^^^"+trkng);
			
		logger.info("--- Calling landing Page ---");		
		landingPage lpg=new landingPage(driver);
		lpg.tracking_info(trkng);
				
		logger.info("--- Calling TransactionInfo Page ---");		
		transactionInfo tI=new transactionInfo(driver);
		//tI.getShipperInfo();
		tI.getShipperInfo(job_id,device,test_id,trkng);
				
		logger.info("--- Calling Final Display ---");
		finalDisplay fd=new finalDisplay(driver);
		fd.getfinalDispInfo(job_id,device,test_id,trkng);
		
		logger.info("--- Calling Credit CD/Direct DR");
		creditInfo di=new creditInfo(driver);
		di.getCreditInfo();
		
		logger.info("--- Intl Charge detail ---");
		intlChargeDetail ic=new intlChargeDetail(driver);
		ic.getChargeDetail(job_id,device,test_id,trkng);

	}
}	
	/*@AfterTest
	public void teardown() {
		driver.close();
	}*/

}

package Pages;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.DBinsert;
import Utility.logged;

public class transactionInfo {
	
	WebDriver driver;
	Logger logger;
	
	public transactionInfo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By shipper_name=By.cssSelector("input[name*='shpNameInTxt']");
	By shipper_acct=By.cssSelector("input[id*='shpAcctInTxt']");
	By shipper_comp=By.cssSelector("input[name*='shpCmpInTxt']");
	By shipper_address1=By.cssSelector("input[id*='shpAddrInTxt']");
	By shipper_address2=By.cssSelector("input[id*='shpAddr2InTxt']");
	By shipper_city=By.cssSelector("input[id*='shpCityInTxt']");
	By shipper_state=By.cssSelector("input[id*='shpStateInTxt']");
	By shipper_zip=By.cssSelector("input[id*='shpZipInTxt']");
	By shipper_country=By.cssSelector("input[id*='shpCntryInTxt']");
	
		
	public void getShipperInfo(String job,String device,int testid,String trkng)
	{
		/*Logger logger=Logger.getLogger("transactionInfo");
		PropertyConfigurator.configure("Log4j.properties");*/
		
		DBinsert db=new DBinsert();
		
		logged log=new logged();
		logger=log.getlogged("transactionInfo");
		
		WebDriverWait wait=new WebDriverWait(driver, 50);
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='trackingNumberForm:srchDtlsDT:0:lobOutTxt']")));
		
		if(ele.isDisplayed()==true)
		{
		logger.info("element is displayed");
		String Shipper_name=driver.findElement(shipper_name).getAttribute("value");
		String Shipper_acct=driver.findElement(shipper_acct).getAttribute("value");
		String Shipper_comp=driver.findElement(shipper_comp).getAttribute("value");
		String Shipper_Address1=driver.findElement(shipper_address1).getAttribute("value");
		String Shipper_Address2=driver.findElement(shipper_address2).getAttribute("value");
		String Shipper_City=driver.findElement(shipper_city).getAttribute("value");
		String Shipper_State=driver.findElement(shipper_state).getAttribute("value");
		String Shipper_Zip=driver.findElement(shipper_zip).getAttribute("value");
		String Shipper_Country=driver.findElement(shipper_country).getAttribute("value");

		
		logger.info("The shipper name is -----"+Shipper_name);
		logger.info("The shipper account is -----"+Shipper_acct);
		logger.info("The shipper Company is -----"+Shipper_comp);
		logger.info("The shipper Address Line 1 is -----"+Shipper_Address1);
		logger.info("The shipper Address Line 2 is -----"+Shipper_Address2);
		logger.info("The shipper City is -----"+Shipper_City);
		logger.info("The shipper State is -----"+Shipper_State);
		logger.info("The shipper Zip is -----"+Shipper_Zip);
		logger.info("The shipper Country is -----"+Shipper_Country);
		
		db.open_connection();
		
		db.insert(job,device,testid,trkng,"Shipper Name",Shipper_name);
		db.insert(job,device,testid,trkng,"Shipper Account",Shipper_acct);
		db.insert(job,device,testid,trkng,"Shipper Company",Shipper_comp);
		db.insert(job,device,testid,trkng,"Shipper Address Line 1",Shipper_Address1);
		db.insert(job,device,testid,trkng,"Shipper Address Line 2",Shipper_Address2);
		db.insert(job,device,testid,trkng,"Shipper City",Shipper_City);
		db.insert(job,device,testid,trkng,"Shipper State",Shipper_State);
		db.insert(job,device,testid,trkng,"Shipper Zip",Shipper_Zip);
		db.insert(job,device,testid,trkng,"Shipper Country",Shipper_Country);
		/*
		try {
			db.insert_batch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
	
}

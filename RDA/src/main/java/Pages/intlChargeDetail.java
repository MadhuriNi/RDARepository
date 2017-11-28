package Pages;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.DBinsert;
import Utility.childWindow;
import Utility.logged;

public class intlChargeDetail {
	
	WebDriver driver;
	Logger logger;
	
	public intlChargeDetail(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void getChargeDetail(String job,String device,int testid,String trkng)
	{
		DBinsert db=new DBinsert();
		
		logged log=new logged();
		logger=log.getlogged("intlChargeDetail");
		
		By intlCharge=By.id("trackingNumberForm:j_idt50");
		driver.findElement(intlCharge).click();
		
		childWindow cw=new childWindow();
		cw.getChildWindow(driver);
		
	//	By usd=By.id("trackingIntlChargeDetail:j_idt67");
		By usd=By.xpath(".//*[@id='trackingIntlChargeDetail:j_idt67']");
		By usd1=By.id("trackingIntlChargeDetail:j_idt80");
		By curr_amt=By.id("trackingIntlChargeDetail:j_idt48");
		
		By chg_cd=By.cssSelector("span[id*='ChargeDetailDetTable:0:j_idt15']");
		By chg_desc=By.cssSelector("span[id*='ChargeDetailDetTable:0:j_idt17']");
		By chg_factor=By.cssSelector("span[id*='ChargeDetailDetTable:0:j_idt19']");
		By rated_curr=By.cssSelector("span[id*='ChargeDetailDetTable:0:j_idt21']");
		
		/*JavascriptExecutor je=(JavascriptExecutor) driver;
		WebElement ele=driver.findElement(By.cssSelector("span[id*='intlChargeDetailDetTable:j_idt32_text']"));
		
		logger.info("the element is "+ele.getText());
		
		je.executeScript("arguments[0].scrollIntoView(true);", ele);
*/		//je.executeScript("document.getElementById('trackingIntlChargeDetail:intlChargeDetailDetTable:j_idt32_text').scrollRight+=100", "");
		
		By billed_curr=By.cssSelector("span[id*='ChargeDetailDetTable:0:j_idt25']");
		By billed_curr_amt=By.cssSelector("span[id*='ChargeDetailDetTable:0:j_idt27']");
		By usd_amt=By.cssSelector("span[id*='ChargeDetailDetTable:0:j_idt29']");
		By origin_curr_amt=By.cssSelector("span[id*='ChargeDetailDetTable:0:j_idt31']");
		By dest_curr_amt=By.cssSelector("span[id*='ChargeDetailDetTable:0:j_idt33']");
		
		
		String USD=driver.findElement(usd).getAttribute("value");
		String USD1=driver.findElement(usd1).getAttribute("value");
		String CURR_AMT=driver.findElement(curr_amt).getAttribute("value");
		
		String Billed_curr=driver.findElement(billed_curr).getAttribute("value");
		String Billed_curr_amt=driver.findElement(billed_curr_amt).getAttribute("value");
		String Usd_amt=driver.findElement(usd_amt).getAttribute("value");
		String Origin_curr_amt=driver.findElement(origin_curr_amt).getAttribute("value");
		String Dest_curr_amt=driver.findElement(dest_curr_amt).getAttribute("value");
		
		logger.info("USD is "+USD);
		logger.info("USD1 is "+USD1);
		logger.info("CURR AMT is"+CURR_AMT);		
		logger.info("Billed Currency is "+Billed_curr);
		logger.info("Billed Currency Amount is "+Billed_curr_amt);
		logger.info("USD AMT is"+Usd_amt);
		logger.info("Origin curr amt is "+Origin_curr_amt);
		logger.info("dest curr amt is "+Dest_curr_amt);
		
		
		db.open_connection();
		
		db.insert(job,device,testid,trkng, "USD",USD );
		db.insert(job,device,testid,trkng, "USD1",USD1 );
		db.insert(job,device,testid,trkng, "CURR AMT",CURR_AMT );
		db.insert(job,device,testid,trkng, "Billed Currency",Billed_curr );
		db.insert(job,device,testid,trkng, "USD AMT",Billed_curr_amt );
		db.insert(job,device,testid,trkng, "Origin Currency Amount",Origin_curr_amt );
		db.insert(job,device,testid,trkng, "Destination Currency Amount",Dest_curr_amt );
		
		try {
			db.insert_batch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		driver.findElement(By.cssSelector("input[id*='closeIntlChargeDetailId']")).click();
		
		cw.switchParentWindow(driver);
		
		

	}

}

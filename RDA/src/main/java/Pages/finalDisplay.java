package Pages;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.DBinsert;
import Utility.childWindow;
import Utility.logged;

public class finalDisplay {
	
	WebDriver driver;
	Logger logger;
	
	public finalDisplay(WebDriver driver) {
		this.driver=driver;
	}
	

	
	public void getfinalDispInfo(String job,String device,int testid,String trkng) throws Exception
	{
		DBinsert db=new DBinsert();
		
		logged log=new logged();
		logger=log.getlogged("finalDisplay");
		
		By final_disp=By.xpath("//input[@value='Final Disp']");
		Boolean en1=driver.findElement(final_disp).isEnabled();
		
		//WebDriverWait wait=new WebDriverWait(driver, 50);
		
		if(en1==true)
		{
			driver.findElement(final_disp).click();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(20);
			
			childWindow cw=new childWindow();
			driver=cw.getChildWindow(driver);
			
			
			//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			
			//WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finalDispForm:svcAreaTxt")));
		
			//if(ele1.isDisplayed()==true)
			//{
			logger.info("Element is visible and Getting child info-------");
			
		//	By final_disp1=By.id("finalDispForm:finalDispTxt");
		//	By final_disp1=By.xpath(".//*[@id='finalDispForm:finalDispTxt']");
			By sig=By.xpath(".//*[@id='finalDispForm:sigNmTxt']");
			By expected_delivery=By.id("finalDispForm:expDelTxt");
			By svc=By.id("finalDispForm:svcAreaTxt");
			By code=By.id("finalDispForm:delLocCdTxt");
			By classcode=By.id("finalDispForm:pofClsCdTxt");
			
			//String Final_disp=driver.findElement(final_disp1).getAttribute("value");
			String Sig=driver.findElement(sig).getAttribute("value");
			String Expected_delivery=driver.findElement(expected_delivery).getAttribute("value");
			String SVC=driver.findElement(svc).getAttribute("value");
			String Code=driver.findElement(code).getAttribute("value");
			String ClassCode=driver.findElement(classcode).getAttribute("value");
			
			//logger.info("The Final display is "+Final_disp);
			logger.info("Signature is "+Sig);
			logger.info("Expected Delivery is "+Expected_delivery);
			logger.info("SVC is "+SVC);
			logger.info("Code is "+Code);
			logger.info("Class Code is "+ClassCode);
			
			
			
			db.open_connection();
			
			db.insert(job,device,testid,trkng, "Signature",Sig );
			db.insert(job,device,testid,trkng, "Expected Delivery",Expected_delivery );
			db.insert(job,device,testid,trkng, "SVC",SVC );
			db.insert(job,device,testid,trkng, "Code",Code );
			db.insert(job,device,testid,trkng, "Class Code",ClassCode );
			
			try {
				db.insert_batch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			driver.findElement(By.cssSelector("input[id*='finalDispCloseButton']")).click();
			
			cw.switchParentWindow(driver);
		//}
			
	}		
		else
		{
			logger.info("final display is not enabled");
		}
		
	}

}

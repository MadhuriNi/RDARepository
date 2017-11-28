package SeleniumRDA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.Test;

public class chromeSettings {

	
	@Test
	public void settings() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("chrome://settings/content/popups");
		Thread.sleep(4000);
		//driver.switchTo().frame("settings");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='middle']")).click();
		//Thread.sleep(4000);
		//driver.findElement(By.xpath("//div[text()='Blocked (recommended)']")).click();
		Thread.sleep(4000);
	}
}

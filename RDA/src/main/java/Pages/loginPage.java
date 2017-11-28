package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By id=By.id("username");
	By pwd=By.name("password");
	By signIn=By.cssSelector("input[id='submit']");
	
	
	
	public void login(String user,String pass)
	{
		driver.findElement(id).sendKeys(user);
		driver.findElement(pwd).sendKeys(pass);
		driver.findElement(signIn).click();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}

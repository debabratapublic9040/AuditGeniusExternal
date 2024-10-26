package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import BaseTest.BasePage;

public class LandingPage extends BasePage{
	
	public boolean status;
	    //Constructor
		public LandingPage(WebDriver driver)
		{
			super(driver);
		}
		
		//Locators
		@FindBy(xpath="//a[@href='#loginModal']") 
		WebElement btn_login;
		@FindBy(xpath="//img[@src='/AuditGenius_External_UAT/Assets/Img/Audit-Genius-Logo_whiteletters.png']") 
		WebElement logo_LandingPage;
		
		//Action Method
		/*public void logoTest()
		{
			try
			{
			    Assert.assertEquals(logo_LandingPage.isDisplayed(),true);
			}
		    catch(Exception e)
		    {
		    	
				Assert.fail();
			}
		}*/
		
		public boolean logoTest()
		{
			
			boolean logostatus = logo_LandingPage.isDisplayed();
			return logostatus;
		
		}
		
		public void clickOnLogin() 
		{
			btn_login.click();
		}
		

}

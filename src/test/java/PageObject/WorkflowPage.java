package PageObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import BaseTest.BasePage;

public class WorkflowPage extends BasePage
{
	public Properties p;
	
	public WorkflowPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='dropdown-toggle user']//span[@class='caret']") 
	WebElement toggle_User_Dropdown;
	@FindBy(xpath="//a[normalize-space()='Logout']") 
	WebElement btn_Logout;
	@FindBy(xpath="//a[normalize-space()='Change Password']") 
	WebElement btn_ChangePassword;
	@FindBy(xpath="//h1//b") 
	WebElement tooltip_userName;
	
	public void logout()
	{
		toggle_User_Dropdown.click();
		btn_Logout.click();
       // Actions act=new Actions(driver);
		//act.moveToElement(toggle_User_Dropdown).moveToElement(btn_Logout).click().perform();
	}
	
	
	/*public void verify_UserName() throws IOException
	{
		try {
	 String userName=tooltip_userName.getText();
	 FileReader file=new FileReader("./src//test//resources//config.properties");
	    p=new Properties();
	    p.load(file);
	    if(userName.equals(p.getProperty("userName")))
	    {
	    	Assert.assertTrue(true);
	    }
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	    
	}*/
}

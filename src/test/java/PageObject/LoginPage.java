package PageObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BaseTest.BasePage;

public class LoginPage extends BasePage{
    
	public Properties p;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='UserName']") 
	WebElement txt_UserName;
	@FindBy(xpath="//input[@id='txtPwd']") 
	WebElement txt_Password;
	@FindBy(xpath="//input[@value='Log in']") 
	WebElement btn_Login;
	@FindBy(xpath="//div[normalize-space()='You have already logged into AuditGenius."
			+ " Would you like to close the existing session and continue with this new session ?']") 
	WebElement msg_Confirmation;
	@FindBy(xpath="//button[normalize-space()='OK']") 
	WebElement ok_btn;
	@FindBy(xpath="//button[normalize-space()='Cancel']") 
	WebElement cancel_btn;
	
	
    
	public void setUserName(String userName) throws IOException
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
	    p=new Properties();
	    p.load(file);
		txt_UserName.sendKeys(p.getProperty("userName"));
	}
	public void setPassword(String password) throws IOException
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
	    p=new Properties();
	    p.load(file);
		txt_Password.sendKeys(p.getProperty("password"));
	}
	public void clickOnOk_Login() throws IOException, InterruptedException
	{
		ok_btn.click();
	}
	public void clickOnLogin() throws InterruptedException
	{
		
		//sol1
		btn_Login.click();

		//sol2
		//btn_Login.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btn_Login).click().perform();
		
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();",btn_Login);
		
		
		//sol5
		//btn_Login.sendKeys(Keys.RETURN);
		
		//sol6
		//WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btn_Login)).click();
	}
	
	public String getConfirmationMSG()
	{
		try {
			return(msg_Confirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	


	
}

package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BaseClass;
import PageObject.LandingPage;
import PageObject.LoginPage;


public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master","Regression"})
	public void logintest() throws IOException
	{
		try
		{
			logger.info("****Started TC002_LoginTest******");
	LandingPage landingP=new LandingPage(driver);
	logger.info("****Click on login link******");
	landingP.clickOnLogin();
	Thread.sleep(10000);	
	LoginPage loginP=new LoginPage(driver);
	Thread.sleep(10000);	
	logger.info("****provide user name******");
	loginP.setUserName(null);
	Thread.sleep(10000);
	logger.info("****provide password******");
	loginP.setPassword(null);
	Thread.sleep(10000);
	logger.info("****click on login btn******");
	loginP.clickOnLogin();
	Thread.sleep(10000);
	String target_message=loginP.getConfirmationMSG();
	String source_message="You have already logged into AuditGenius. "
			+ "Would you like to close the existing session and continue with this new session ?";
	boolean status;
	
	//Assert.assertEquals(loginP.getConfirmationMSG(),"You have already logged into AuditGenius."
			//+ " Would you like to close the existing session and continue with this new session ?");
	
	
	if(status = target_message.equals(source_message))
	{
		logger.info("****click on ok confirmation message if the condition satisfied ******");
		loginP.clickOnOk_Login();
	}
	
  }
    catch(Exception e)
  {
    	logger.info("****Fail the methois if the message is  not correct******");
	Assert.fail();
  }
		logger.info("****Completed TC002_LoginTest******");
 }

}

package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BaseClass;
import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.WorkflowPage;

public class TC003_LogoutTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master","Regression"})
	public void logoutTest() throws IOException, InterruptedException
	{
		try 
		{
		logger.info("****Started TC003_LogoutTest******");
		LandingPage landingP=new LandingPage(driver);
		logger.info("****Click on login link******");
		landingP.clickOnLogin();
		
		LoginPage loginP=new LoginPage(driver);
		logger.info("****provide user name******");
		loginP.setUserName(null);
		logger.info("****provide password******");
		loginP.setPassword(null);
		logger.info("****click on login btn******");
		loginP.clickOnLogin();
		logger.info("****click on ok confirmation message******");
		loginP.clickOnOk_Login();
		Thread.sleep(3000);
		WorkflowPage workflowP=new WorkflowPage(driver);
		logger.info("****click on logout button******");
		workflowP.logout();
		Thread.sleep(3000);
		logger.info("****Logged out from application******");
		
		
		}
		catch(Exception e)
		{
			logger.info("****Method is failed ******");
			Assert.fail();
		}
		logger.info("****Completed TC003_LogoutTest******");
				
	}

}

package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.BaseClass;
import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.WorkflowPage;
import utilities.DataProviders;

public class TC002_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)//getting data providers form different class and for that added 2 arguments 
	public void verify_LoginDDT(String username, String passowrd, String res) throws IOException, InterruptedException
	{
	LandingPage landingP=new LandingPage(driver);
	landingP.clickOnLogin();
	
	LoginPage loginP=new LoginPage(driver);
	loginP.setUserName(username);
	loginP.setPassword(passowrd);
	loginP.clickOnLogin();
	Thread.sleep(2000);
	
	String target_message=loginP.getConfirmationMSG();
	String source_message="You have already logged into AuditGenius. "
			+ "Would you like to close the existing session and continue with this new session ?";
	boolean status = target_message.equals(source_message);
	
	//or
	//Assert.assertEquals(loginP.getConfirmationMSG(),"You have already logged into AuditGenius."
	//	+ " Would you like to close the existing session and continue with this new session ?");
	//Assert.assertEquals(true,status);
	
	//************************************************//
	//Condition or logic for DDT
	/*
	Data is valid - login success - test pass - logout
	Data is valid - login failed - test fail

	Data is invalid - login success- test fail -logout
	Data is invalid - login failed - test pass
	*/
	WorkflowPage workflowP=new WorkflowPage(driver);
	if(res.equalsIgnoreCase("Valid"))
	{
		if(status==true)
		{
			loginP.clickOnOk_Login();
			workflowP.logout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	if(res.equalsIgnoreCase("Invalid"))
	{
		if(status==true)
		{
			loginP.clickOnOk_Login();
			workflowP.logout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	
  }

}

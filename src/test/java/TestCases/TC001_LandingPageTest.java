package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BaseClass;
import PageObject.LandingPage;

public class TC001_LandingPageTest extends BaseClass{
	
	@Test(groups= {"Master"})
	public void logoTest() throws IOException
	{
		try {
		logger.info("****Started TC001_LandingPageTest******");
		LandingPage landingp=new LandingPage(driver);
		boolean status = landingp.logoTest();
		logger.info("****Validate the logo******");
		Assert.assertEquals(true, status);
		}
		catch(Exception e)
		{
			logger.info("****Method is failed due to logo issue******");
			Assert.fail();
		}
		logger.info("****Completed TC001_LandingPageTest******");
	}

}

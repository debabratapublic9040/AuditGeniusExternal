package PageObject;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	     
	    @BeforeClass(groups= {"Sanity","Master","Regression"})
	    @Parameters({"browser","os"})
		public void setUp(String br,String os) throws IOException 
		{
	    	
	    	
	    	FileReader file=new FileReader("./src//test//resources//config.properties");
		    p=new Properties();
		    p.load(file);
		    
		    logger=LogManager.getLogger(this.getClass());
		    
		    logger.info("****Open Browser****");
		   
		    if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		    {
		    	DesiredCapabilities capabilities=new DesiredCapabilities();
		    
		    	//select os
		    	if(os.equalsIgnoreCase("windows"))
		    		
		    	{
		    		capabilities.setPlatform(Platform.WIN11);
		    	}
		    	else if(os.equalsIgnoreCase("linux"))
		    	{
		    		capabilities.setPlatform(Platform.LINUX);
		    	}
		    	else if(os.equalsIgnoreCase("mac"))
		    	{
		    		capabilities.setPlatform(Platform.MAC);
		    	}
		    	else
		    	{
		    		System.out.println("No Matching os");
		    		return;
		    	}
		    	
		    	//select browser
		    	switch(br.toLowerCase())
		    	{
		    	case "chrome":capabilities.setBrowserName("chrome"); break;
		    	case "edge":capabilities.setBrowserName("MicrosoftEdge"); break;
		    	case "firefox":capabilities.setBrowserName("Firefox"); break;
		    	default: System.out.println("No matching browser"); return;
		    	}
		    	logger.info("****launch remote browser****");
		    	driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		    	
		    }
		   
		    if(p.getProperty("execution_env").equals("local"))
		    {
	    		switch(br.toLowerCase())
				{
				case "chrome" : driver=new ChromeDriver();break;
				case "edge" : driver=new EdgeDriver();break;
				case "firefox" : driver=new FirefoxDriver();break;
				default: System.out.println("Invalid Browser");return;
				}

		    }
		    
		    driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  logger.info("****Launch URL****");
			driver.get(p.getProperty("url"));
			  logger.info("****Maximize Browser Window****");
			driver.manage().window().maximize();
		}
		
		@AfterClass(groups= {"Sanity","Master","Regression"})
		public void tearDown()
		{
			  logger.info("****Close the Browser****");
			  logger.info("*************************");
			  driver.quit();
		}
		
		
		public String randomNumber()
		{
			String generatedNumber=RandomStringUtils.randomNumeric(5);
			return generatedNumber;
		}
		public String randomString()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		public String randomAlphaNumeric()
		{
			String generatedNumber=RandomStringUtils.randomNumeric(5);
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return (generatedNumber+"@"+generatedString);
		}
		
		public String captureScreen(String tname) throws IOException
		{
			String timeStamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			
			TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);//get path
			String targetFilePath =System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
			File targetfile=new File(targetFilePath);
			sourceFile.renameTo(targetfile);
			return targetFilePath;
		}


}

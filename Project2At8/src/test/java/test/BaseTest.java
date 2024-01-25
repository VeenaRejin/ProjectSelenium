package test;

import org.testng.annotations.Test;

import constant.Constant;
import utility.ElementUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	WebDriver driver;
  

  
	@Parameters({"browser"})
 
 
  @BeforeMethod(alwaysRun = true)    //Is used when we want to make sure this always runs even if parameters on which this depends fails
	
  public void setUp(@Optional ("chrome")String browser) throws IOException {
	  // driver=new ChromeDriver();
	   
	   
	   
	   if(browser.equalsIgnoreCase("chrome"))
	   {
		   driver=new ChromeDriver();
		  
	   }
	   
	   else if (browser.equalsIgnoreCase("edge"))
	   {
		   driver=new EdgeDriver();
		     
	   }
	   
	 
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	   driver.manage().window().maximize();
	   driver.get(ElementUtility.readPropertiesFile("url")); 
 }
	  
  

  @AfterMethod
 
	  public void afterMethod(ITestResult result) throws IOException 
	  {
		 
			  if(ITestResult.FAILURE==result.getStatus())
			  {
				  
					try{
						//create a timestamp
						//get method name 
				
						TakesScreenshot screenshot=(TakesScreenshot)driver;
						String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new java.util.Date());
						String methodname=result.getMethod().getMethodName();
					
						File src=screenshot.getScreenshotAs(OutputType.FILE);
						String path=Constant.screenshotpath+methodname+dateName+".png";
						File desfile=new File(path);
						FileUtils.copyFile(src,desfile);
						System.out.println("Successfully captured a screenshot");
						
					}catch (Exception e){
						System.out.println("Exception while taking screenshot "+e.getMessage());
					
			  }
	  
			  }
	 // driver.quit();
  }


	  }

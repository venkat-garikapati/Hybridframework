package com.Hybridframework.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Hybridframework.utilites.Readconfig;

public class Baseclass 
{
	Readconfig obj=new Readconfig();
	public String baseurl=obj.geturl();
	public String username=obj.getusername();
	public String password=obj.getpassword();
	public static  WebDriver driver;
	public static Logger log;
	@Parameters("browser")
    @BeforeClass
	public void setup(String br)
	{
		 log=Logger.getLogger("Hybridframework");
		 PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",obj.getchromepath());
			 driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",obj.getfirefoxpath());
			 driver=new FirefoxDriver();
		}
        
		driver.get(baseurl);
    	driver.manage().window().maximize();
		}
    @AfterClass
    public void teardown()
    {
    	driver.quit();
    }
    public void capturescreen(WebDriver driver,String tname) throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	File target=new File(System.getProperty("user.dir")+"/screenshots/"+ tname + ".png");
    	FileUtils.copyFile(source,target);
    	System.out.println("screenshot taken");
    	
    }

	

}

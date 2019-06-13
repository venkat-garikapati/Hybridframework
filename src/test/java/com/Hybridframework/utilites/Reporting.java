package com.Hybridframework.utilites;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onstart(ITestContext testContext)
	{
		//String timestamp=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date(0));
		htmlreporter=new ExtentHtmlReporter("./reports/samplereport.html");
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "venkat");
		
		htmlreporter.config().setDocumentTitle("hybrid");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.DARK);
	}
	public void ontestsuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		
	}
	public void ontestfailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
		File f=new File(screenshotpath);
		if(f.exists())
		{
			try
			{
				// add screenshot to the report
				logger.fail("screenshot is below:"+logger.addScreenCaptureFromPath(screenshotpath));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		}
	public void ontestskipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
				 
	}
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	}
	

}

package com.Hybridframework.testcases;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import com.Hybridframework.pageobjects.Loginpage;
import junit.framework.Assert;

public class TC_Logintest_001 extends Baseclass 
{
	
    @Test
    public void logintest() throws IOException
    {
    	
    	
    	Loginpage obj=new Loginpage(driver);
    	obj.typeusername(username);
    	
    	obj.typepassword(password);
    	
    	obj.clicklogin();
    	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
    	{
    		Assert.assertTrue(true);;
    	}
    	else
    	{
    		capturescreen(driver,"logintest");
    		Assert.assertFalse(false);
    		
    	}
    	
    	
    }
   
	

}

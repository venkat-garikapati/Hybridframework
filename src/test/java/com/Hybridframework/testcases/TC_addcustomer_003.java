package com.Hybridframework.testcases;

import org.testng.annotations.Test;

import com.Hybridframework.pageobjects.Addcustomer;
import com.Hybridframework.pageobjects.Loginpage;

public class TC_addcustomer_003 extends Baseclass
{
	@Test
	public void addnewcustomer() throws InterruptedException
	{
		Loginpage obj=new Loginpage(driver);
    	obj.typeusername(username);
    	
    	obj.typepassword(password);
    	
    	obj.clicklogin();
    	
    	Thread.sleep(5000);
    	
    	Addcustomer obj2=new Addcustomer(driver);
    	obj2.newcustomerlink();
    	obj2.typename("venkat");
    	obj2.gender();
    	obj2.typeaddress("Athota");
    	
	}
	

}

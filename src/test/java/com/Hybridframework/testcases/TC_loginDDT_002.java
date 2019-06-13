package com.Hybridframework.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.Hybridframework.pageobjects.Loginpage;

public class TC_loginDDT_002 extends Baseclass
{
	public ArrayList<String> readexcel(int colno) throws IOException
	{
		File f=new File(System.getProperty("user.dir")+"/src/test/java/com/Hybridframework/testdata/logintestdata.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		Iterator<Row> rowit=sheet.iterator();
		ArrayList<String> obj=new ArrayList<String>();
		while(rowit.hasNext())
		{
			obj.add(rowit.next().getCell(colno).getStringCellValue());
		}
		return obj;	
	}
	
	@Test
	public void application() throws IOException, InterruptedException
	{
		Loginpage obj=new Loginpage(driver);
		ArrayList<String> username=readexcel(0);
		ArrayList<String> password=readexcel(1);
		for(int i=0;i<username.size();i++)
		{
			obj.typeusername(username.get(i));
	    	
	    	obj.typepassword(password.get(i));
	    	
	    	obj.clicklogin();
	    	Thread.sleep(5000);
			
			
		}
    	
	}
	

}

package com.Hybridframework.utilites;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class Readconfig 
{
	Properties pro;
	public Readconfig() 
	{
		File src=new File("./configuration/config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
			}}
	public String getchromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getfirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String geturl()
	{
		String url=pro.getProperty("baseurl");
		return url;
	}
	public String getusername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	public String getpassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	

}

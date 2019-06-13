package com.Hybridframework.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement username;
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement login;
	
	public void typeusername(String userid)
	{
		username.sendKeys(userid);
	}
	public void typepassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clicklogin()
	{
		login.click();
	}

}

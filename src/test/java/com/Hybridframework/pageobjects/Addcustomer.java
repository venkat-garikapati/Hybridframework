package com.Hybridframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addcustomer 
{
	WebDriver driver;
	public Addcustomer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="New Customer")
	WebElement newcustomerbtn;
	@FindBy(name="name")
	WebElement namefield;
	@FindBy(name="rad1")
	WebElement genderbtn;
	@FindBy(name="addr")
	WebElement addressfield;
	
	public void newcustomerlink()
	{
		newcustomerbtn.click();
	}
	public void typename(String entername)
	{
		namefield.sendKeys(entername);
	}
	public void gender()
	{
		genderbtn.click();
	}
	public void typeaddress(String enteraddress)
	{
		addressfield.sendKeys(enteraddress);
	}
	

}

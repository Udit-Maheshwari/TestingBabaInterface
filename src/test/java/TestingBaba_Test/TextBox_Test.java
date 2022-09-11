package TestingBaba_Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestingBaba_Page.TextBox_Page;
import baseLibrary.BaseLibrary;

public class TextBox_Test extends BaseLibrary
{
	TextBox_Page ob;
	@BeforeTest
	public void launchTestingBaba()
	{
		getlaunch(getReaddata("url"));
		ob= new TextBox_Page();
	}
	
	@Test(priority=1)
	public void clickOnElement()
	{
		ob.clickOnElement();
	}
	
	@Test(priority=2)
	public void ClickOnTextbox()
	{
		ob.clickOnTextbox();
	}
	
	@Test(priority=3)
	public void fillDetails()
	{
		ob.fillDetails();
	}
}

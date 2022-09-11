package TestingBaba_Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestingBaba_Page.Link_Page;
import baseLibrary.BaseLibrary;

public class Link_Test extends BaseLibrary
{
	Link_Page ob;
	@BeforeTest
	public void getLaunchTestingBaba()
	{
		getlaunch(getReaddata("url"));
		ob= new Link_Page();
	}
	
	@Test(priority = 1)
	public void clickonElements()
	{
		ob.clickonElements();
	}
	
	@Test(priority = 2)
	public void clickonLinks()
	{
		ob.clickonLinks();
	}
	
	@Test(priority = 3)
	public void clickokDemopage()
	{
		ob.clickokDemopage();
	}
	

}

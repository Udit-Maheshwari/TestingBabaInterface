package TestingBaba_Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestingBaba_Page.Button_Page;
import baseLibrary.BaseLibrary;

public class Button_Test extends BaseLibrary
{
	Button_Page ob;
	@BeforeTest
	public void launchTestingBaba()
	{
		getlaunch(getReaddata("url"));
		ob= new Button_Page();
	}
	
	@Test(priority=1)
	public void clickonElement()
	{
		ob.clickonElement();
	}
	
	@Test(priority=2)
	public void clickonButton()
	{
		ob.clickonButton();
	}
	
	@Test(priority=3)
	public void clickonDoubleClick()
	{
		ob.clickonDoubleClick();
	}
	
	@Test(priority=4)
	public void clickonRightClick()
	{
		ob.clickonRightClick();
	}
}

package TestingBaba_Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestingBaba_Page.Upload_Page;
import baseLibrary.BaseLibrary;

public class Upload_Test extends BaseLibrary
{
	Upload_Page ob;
	@BeforeTest
	public void getlaunchTestingBaba()
	{
		getlaunch(getReaddata("url"));
		ob= new Upload_Page();
	}
	
	@Test(priority = 1)
	public void clickonElements()
	{
		ob.clickonElements();
	}
	
	@Test(priority = 2)
	public void clickonUpload()
	{
		ob.clickonUpload();
	}
	
	@Test(priority = 3)
	public void selectFile() throws InterruptedException
	{
		ob.selectFile();
	}
	
	

}

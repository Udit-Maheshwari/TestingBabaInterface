package TestingBaba_Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.BaseLibrary;

public class Link_Page extends BaseLibrary
{
	public Link_Page() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-target='#elements']")
	private WebElement Elements;
	
	@FindBy(xpath="//*[text()='links']")
	private WebElement links;
	
	@FindBy(xpath="//a[text()='Demo Page']")
	private WebElement demopage;

	
	public void clickonElements()
	{
		clickme(Elements);
	}
	
	public void clickonLinks()
	{
		clickme(links);
	}
	
	public void clickokDemopage()
	{
		clickme(demopage);
		windowhandle(1);
		String url=driver.getCurrentUrl();
		System.out.println("Url of new window is "+url);
		driver.close();
		windowhandle(0);
		String parenturl=driver.getCurrentUrl();
		System.out.println("Parent page url is "+parenturl);
	}
}

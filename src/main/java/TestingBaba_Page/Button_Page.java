package TestingBaba_Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LogUtility.Log4j;
import baseLibrary.BaseLibrary;

public class Button_Page extends BaseLibrary 
{
	public Button_Page() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-target='#elements']")
	private WebElement Elements;
	
	@FindBy(xpath="//a[text()='buttons']")
	private WebElement buttons;
	
	@FindBy(xpath="//button[@ondblclick='doubletext()']")
	private WebElement doubleclicks;
	
	@FindBy(xpath="//button[@oncontextmenu='righttext()']")
	private WebElement rightclick;
	
	
	public void clickonElement()
	{
		Log4j.logInfo("Click on Element");
		clickme(Elements);
	}
	
	public void clickonButton()
	{
		Log4j.logDebug("Click on Button");
		clickme(buttons);
	}
	
	public void clickonDoubleClick()
	{
		Log4j.logInfo("Click on Double click");
		doubleClick(doubleclicks);
	}
	
	public void clickonRightClick()
	{
		Log4j.logInfo("Click on Right Click");
		rightClick(rightclick);
	}

}

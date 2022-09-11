package TestingBaba_Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.BaseLibrary;

public class Upload_Page extends BaseLibrary
{
	public Upload_Page() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-target='#elements']")
	private WebElement Elements;
	
	@FindBy(xpath="//a[text()='upload and download']")
	private WebElement upload;
	
	@FindBy(xpath="//label[text()='Select a file']")
	private WebElement chhoseFile;
	
	public void clickonElements()
	{
		clickme(Elements);
	}
	
	public void clickonUpload()
	{
		clickme(upload);
	}
	
	public void selectFile() throws InterruptedException
	{
		clickme(chhoseFile);
		Thread.sleep(3000);
		fileUpload("C:\\Users\\Asus\\Desktop\\TestData_TextBox.xlsx");
	}

}

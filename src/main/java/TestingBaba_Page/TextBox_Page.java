package TestingBaba_Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.BaseLibrary;

public class TextBox_Page extends BaseLibrary
{
	String TestDataPath="C:\\Users\\Asus\\eclipse-workspace\\TestingBaba_Interface\\Test Data\\TestData_TextBox.xlsx";
	
	public TextBox_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-target='#elements']")
	private WebElement Elements;
	
	@FindBy(xpath= "//a[text()='text box']")
	private WebElement textbox;
	
	@FindBy(xpath="//input[@id='fullname1']")
	private WebElement name;
	
	@FindBy(xpath="//input[@id='fullemail1']")
	private WebElement email;
	
	@FindBy(xpath="//textarea[@id='fulladdresh1']")
	private WebElement Currentaddress;
	
	@FindBy(xpath="//textarea[@id='paddresh1']")
	private WebElement Permanentaddress;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submit;
	
	public void clickOnElement()
	{
		clickme(Elements);
	}
	
	public void clickOnTextbox()
	{
		clickme(textbox);
	}
	
	public void fillDetails()
	{
		name.sendKeys(getReaddata(TestDataPath, 0, 1, 1));
		email.sendKeys(getReaddata(TestDataPath, 0, 2, 1));
		Currentaddress.sendKeys(getReaddata(TestDataPath, 0, 3, 1));
		Permanentaddress.sendKeys(getReaddata(TestDataPath, 0, 4, 1));
		clickme(submit);
	}

}

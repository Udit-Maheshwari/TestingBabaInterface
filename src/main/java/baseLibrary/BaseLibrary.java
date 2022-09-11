package baseLibrary;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import ExcelUtility.ExcelUtility;
import applicationUtility.ApplicationUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

import propertyutility.PropertyUtility;
import screenshotutility.ScreenshotUtility;
import waitUtility.WaitUtility;

public class BaseLibrary implements PropertyUtility, WaitUtility, ApplicationUtility, ScreenshotUtility, ExcelUtility
{
	String ConfigPath="C:\\Users\\Asus\\eclipse-workspace\\TestingBaba_Interface\\config-properties\\config.properties";
	String TestDataPath="C:\\Users\\Asus\\eclipse-workspace\\TestingBaba_Interface\\Test Data\\TestData_TextBox.xlsx";
	public static WebDriver driver;
	
	public void getlaunch(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		implicitWait(10);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//*[text()='×']")).click();
		driver.findElement(By.xpath("//*[text()='Practice']")).click();
	}
	
	
	@AfterMethod
	public void getResultofScreenshot(ITestResult result)
	{
		String methodname=result.getMethod().getMethodName();
		methodname=methodname+dateTime();
		if(result.isSuccess())
		{
			getscreenshot("Passed", methodname);
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			getscreenshot("Failed", methodname);
		}
	}
	public String getReaddata(String key) 
	{
		String value="";
		try 
		{
			FileInputStream fls=new FileInputStream(ConfigPath);
			Properties prop=new Properties();
			prop.load(fls);
			value=prop.getProperty(key);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is :"+e);
		}
		return value;
	}

	public void implicitWait(int time) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
	}

	public void explitcitwait(WebElement element, int time) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

	public void clickme(WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void dropdown(WebElement element, String value) 
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(value);
	}

	public void getscreenshot(String foldername, String filename)
	{
		String location=System.getProperty("user.dir");
		try
		{
			String path=location+"\\Screenshot\\"+foldername+"\\"+filename+".png";
			TakesScreenshot scrshot= ((TakesScreenshot) driver);
			File source=scrshot.getScreenshotAs(OutputType.FILE);
			File Dest=new File(path);
			FileUtils.copyFile(source, Dest);
			
		} 
		catch (Exception e) 
		{
			System.out.println("Exception of screenshot is "+e);
			// TODO: handle exception
		}
	}

	public String dateTime()
	{
		String date="";
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy hh_mm_ss_a");
		Date db = new Date();
		date=sdf.format(db);
		return date;
	}


	public String getReaddata(String TestDataPath, int sheetno, int colno, int rowno) 
	{
		String value="";
		try 
		{
			FileInputStream fls = new FileInputStream(TestDataPath);
			XSSFWorkbook wb = new XSSFWorkbook(fls);
			XSSFSheet sheet= wb.getSheetAt(sheetno);
			value=sheet.getRow(rowno).getCell(colno).getStringCellValue();
			wb.close();
			
			
		} catch (Exception e) 
		{
			System.out.println("exception is "+e);
		}
		
		return value;
	}


	public void doubleClick(WebElement element) 
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
		
	}


	public void rightClick(WebElement element) 
	{
		Actions action= new Actions(driver);
		action.contextClick(element).perform();
		
	}


	public void windowhandle(int tabno) 
	{
		Set<String> handles=driver.getWindowHandles();
		ArrayList<String> list=new ArrayList<String>(handles);
		driver.switchTo().window(list.get(tabno));
	}


	public void fileUpload(String path) 
	{
		try {
			
			StringSelection ss= new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Robot rb= new Robot();
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.delay(1000);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is :"+e);
		}
		
	}
	}



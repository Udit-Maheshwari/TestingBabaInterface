package applicationUtility;

import org.openqa.selenium.WebElement;

public interface ApplicationUtility 
{
	public void dropdown(WebElement element, String value);
	
	public String dateTime();
	
	public void doubleClick(WebElement element);
	
	public void rightClick(WebElement element);
	
	public void windowhandle(int tabno);
	
	public void fileUpload(String path);


}

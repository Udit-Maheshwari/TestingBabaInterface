package waitUtility;

import org.openqa.selenium.WebElement;

public interface WaitUtility 
{
	public void implicitWait(int time);
	
	public void explitcitwait(WebElement element, int time);
	
	public void clickme(WebElement element);

}

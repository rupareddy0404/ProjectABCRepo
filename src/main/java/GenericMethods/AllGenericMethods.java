package GenericMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePoject1.BaseClass;

public class AllGenericMethods extends BaseClass
{
	//open url
	public static void openurl(String url)
	{
		driver.get(url);
	}
	
	//Application close browser
	public void closeBrowser() 
	{
	    if (driver != null) {
	        driver.close();
	    }
	}
	
	//Check box/radio button selected
	public void CheckboxSelected(By locator)
	{
		WebElement chkbx = driver.findElement(locator);
		if(!chkbx.isSelected()) 
		{
			chkbx.click();
		}
	}
	
	
	//ExplicitWait for element
	public WebElement Explicitwaitforelement(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//ImplicitWait
	public static void Implicitwait(int timeout)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}
	
	//Click Element
	public void Clickelement(By locator)
	{
		driver.findElement(locator).click();
	}
	
	//Send keys
	public static void SendKeysTo(By locator, String value)
	{
		driver.findElement(locator).sendKeys(value);
	}
	
	//getText()
	public String GetText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	//select drop down by text
	public void Dropdownbytext(By locator, String visibletext)
	{
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByVisibleText(visibletext);
	}
	
	//select drop down by value
	public void Dropdownbyvalue(By locator, String value)
	{
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByValue(value);
	}
	
	//Java script Scroll Up,Down,Left,Right
	public static void JavascripScrollUpDownLeftRight(int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)");
		//example js.executeScript("window.scrollBy(0,1000)");
		//example js.executeScript("window.scrollBy(0,-1000)");
	}
	
	//Java script Scroll Up,Down,Left,Right
	public static void JavascriptView(By locator)
	{
		WebElement link = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true);", link);
	}
	
	//Java script click()
	public static void JavascriptClick(By locator)
	{
		WebElement link = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",link);
	}
	
	//java script SendKeys()
	public static void JavascriptSendKeys(By locator, String text)
	{
		WebElement link = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].vale='"+text+ "';",link);
	}
	
	//Handle Alerts - Accept
	public static void AlertsAccept()
	{
		driver.switchTo().alert().accept();
	}
	//Handle Alerts - Accept
	public static void AlertsDismiss()
	{
		driver.switchTo().alert().dismiss();
	}
	
	//Switch to Frame By Index
	public static void SwitchtoFrameByIndex(int index)
	{
		driver.switchTo().frame(index);
	}
	
	//Switch to Frame By Name or Id
	public static void SwitchtoFrameBynameorId(String value)
	{
		driver.switchTo().frame(value);
	}
	
	//Switch to Frame By Name or Id
	public static void SwitchtoFrameBynameorId(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	//Switch to default frame
	public static void SwitchtoDefaultFrame()
	{
		driver.switchTo().defaultContent();
	}
	
	//Switch to Window Handle
	public static void SwitchToWindow(String WindowTitle)
	{
		String parentwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for(String currentwindow : allwindows)
		{
			if(!currentwindow.equals(parentwindow))
			{
				driver.switchTo().window(currentwindow);
			}
		}
	}
	
	//Verify Element is Displayed
	public boolean isElementDisplayed(By locator) 
	{
	    return driver.findElement(locator).isDisplayed();
	}
	
	//ScreenShot
	public static String TakeScreenCapture() throws IOException
	{
		TakesScreenshot scrshot = (TakesScreenshot) BaseClass.driver;
		File sourceFile = scrshot.getScreenshotAs(OutputType.FILE);
		File DestinationPath = new File("C://Screenshots//" + "ScreenCapture" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(sourceFile, DestinationPath);
		return DestinationPath.getAbsolutePath();
	}
	
	
}

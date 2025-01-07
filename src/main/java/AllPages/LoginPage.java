package AllPages;

import org.openqa.selenium.By;

import BasePoject1.BaseClass;
import GenericMethods.AllGenericMethods;

public class LoginPage extends BaseClass
{
	public static By Emailid = By.id("email");
	public static By Passwordid = By.id("pass");
	public static By Submit = By.name("login");
	
	public static void Enter_Email(String email)
	{
		driver.findElement(Emailid).sendKeys(email);	
	}
	public static void Enter_Password(String password)
	{
		driver.findElement(Passwordid).sendKeys(password);
	}
	public static void Click_Submit()
	{
		driver.findElement(Submit).click();
	}
}

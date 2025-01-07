package BasePoject1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	public static void Application_Launch()
	{
		browser_select();
		Env_select();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void Env_select()
	{
		String environment = "UAT";
		
		switch(environment)
		{
			case "QA":	System.out.println("QA environment");
						driver.get("https://www.fb.com");
						break;
			case "UAT": System.out.println("UAT environment");
						driver.get("https://www.fb.com");
						break;
			case "PreProd": System.out.println("PreProd environment");
							driver.get("https://www.fb.com");
							break;
			default: System.out.println("QA environment");
					driver.get("https://www.fb.com");
					break;
		}
	}
	public static void browser_select()
	{
		String browser = "Chrome";
		
		switch(browser)
		{
			case "Chrome" : WebDriverManager.chromedriver().setup();
							driver = new ChromeDriver();
							break;
			case "IE":		WebDriverManager.iedriver().setup();
							driver = new InternetExplorerDriver();
							break;
			case "Safari":	WebDriverManager.safaridriver().setup();
							driver = new SafariDriver();
							break;
			case "Edge":	WebDriverManager.edgedriver().setup();
							driver = new EdgeDriver();
							break;
			default :  		WebDriverManager.chromedriver().setup();
							driver = new ChromeDriver();
							break;
		}		
	}
		
	
	public static void Application_Close()
	{
		driver.close();
	}

}

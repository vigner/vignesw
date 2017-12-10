package wrappers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class BaseClass {

	public static WebDriver driver;	
		
	public void invokeBrowser(String browserName){
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "");
			driver = new ChromeDriver();
			
		}else if (browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
	}
	
	public boolean explicitWaitVisible(WebElement element) {
		boolean bReturn = false;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			
			
			bReturn = true;

		} catch (Exception e) {

			e.printStackTrace();
			

		}
		return bReturn;
	}
	
	public void fluentWaitSearchOfListOFElement(WebDriver driver, List<WebElement> element) throws InterruptedException {
		 
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(500,  TimeUnit.MILLISECONDS);
		wait.withTimeout(30, TimeUnit.SECONDS);
 
		Function<WebDriver, List<WebElement>> function = new Function<WebDriver, List<WebElement>>()
		{
			@Override
			public List<WebElement> apply(WebDriver arg0) {
				System.out.println("Checking for the list of WebElement!!");
				
				if(element.size()!=0)
				{
					System.out.println("Target List of WebElement is found");
					
				}
				return element;
			}
		};
 
		wait.until(function);
	}
	
	
	
}

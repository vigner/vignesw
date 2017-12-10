package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pageFactory.LoginPageFactory;
import utils.Reporter;
import wrappers.BaseClass;

public class LoginPageAction extends LoginPageFactory {
	
	public LoginPageAction(){
		PageFactory.initElements(driver, this);
	}
	
	
public LoginPageAction enterUserName(String value){
	
	try{
		submitButton.sendKeys(value);
		WebElement e = driver.findElement(By.id(""));
		explicitWaitVisible(e);
		e.sendKeys("sree");
		Reporter.reportStep("Username entered successfully","PAss");
	}catch(NoSuchElementException e){
		
		e.printStackTrace();
		Reporter.reportStep("Username not entered successfully","FAIL");
	}
	
	return this;
	
}

public HomePageAction clickOnsubmit(){
	
	try{
		driver.findElement(By.id("")).click();
	}catch(NoSuchElementException e){
		e.printStackTrace();
	}
	
	return new HomePageAction();
	
}

}

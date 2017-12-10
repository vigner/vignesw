package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import wrappers.BaseClass;

public class LoginPageFactory extends BaseClass{

	
	@FindBy(how=How.ID,using="submit")
	public WebElement submitButton;
}

package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.LoginPageAction;
import wrappers.ProjectSpecificWrapper;

public class LoginValidation extends ProjectSpecificWrapper {
	
	
	 @BeforeClass
	  public void beforeClass() {
		 browserName="chrome";
		 dataSheetName="TC001";
		 testCaseName="TC001";
		 testDescription="Test to verify the login validation";
	  }

	 @Test(dataProvider="sheet1")
	 public void validation(String uName){
		new LoginPageAction()
		.enterUserName(uName)
		 .clickOnsubmit()
		 .verifyHomePage();
		 
	 }
	

}

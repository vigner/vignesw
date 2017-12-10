package wrappers;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.Dataprovider;
import utils.Reporter;

public class ProjectSpecificWrapper extends BaseClass{

	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;
	protected String browserName;
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.startTestCase();
	  invokeBrowser(browserName);
  }

  @AfterMethod
  public void afterMethod() {
	
  }


  @DataProvider(name="sheet1")
  public Object[][] dp() throws InvalidFormatException, IOException {
	  
	  
    return Dataprovider.getExceldata(dataSheetName);
      
  }
 
  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  Reporter.startResult();
  }

  @AfterSuite
  public void afterSuite() {
	  Reporter.endResult();
  }

}

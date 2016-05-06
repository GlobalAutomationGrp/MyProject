package TestScripts;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


import PageObjects.*;
import WebObjectTypes.*;

public class TestCase1 {
	private WebDriver driver=null;
	 @BeforeTest
	 @Parameters("browser")
	  public void beforeTest(String browserType) {
		    driver=new GetDriver().returnDriver(browserType);
		
			driver.get("https://www.google.co.in");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	  }	

  @Test
  public void testSearchBtn() throws Exception {
	  
	  GoogleHomePage homepage=new GoogleHomePage(driver);
	  homepage.validateSrchBtn();		
		
  }
 

  @AfterTest
  public void afterTest() {
	  System.out.println("done");
	  driver.quit();
  }

}

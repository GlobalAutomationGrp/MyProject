package WebObjectTypes;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GetDriver {
	private WebDriver driver=null;
	private DesiredCapabilities dc=null;
	public WebDriver returnDriver(String BrowserType)
	{
		switch(BrowserType){
		case "InternetExplorer":System.setProperty("webdriver.ie.driver","D:/selenium/IEDriverServer_x64_2.45.0/IEDriverServer.exe"); 
								dc=DesiredCapabilities.internetExplorer();
								dc.setCapability("ignoreZoomSetting", true);
								dc.setCapability("ignoreProtectedModeSettings" , true);
								dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
						        //Delete Browser Cache since IE does not open a clean profile unlike Chrome & FireFox
						        try {
						        Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
						        } catch (IOException e) {
						        // TODO Auto-generated catch block
						        e.printStackTrace();
						        }
						      
								driver = new InternetExplorerDriver(dc);
								driver.manage().deleteAllCookies();
								driver.manage().window().maximize();
								break;
								
		case "Firefox":  FirefoxProfile profile = new FirefoxProfile();
		                 driver=new FirefoxDriver(new FirefoxBinary(new File("C:/Program Files (x86)/Mozilla Firefox/firefox.exe")), profile);
		                 break;
		                 
		case "Chrome":dc=DesiredCapabilities.chrome();
		              String[] switches={"--ignore-certificate-errors","--disable-popup-blocking","--disable-translate"};
		              dc.setCapability("chrome.switches",Arrays.asList(switches));
		              System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver_win32/chromedriver.exe");
		              driver = new ChromeDriver();
		
		}
		
		return driver;
	}
	
	

}

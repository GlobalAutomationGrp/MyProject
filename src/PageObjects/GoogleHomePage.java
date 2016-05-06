package PageObjects;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import WebObjectTypes.*;

public class GoogleHomePage {

	private WebDriver d=null;
	private String[] objectcoll;
	
	public GoogleHomePage(WebDriver driver) throws Exception 
	{
		this.d = driver;
		
		
			
			 String filepath=System.getProperty("user.dir")+"/OR_Objects/"+this.getClass().getSimpleName()+".txt";
			 List<String> list = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
			 objectcoll = list.toArray(new String[list.size()]); 
			 
			d.switchTo().defaultContent();
			Thread.sleep(5000);
		
				
	}
	public void validateSrchBtn() throws Exception
	{   
		
		WebButton google_srch=new WebButton("google_srch_btn",objectcoll,d);
		System.out.println("Button Validation Part1::"+google_srch.validateButtonVisible());
		System.out.println("Button Validation Part2::"+google_srch.validateButtonEnabled());
				
    					
	}
	
}

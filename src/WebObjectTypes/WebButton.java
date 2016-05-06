package WebObjectTypes;

import java.io.BufferedReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;

public class WebButton {
	private WebElement btn_obj=null;

	public WebButton(String objref,String[] br,WebDriver d) throws Exception
	{	
		this.btn_obj=new FetchObjectReference(d).getLocators(objref,br);
		System.out.println("Initiating web button object:"+this.btn_obj.toString());
		Reporter.log("Initiating web button object:"+this.btn_obj.toString());
	}
	
	public void clickButton()
	{
		if(this.validateButtonEnabled())
		{
		btn_obj.click();
		}
		else{
			System.out.println("button not enabled:"+btn_obj.toString());
			Reporter.log("button not enabled:"+btn_obj.toString());
		}
	}
	public boolean  validateButtonVisible()
	{	try{
		if (btn_obj.isDisplayed())
		{
		System.out.println("Button is visible:"+btn_obj.toString());
		Reporter.log("Button is visible:"+btn_obj.toString());
		return true;
		}
		else
		{
		System.out.println("Button is not visible:"+btn_obj.toString());
		Reporter.log("Button is not visible:"+btn_obj.toString());
		return false;
		}}catch(NoSuchElementException exception){
			System.out.println(exception.getMessage());
			Reporter.log(exception.getMessage());
			return false;
		}
	}
	public boolean  validateButtonEnabled()
	{
		try{
		if (btn_obj.isEnabled())
		{
		System.out.println("Button is enabled:"+btn_obj.toString());
		Reporter.log("Button is enabled:"+btn_obj.toString());
		return true;
		}
		else
		{
			System.out.println("Button is disabled:"+btn_obj.toString());
			Reporter.log("Button is disabled:"+btn_obj.toString());
		return false;
		}}catch(NoSuchElementException exception){
			System.out.println(exception.getMessage());
			Reporter.log(exception.getMessage());
			return false;
		}
	}
}

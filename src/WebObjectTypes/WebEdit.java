package WebObjectTypes;


import java.io.BufferedReader;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;


public class WebEdit
{
	private WebElement webedit_obj=null;

	public WebEdit(String objref,String[] a,WebDriver d) throws Exception
	{
		this.webedit_obj=new FetchObjectReference(d).getLocators(objref,a);
		System.out.println("Initiating web edit object:"+this.webedit_obj.toString());
		Reporter.log("Initiating web edit object:"+this.webedit_obj.toString());
			
	}

	public boolean  setText(String text_to_enter)
	{
	    this.clearText();	
		webedit_obj.sendKeys(text_to_enter);
		
		if (this.validateText(text_to_enter))
		{
		System.out.println(text_to_enter+" value entered in web edit object:"+webedit_obj.toString());
		Reporter.log(text_to_enter+" value entered in web edit object:"+webedit_obj.toString());
		return true;
		}
		else
		{
		System.out.println(text_to_enter+" value not entered in web edit object:"+webedit_obj.toString());
		Reporter.log(text_to_enter+" value not entered in web edit object:"+webedit_obj.toString());
		return false;
		}
	}

	public boolean  validateText(String text_to_validate)
	{	
		if (this.fetchTextValue().equalsIgnoreCase(text_to_validate))
		{
		System.out.println(text_to_validate+" value displayed in web edit object:"+webedit_obj.toString());
		Reporter.log(text_to_validate+" value displayed in web edit object:"+webedit_obj.toString());
		return true;
		}
		else
		{
		System.out.println(text_to_validate+" value not displayed in web edit object:"+webedit_obj.toString());
		Reporter.log(text_to_validate+" value not displayed in web edit object:"+webedit_obj.toString());
		return false;
		}
	}
	
	public String  fetchTextValue()
	{	
		try{
		String text_val= webedit_obj.getAttribute("value");
		System.out.println(" value displayed in web edit object:"+webedit_obj.toString()+" is "+text_val);
		Reporter.log(" value displayed in web edit object:"+webedit_obj.toString()+" is "+text_val);
		return text_val;}catch(NoSuchElementException exception){
			System.out.println(exception.getMessage());
			Reporter.log(exception.getMessage());
			return null;
		}
	}
	
	public boolean clearText()
	{
		try{
		webedit_obj.clear();
		if (webedit_obj.getAttribute("value").isEmpty())
		{
		System.out.println("web edit object:"+webedit_obj.toString()+" is empty ");
		Reporter.log("web edit object:"+webedit_obj.toString()+" is empty");
		return true;
		}
		else
		{
		System.out.println(" web edit object:"+webedit_obj.toString()+" is not empty");
		Reporter.log(" web edit object:"+webedit_obj.toString()+" is not empty ");
		return false;
		}}catch(NoSuchElementException exception){
			System.out.println(exception.getMessage());
			Reporter.log(exception.getMessage());
			return false;}
			
	}
}


	


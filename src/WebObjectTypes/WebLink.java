package WebObjectTypes;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class WebLink {
	
	private WebElement link_obj=null;

	public WebLink(String objref,String[] br,WebDriver d) throws Exception
	{	
		this.link_obj=new FetchObjectReference(d).getLocators(objref,br);
		System.out.println("Initiating web link object:"+this.link_obj.toString());
		Reporter.log("Initiating web link object:"+this.link_obj.toString());
	}
	
	public void clickLink()
	{
		if(this.validateLinkEnabled())
		{
			link_obj.click();
		}
		else{
			System.out.println("link not enabled:"+link_obj.toString());
			Reporter.log("link not enabled:"+link_obj.toString());
		}
	}
	public boolean  validateLinkVisible()
	{	try{
		if (link_obj.isDisplayed())
		{
		System.out.println("link is visible:"+link_obj.toString());
		Reporter.log("link is visible:"+link_obj.toString());
		return true;
		}
		else
		{
		System.out.println("link is not visible:"+link_obj.toString());
		Reporter.log("link is not visible:"+link_obj.toString());
		return false;
		}}catch(NoSuchElementException exception){
			System.out.println(exception.getMessage());
			Reporter.log(exception.getMessage());
			return false;
		}
	}
	public boolean  validateLinkEnabled()
	{
		try{
		if (link_obj.isEnabled())
		{
		System.out.println("link is enabled:"+link_obj.toString());
		Reporter.log("link is enabled:"+link_obj.toString());
		return true;
		}
		else
		{
			System.out.println("link is disabled:"+link_obj.toString());
			Reporter.log("link is disabled:"+link_obj.toString());
		return false;
		}}catch(NoSuchElementException exception){
			System.out.println(exception.getMessage());
			Reporter.log(exception.getMessage());
			return false;
		}
	}


}

package WebObjectTypes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class WebObject {
	private WebElement web_obj=null;
	public WebObject(String objref,String[] a,WebDriver d) throws Exception
	{
		this.web_obj=new FetchObjectReference(d).getLocators(objref,a);
		System.out.println("Initiating web general object:"+this.web_obj.toString());
		Reporter.log("Initiating web general object:"+this.web_obj.toString());
	}

	public void clickOnObject()
	{
		web_obj.click();
		System.out.println("clicked on web general object:"+web_obj.toString());
		Reporter.log("clicked on web general object:"+web_obj.toString());
	}
	
	public boolean objectVisible()
	{
		if(web_obj.isDisplayed())
		{
			System.out.println("visible web general object:"+web_obj.toString());
			Reporter.log("visible web general object:"+web_obj.toString());
			return true;
		}
		else
		{
			System.out.println("not visible web general object:"+web_obj.toString());
			Reporter.log("not visible web general object:"+web_obj.toString());
			return false;
		}
	}
}

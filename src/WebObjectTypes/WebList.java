package WebObjectTypes;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Reporter;

public class WebList {
	
	private WebElement weblist_obj=null;
	private Select sel=null;

	public WebList(String objref,String[] a,WebDriver d) throws Exception
	{
		this.weblist_obj=new FetchObjectReference(d).getLocators(objref,a);
		System.out.println("Initiating web list object:"+this.weblist_obj.toString());
		Reporter.log("Initiating web list object:"+this.weblist_obj.toString());
		sel = new Select(this.weblist_obj);
			
	}
	public String select(int index_num)
	{
		try{
		sel.selectByIndex(index_num);
		String selected_val=this.fetchSelectedValue();
		System.out.println("value selected in weblist:"+weblist_obj.toString()+" is "+selected_val);
		Reporter.log("value selected in weblist:"+weblist_obj.toString()+" is "+selected_val);
		return selected_val;
		}
		catch(NoSuchElementException exception){
			System.out.println(exception.getMessage());
			Reporter.log(exception.getMessage());
			return null;
			
			
		}
	}

	public boolean select(String option_val)
	{
		try{
		sel.selectByVisibleText(option_val);
		String selected_val=this.fetchSelectedValue();
		//System.out.println("value selected in weblist:"+weblist_obj.toString()+" is "+selected_val);
		if(this.validateSelectedValue(option_val))
		{
		System.out.println("successfully selected value "+option_val+" in weblist:"+weblist_obj.toString());
		Reporter.log("successfully selected value "+option_val+" in weblist:"+weblist_obj.toString());
		return true;
		}
		else
		{
		System.out.println("failed to select value "+option_val+" in weblist:"+weblist_obj.toString()+" instead selected "+selected_val);
		Reporter.log("failed to select value "+option_val+" in weblist:"+weblist_obj.toString()+" instead selected "+selected_val);
		return false;
		}}
		catch(NoSuchElementException exception){
			System.out.println(exception.getMessage());
			Reporter.log(exception.getMessage());
			return false;
		}
	}
	public String fetchSelectedValue()
	{
		try{
		return sel.getFirstSelectedOption().getText();
		}catch(NoSuchElementException exception){
			System.out.println(exception.getMessage());
			Reporter.log(exception.getMessage());
			return null;
		}
	}

	public boolean validateSelectedValue(String option_val)
	{
		String selected_val=this.fetchSelectedValue();
		if(selected_val.contentEquals(option_val))
		{
		System.out.println("value selected in weblist:"+weblist_obj.toString()+" is "+selected_val);
		Reporter.log("value selected in weblist:"+weblist_obj.toString()+" is "+selected_val);
		return true;
		}
		else
		{
		System.out.println("value selected in weblist:"+weblist_obj.toString()+" is "+selected_val+" instead of "+option_val);
		Reporter.log("value selected in weblist:"+weblist_obj.toString()+" is "+selected_val+" instead of "+option_val);
		return false;
		}
		
	}

}


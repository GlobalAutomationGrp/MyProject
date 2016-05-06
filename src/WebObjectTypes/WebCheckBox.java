package WebObjectTypes;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;




public class WebCheckBox {
	private WebElement chkbox_Obj=null;
	
	public WebCheckBox(String objref,String[] a,WebDriver d) throws Exception{
		this.chkbox_Obj=new FetchObjectReference(d).getLocators(objref,a);
		System.out.println("Initiating web button object:"+this.chkbox_Obj.toString());
		Reporter.log("Initiating web button object:"+this.chkbox_Obj.toString());
	
		}
	

	public boolean Set(String option_val)
	{
	  try{
	  if (option_val.equals("on") ||option_val.equals("ON") )
	  {		
			if (!(chkbox_Obj.isSelected()))
			{
				chkbox_Obj.click();
				System.out.println("setting check box object to:"+chkbox_Obj.toString());
				Reporter.log("setting check box object to:"+chkbox_Obj.toString());
				return true;
			}
			else
			{
				System.out.println("check box object already checked:"+chkbox_Obj.toString());
				Reporter.log("check box object already checked:"+chkbox_Obj.toString());
				return false;
			}
				
      }
	  else if (option_val.equals("off") ||option_val.equals("OFF") )
	  {		
			if ((chkbox_Obj.isSelected()))
			{
				chkbox_Obj.click();
				System.out.println("Unchecking the checkbox object:"+chkbox_Obj.toString());
				Reporter.log("Unchecking the checkbox object:"+chkbox_Obj.toString());
				return true;
			}
			else
			{
				System.out.println("checkbox object already unchecked:"+chkbox_Obj.toString());
				Reporter.log("checkbox object already unchecked:"+chkbox_Obj.toString());
				return false;
			}		
      }
	  else
	  {
		  System.out.println("Invalid input");
		  return false;
      }}catch(NoSuchElementException exception)
      {
    	  System.out.println(exception.getMessage());
			return false;
      }
	
	}

	public boolean  validateStatus(String status_to_validate)
	{	
		if (this.fetchStatusValue().equalsIgnoreCase(status_to_validate))
		{
		System.out.println(status_to_validate+" is the status value of web checkbox object:"+chkbox_Obj.toString());
		Reporter.log(status_to_validate+" is the status value of web checkbox object:"+chkbox_Obj.toString());
		return true;
		}
		else
		{
		System.out.println(status_to_validate+" is the status value of web checkbox object:"+chkbox_Obj.toString());
		Reporter.log(status_to_validate+" is the status value of web checkbox object:"+chkbox_Obj.toString());
		return false;
		}
	}
	
	public String  fetchStatusValue()
	{	
		try{
		String text_val= chkbox_Obj.getAttribute("value");
		System.out.println(" value of web checkbox object:"+chkbox_Obj.toString()+" is "+text_val);
		Reporter.log(" value of web checkbox object:"+chkbox_Obj.toString()+" is "+text_val);
		
		 if (text_val.equals("on") ||text_val.equals("ON") )
		 {
			 return "ON";
		 }
		 else if(text_val.equals("off") ||text_val.equals("OFF"))
		 {
			 return "OFF";
		 }
		 else{
			 System.out.println("Unidentified state");
			 Reporter.log("Unidentified state");
			 return text_val;
		 }
		}catch(NoSuchElementException exception){
			System.out.println(exception.getMessage());
			return null;
		}
	}
	
	public boolean fetchEnabledStatus()
	{
		if (chkbox_Obj.isEnabled())
		{
			System.out.println("check box object :"+chkbox_Obj.toString()+" is enabled");
			Reporter.log("check box object :"+chkbox_Obj.toString()+" is enabled");
			return true;
		}
		else
		{
			System.out.println("check box object:"+chkbox_Obj.toString()+" is disabled");
			Reporter.log("check box object:"+chkbox_Obj.toString()+" is disabled");
			return false;
		}
	}
	
	public boolean fetchVisibleStatus()
	{
		if (chkbox_Obj.isDisplayed())
		{
			System.out.println("check box object :"+chkbox_Obj.toString()+" is displayed");
			Reporter.log("check box object :"+chkbox_Obj.toString()+" is displayed");
			return true;
		}
		else
		{
			System.out.println("check box object:"+chkbox_Obj.toString()+" is not displayed");
			Reporter.log("check box object:"+chkbox_Obj.toString()+" is not displayed");
			return false;
		}
	}

	
}

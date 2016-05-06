package WebObjectTypes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class WebRadioGroup {
	private List<WebElement> webradiogrp_obj=null;
	@SuppressWarnings("unchecked")
	public WebRadioGroup(String objref,String[] a,WebDriver d) throws Exception{
		this.webradiogrp_obj=(List<WebElement>) new FetchObjectReference(d).getLocators(objref,a);
		System.out.println("Initiating web list object:"+webradiogrp_obj.toString());
		
		}
	
	
	
	public boolean selectByIndex(int index_num)
	{
		if (!(webradiogrp_obj.get(index_num-1).isSelected()))
		{
			webradiogrp_obj.get(index_num-1).click();
			return true;
		}
		else
		{
			System.out.println("object already checked");
			return false;
		}
		
		
	}

	


}

package WebObjectTypes;

import java.io.BufferedReader;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  class FetchObjectReference {
									private WebDriver d=null;
									String[] params=new String[3];
									
									public  FetchObjectReference(WebDriver driver) throws Exception
									{
								        d=driver;
									}
	
	public  WebElement getLocators(String objref,String[] br) throws Exception
	{
		String strLine;
		WebElement obj=null;
		

				//Read File Line By Line
		for (int i=0;i<br.length;i++)   {
								                        params=br[i].split("::");
								                        if(params[0].equalsIgnoreCase(objref))
								                        {   System.out.println("got object ref:"+objref);
								                        	switch (params[1]){
								                    		case "ID" 	:	obj =  d.findElements(By.id(params[2])).get(0);
								                    						break;
								                    		case "NAME" :	obj =  d.findElements(By.name(params[2])).get(0);
								                    			        	break;
								                    		case "XPATH":   obj =  d.findElements(By.xpath(params[2])).get(0);
								                    						break;
								                    		case "CLASS":   obj =  d.findElements(By.className(params[2])).get(0);
								                    						break;
								                    		case "LINKTEXT": obj = d.findElements(By.linkText(params[2])).get(0);
								                    		                break;
								                    		case "PARTIAL_LINKTEXT":obj = d.findElements(By.partialLinkText(params[2])).get(0);
								                        					break;
								                    		case "TAGNAME":obj = d.findElements(By.tagName(params[2])).get(0);
				                        									break;
								                    		case "CSS":obj = d.findElements(By.cssSelector(params[2])).get(0);
				                        									break;
								                        					}
								                    		
								                    	}			
								                        if(obj!=null)
								                        {
								                        	break;
								                        }
					                				}
		//Close the input stream
		
	  return obj;	
	  
	}

}

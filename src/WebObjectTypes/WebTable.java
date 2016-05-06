package WebObjectTypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class WebTable {
	
	private WebElement webTable_obj=null;
	
		public WebTable(String objref,String[] a,WebDriver d) throws Exception{
			
			this.webTable_obj=new FetchObjectReference(d).getLocators(objref,a);
			System.out.println("Initiating web table object:"+this.webTable_obj.toString());
			Reporter.log("Initiating web table object:"+this.webTable_obj.toString());
		
			}
		
		
		
		public int RowCount()
		{
			System.out.println("Row count of the table:"+webTable_obj.toString()+" is:"+webTable_obj.findElements(By.xpath("tbody/tr")).size());
			Reporter.log("Row count of the table:"+webTable_obj.toString()+" is:"+webTable_obj.findElements(By.xpath("tbody/tr")).size());
			return webTable_obj.findElements(By.xpath("tbody/tr")).size();
			
		}

		public int ColumnCount(int rownum)
		{
			return webTable_obj.findElements(By.xpath("tbody/tr["+Integer.toString(rownum)+"]/td")).size();
			
		}
		
		public String GetCellData(int rownum,int colnum)
		{
			return webTable_obj.findElement(By.xpath("tbody/tr["+Integer.toString(rownum)+"]/td["+Integer.toString(colnum)+"]")).getText();
			
		}
		
		public WebElement GetCellObject(int rownum,int colnum)
		{
			return webTable_obj.findElement(By.xpath("tbody/tr["+Integer.toString(rownum)+"]/td["+Integer.toString(colnum)+"]"));
			
		}

		public int GetRowWithCellText(String srchString)
		{
			String currString;
			int i=1,j=1,rownumber=0;
			int max_row=this.RowCount();
			int max_col=0;
			for (i=1;i<=max_row;i++)
			{
				max_col=this.ColumnCount(i);
				 for(j=1;j<=max_col;j++)
				 {
					 currString= this.GetCellData(i,j);
					 if (currString.equals(srchString))
					 {
						 rownumber=i;
						 break;
						 
						 
					 }
				 }
				 
			}
			return rownumber;
			//return Web.getObject(table_Name).findElements(By.xpath("tbody/tr")).size();
		}

		public int GetRowWithCellText(String srchString,int col_number)
		{
			String currString;
			int i=1,rownumber=0;
			int max_row=this.RowCount();
			
			for (i=1;i<=max_row;i++)
			{
				
				  currString= this.GetCellData(i,col_number);
					 if (currString.equals(srchString))
					 {
						 rownumber=i;
						 break;
						 
						 
					 }
				 
				 
			}
			return rownumber;
			//return Web.getObject(table_Name).findElements(By.xpath("tbody/tr")).size();
		}

		public int GetRowWithCellText(String srchString,int col_number,int start_row)
		{
			String currString;
			int i=start_row,rownumber=0;
			int max_row=this.RowCount();
			
			for (i=start_row;i<=max_row;i++)
			{
				
				  currString= this.GetCellData(i,col_number);
					 if (currString.equals(srchString))
					 {
						 rownumber=i;
						 break;
						 
						 
					 }
				 
				 
			}
			return rownumber;
			//return Web.getObject(table_Name).findElements(By.xpath("tbody/tr")).size();
		}

		public WebElement ChildItem(int rowNumber,int colNumber,String tagType,int indexNumber)
		{
			
			return webTable_obj.findElement(By.xpath("tbody/tr["+Integer.toString(rowNumber)+"]/td["+Integer.toString(colNumber)+"]"+"/"+tagType+"["+Integer.toString(indexNumber)+"]"));
			
		
		}






}

package WebObjectTypes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;















import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.gargoylesoftware.htmlunit.javascript.host.DocumentType;

public class XMLGenerator {
	
	public static void main(String[] args) throws Exception {
		File myFile = new File("D://ExcelToXML.xlsx");
        FileInputStream fis = new FileInputStream(myFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
       
        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        
        String xmlFilePath =System.getProperty("user.dir")+"\\testng.xml";
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("suite");
        Attr attr = document.createAttribute("name");
        String suitename="TestSuite";
        attr.setValue(suitename);
        root.setAttributeNode(attr);
        
        document.appendChild(root);

      
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();
        //to skip header row
        rowIterator.next();
        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
        
                Cell testName = cellIterator.next();
                Cell browserType=cellIterator.next();
                Cell className=cellIterator.next();
                Cell runFlag=cellIterator.next();
                
              //  System.out.println(testName.getStringCellValue()+"  "+browserType.getStringCellValue()+"  "+className.getStringCellValue()+"  "+runFlag.getStringCellValue());
                if(runFlag.getStringCellValue().trim().equals("Y"))
                {
                Element test = document.createElement("test");
                attr = document.createAttribute("name");
                attr.setValue(testName.getStringCellValue().trim());
                test.setAttributeNode(attr);
                
                root.appendChild(test);
                
                Element parameter=document.createElement("parameter");
                attr = document.createAttribute("name");
                attr.setValue("browser");
                parameter.setAttributeNode(attr);
                attr = document.createAttribute("value");
                attr.setValue(browserType.getStringCellValue().trim());
                parameter.setAttributeNode(attr);
                
                test.appendChild(parameter);
                
                Element classes=document.createElement("classes");
                Element testclass=document.createElement("class");
                attr = document.createAttribute("name");
                attr.setValue("TestScripts."+className.getStringCellValue().trim());
                testclass.setAttributeNode(attr);
                classes.appendChild(testclass);
                
                test.appendChild(classes);
                
                             
                }   
             }	
fis.close(); 

TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://testng.org/testng-1.0.dtd");
		
DOMSource domSource = new DOMSource(document);
		
StreamResult streamResult = new StreamResult(new File(xmlFilePath));

transformer.transform(domSource, streamResult);

	}

}

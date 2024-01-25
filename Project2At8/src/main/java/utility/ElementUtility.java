package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constant.Constant;





public class ElementUtility {
		WebDriver driver;
		public ElementUtility(WebDriver driver)
		{
			this.driver=driver;
		}
		
		
		
		
		public int getTableDataRowCount(List<WebElement> tableRowData ,String expectedValue)
		{
			int counter=0;
			for(int i=0;i<tableRowData.size();i++)
			{
				String value=tableRowData.get(i).getText();
				if(expectedValue.equalsIgnoreCase(value))
				{
					counter=i+1;
					break;
				}
			}
			return counter;
		}
		
		
		 public static String readPropertiesFile(String key) throws IOException {
		      FileInputStream fis = null;
		      Properties prop = null;
		     
		      
		     String fileName=Constant.propertiespath; //get file path
		      String value=null;
		      
		      try {
		         fis = new FileInputStream(fileName);    //open file
		         prop = new Properties();
		         prop.load(fis);  //load properties
		         value=prop.getProperty(key);   // get the value
		      } catch(FileNotFoundException fnfe) {
		         fnfe.printStackTrace();
		      } catch(IOException ioe) {
		         ioe.printStackTrace();
		      } finally {
		         fis.close();
		      }
		      return value;  

		}
		 
		 
		 public void scroll(WebElement element)
		 { 
			 
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			  
			 js.executeScript("arguments[0].scrollIntoView()",element);
		 }
		 
		 
		 


		 
		 public void estimatedate(WebElement element,String dateValue) {

				JavascriptExecutor js=(JavascriptExecutor)driver;

				js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');", element);

			}
		 
		 
		 
}

package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementUtility;
import utility.WaitUtility;

public class NotePage {
	WebDriver driver;
	WaitUtility waitutil;
	ElementUtility elementutil;
	
	//@FindBy(locator="value")
	//WebElement elementname;
	
	@FindBy(xpath="//span[text()='Notes']")
		WebElement notes;
	
	@FindBy(xpath="//a[text()=' Add note']")
	WebElement addnote;
	
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement titlefield;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement descriptionfield;

	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement close;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement closedelete;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchnote;
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[2]//a")
	WebElement searchtitle;
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[4]//a[1]")
	WebElement edit;
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[4]//a[2]")
	WebElement delete;
	
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement deletebtn;
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[1]")
	WebElement nodata;
	
	
	
	
	
	public NotePage(WebDriver driver)
	{
		this.driver=driver;
		waitutil=new WaitUtility(driver);
		elementutil=new ElementUtility(driver);
		PageFactory.initElements(driver,this );
		//initiaze webelements declared using @FindBY
		
	}

	

	
	public String doNote(String title,String description,String search)
	{
	
		notes.click();
	    
	    addnote.click();
	   
	    titlefield.sendKeys(title);
	    
	    descriptionfield.sendKeys(description);
	    
	    save.click();
	    
	    close.click();
	    
	    notes.click();
	    
	    searchnote.sendKeys(search);
	    
	 
	   String actual=searchtitle.getText();
	   return actual;	    

   }
	
	
	
	public String searchnote(String search) 
	{    
		//clickNote();
		waitutil.WaitVisibility(searchnote);
		searchnote.sendKeys(search);
		By locator=By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+search+"')]");
		waitutil.WaitVisibility(locator);
		List<WebElement> notetable=driver.findElements(By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+search+"')]"));
		waitutil.WaitVisibility(notetable);
	int row=elementutil.getTableDataRowCount(notetable, search);
		String message="";
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='note-table']//tbody//tr["+row+"]//td[2]"));
			message=tableRow.getText();
			System.out.println(message);
			
		}
		
		
		return message;
		  
	}
		
		

	
	public String doupdate(String search,String updatedtitle)
	{
		   notes.click();
		   searchnote.sendKeys(search);
		   edit.click();
		   titlefield.clear();
		   titlefield.sendKeys(updatedtitle);
		   save.click();
		   close.click();
		   notes.click();
		   searchnote.sendKeys(updatedtitle);
		    
		  
		   String actual=searchtitle.getText();
		   return actual;
		    
		
	}
	
	public String dodelete(String search)
	{
		   notes.click();
	       searchnote.sendKeys(search);
		   delete.click();
		   deletebtn.click();
		   waitutil.WaitClickable(closedelete);
		   
		   closedelete.click();
		   notes.click();
		   searchnote.sendKeys(search);
		   String actual=nodata.getText();
		   return actual;
		
	}
	
	
	
	public void clickNote()
	{
		notes.click();
	}
	
	
}
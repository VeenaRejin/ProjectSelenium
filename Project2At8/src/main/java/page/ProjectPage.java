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

public class ProjectPage {

	WebDriver driver;
	WaitUtility waitutil;
	ElementUtility elementutil;
	
	@FindBy(xpath="//span[text()='Projects']")
	WebElement projects;
	
	@FindBy(xpath="//span[text()='All Projects']")
	WebElement allprojects;
	
	@FindBy(xpath="//a[text()=' Add project']")
	WebElement addproject;
	
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement titlefield;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement descriptionfield;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement close;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchproject;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[2]//a")
	WebElement tablesearch;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[9]//a[1]")
	WebElement edit;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[9]//a[2]")
	WebElement delete;
	
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement deletebtn;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[2]//a")
	WebElement searchtitle;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[1]")
	WebElement nodata;
	
	
	public ProjectPage(WebDriver driver)
	{
		this.driver=driver;
		waitutil=new WaitUtility(driver);
		elementutil=new ElementUtility(driver);
		PageFactory.initElements(driver,this );
		//initiaze webelements declared using @FindBY
		
	}
	
	public String doProject(String title,String description,String search)
	{
	
    
	projects.click();
    
    allprojects.click();
    
    addproject.click();
    
    titlefield.sendKeys(title);
    
    descriptionfield.sendKeys(description);
    
    save.click();
   
    close.click();
    
    projects.click();
    
    allprojects.click();
    
    searchproject.sendKeys(search);
   
    
   
    String actual=tablesearch.getText();
    return actual;   
   
}
	
	
	
	
	public String doupdate(String search,String updatedtitle)
	{
		   projects.click();
		   allprojects.click();
		   waitutil.WaitVisibility(searchproject);
		   searchproject.sendKeys(search);
		   edit.click();
		   titlefield.clear();
		   titlefield.sendKeys(updatedtitle);
		   save.click();
		   close.click();
		   clickProject();
		   allprojects.click();
		   waitutil.WaitVisibility(searchproject);
		  
		   searchproject.sendKeys(updatedtitle);
		    
		    
		 
		   String actual=searchtitle.getText();
		   return actual;
		    
		
	}
	
	
	
	
	

	public String dodelete(String search)
	{
		   projects.click();
		   allprojects.click();
		   searchproject.sendKeys(search);
		   delete.click();
		   deletebtn.click();
		   
		   waitutil.WaitClickable(close);
		   
		   close.click();
		   
		   projects.click();
		   
		   allprojects.click();
		   waitutil.WaitVisibility(searchproject);
		  
		   searchproject.sendKeys(search);
		   String actual=nodata.getText();
		   return actual;
		    
		
	}
	
	
	public String searchprjct(String search) 
	{   
		//clickProject();
		
		waitutil.WaitVisibility(searchproject);
		searchproject.sendKeys(search);
		By locator=By.xpath("//table[@id='project-table']//tbody//tr//td//a[contains(text(),'"+search+"')]");
		waitutil.WaitVisibility(locator);
		List<WebElement> projecttable=driver.findElements(By.xpath("//table[@id='project-table']//tbody//tr//td//a[contains(text(),'"+search+"')]"));
		waitutil.WaitVisibility(projecttable);
	int row=elementutil.getTableDataRowCount(projecttable, search);
		String message="";
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='project-table']//tbody//tr["+row+"]//td[2]"));
			message=tableRow.getText();
			System.out.println(message);
			
		}
		return message;
		  
	}
	
	
	
	
	public void clickProject()
	{
		projects.click();
		allprojects.click();
		
	}
	
	
}

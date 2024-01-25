package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class EstimatePage {
	WebDriver driver;
	WaitUtility waitutil;
	ElementUtility elementutil;
	
	
	
	@FindBy(xpath="//span[text()='Estimates']")
	WebElement estimate;
	
	@FindBy(xpath="//span[text()='Estimate List']")
	WebElement estimatelist;
	
	@FindBy(xpath="//a[@title='Add estimate']")
	WebElement addestimate;

	@FindBy(xpath="//input[@placeholder='Estimate date']")
	WebElement estimatedate;
	
	@FindBy(xpath="//input[@placeholder='Valid until']")
	WebElement validuntil;
	
	
	
	
	@FindBy(id="s2id_estimate_client_id")
	private WebElement clientDropdown;
	
	@FindBy(xpath="//input[@id='s2id_autogen9_search']")
	private WebElement clientSearch;
	
	@FindBy(xpath="//ul[@class='select2-results']//li[1]//div//span")
	private WebElement clientOption;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement button_submit;
	
	@FindBy(xpath="//button[@class='close']")
	private WebElement button_close;
	
	
	
	
	@FindBy(xpath="//a[text()='Obsquara']")
	 WebElement client;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchestimate;
	
	@FindBy(xpath="//table[@id='monthly-estimate-table']//tbody//tr[1]//td[6]//a[1]")
	WebElement edit;
	
	@FindBy(xpath="//table[@id='monthly-estimate-table']//tbody//tr[1]//td[2]//a")
	WebElement clientTable;
	



public EstimatePage(WebDriver driver)
{
	this.driver=driver;
	waitutil=new WaitUtility(driver);
	elementutil=new ElementUtility(driver);
	PageFactory.initElements(driver,this );
	//initiaze webelements declared using @FindBY
	
}


public String doEstimate(String dateestimate,String datevalid,String SearchClient)
{
	waitutil.WaitClickable(estimate);
	estimate.click();
	waitutil.WaitClickable(estimatelist);
	estimatelist.click();
	waitutil.WaitClickable(addestimate);
	addestimate.click();
	
	elementutil.estimatedate(estimatedate,dateestimate);
	elementutil.estimatedate(validuntil,datevalid);
	waitutil.WaitClickable(clientDropdown);
	clientDropdown.click();
	waitutil.WaitVisibility(clientSearch);
	clientSearch.sendKeys(SearchClient);
	clientOption.click();
	waitutil.WaitClickable(button_submit);
	button_submit.click();
	waitutil.WaitClickable(button_close);
	button_close.click();
	
	String actual=client.getText();
	return actual;
	
}





public String searchestimate(String search) 
{    
	//clickNote();
	waitutil.WaitVisibility(searchestimate);
	searchestimate.sendKeys(search);
	By locator=By.xpath("//table[@id='monthly-estimate-table']//tbody//tr//td//a[contains(text(),'"+search+"')]");
	waitutil.WaitVisibility(locator);
	List<WebElement> estimatetable=driver.findElements(By.xpath("//table[@id='monthly-estimate-table']//tbody//tr//td//a[contains(text(),'"+search+"')]"));
	waitutil.WaitVisibility(estimatetable);
int row=elementutil.getTableDataRowCount(estimatetable, search);
	String message="";
	if(row!=0) 
	{
		WebElement tableRow=driver.findElement(By.xpath("//table[@id='monthly-estimate-table']//tbody//tr["+row+"]//td[2]"));
		message=tableRow.getText();
		System.out.println(message);
		
	}
	
	return message;
	  
}


/*


public String doupdate(String search,String SearchClient,String updatedclient)
{
	   estimate.click();
	   estimatelist.click();
	   searchestimate.sendKeys(search);
	   edit.click();
	   clientTable.clear();
	   clientDropdown.click();
	   clientSearch.sendKeys(SearchClient);
	   clientOption.click();
	   
	
	    	
}

*/




public void clickEstimate()
{
	//waitutil.WaitClickable(estimate);
	estimate.click();
	//waitutil.WaitClickable(estimatelist);
	estimatelist.click();
}
	

}

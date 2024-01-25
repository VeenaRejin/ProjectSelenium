package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement emailField;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwordField;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary btn-block mt15']")
	WebElement button;
	
	@FindBy(xpath="//span[text()='Notes']")
	WebElement note;
	
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this );
		//initiaze webelements declared using @FindBY
		
	}
	
	public String doLogin(String email,String password)
	{
	
		
		
    emailField.sendKeys(email);
    
    passwordField.sendKeys(password);
   
    button.click();
   
    
    
    String actual=note.getText();
   
   return actual;
    

}
}
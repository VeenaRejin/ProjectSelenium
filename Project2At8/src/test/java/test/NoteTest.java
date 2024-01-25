package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import page.NotePage;



public class NoteTest extends BaseTest{
  @Test(priority=1,groups= {"smoke","regression"})
  public void verifyNote() {
	 
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  
	  NotePage np=new NotePage(driver);
	
	  
	  String actual=np.doNote("Automation Testing","Aaaaaa","Automation Testing");
	  String expected="Automation Testing";
	  Assert.assertEquals(actual, expected);
	 
  }
  
  
  
  @Test(priority=2,groups= {"smoke","regression"})
  public void search() {
	 
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  
	  NotePage np=new NotePage(driver);
	
	 np.clickNote();
	  String actual=np.searchnote("Automation Testing");
	  String expected="Automation Testing";
	  Assert.assertEquals(actual, expected);
	 
  }
  
  
  
  
  @Test(priority=3,groups= {"smoke","regression"},retryAnalyzer=generaltests.Retry.class)
  public void updateNote() {
		 
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  
	  
	  NotePage np=new NotePage(driver);
	
	  String actual=np.doupdate("Automation Testing","Manual Testing_veena");
	  String expected="Manual Testing_veena";
	  Assert.assertEquals(actual, expected);
  
}
  
  @Test(priority=4,groups= {"regression"})
  public void deleteNote() {
		 
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  
	  
	  NotePage np=new NotePage(driver);
	  String actual=np.dodelete("Manual Testing_veena");
	  String expected="No record found.";
	
	  Assert.assertEquals(actual, expected);
  
}
}

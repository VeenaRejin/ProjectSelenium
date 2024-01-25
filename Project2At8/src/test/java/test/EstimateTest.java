package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.EstimatePage;
import page.LoginPage;

public class EstimateTest extends BaseTest {
  @Test(priority=1)
  public void verifyEstimate() {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  EstimatePage ep=new EstimatePage(driver);
	  
	  
	  String actual=ep.doEstimate("2024-01-22","2024-02-22","Obsquara");
	  String expected="Obsquara";
	  Assert.assertEquals(actual, expected); 
	  
  }
  
  @Test(priority=2)
  public void searchEstimate() {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  EstimatePage ep=new EstimatePage(driver);
	  
	  ep.clickEstimate();
	  String actual=ep.searchestimate("Obsquara");
	  String expected="Obsquara";
	  Assert.assertEquals(actual, expected); 
	  
  }
  
}

package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;

import page.ProjectPage;

public class ProjectTest extends BaseTest {
  @Test(priority=1,groups= {"smoke","regression"})
  public void verifyProject() {
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  
	  ProjectPage pp=new ProjectPage(driver);
	
	  
	  String actual=pp.doProject("Qalegend","Aaaaa","Qalegend");
	  String expected="Qalegend";
	  Assert.assertEquals(actual, expected);
	  
  }
  
  
  
  @Test(priority=2,groups= {"smoke","regression"})
  public void search() {
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  
	  ProjectPage pp=new ProjectPage(driver);
	
	 pp.clickProject();
	 
	  String actual=pp.searchprjct("Qalegend");
	  String expected="Qalegend";
	  Assert.assertEquals(actual, expected);
	  
  }
  
  
  
  @Test(priority=3,groups= {"smoke","regression"})
  public void updateProject() {
		 
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  
	  
	  ProjectPage pp=new ProjectPage(driver);
	
	  String actual=pp.doupdate("Qalegend","QA_veena");
	  String expected="QA_veena";
	  Assert.assertEquals(actual, expected);
  
}
  
  @Test(priority=4,groups= {"regression"})
  public void deleteProject() {
		 
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  
	  
	  ProjectPage pp=new ProjectPage(driver);
	  String actual=pp.dodelete("QA_veena");
	  String expected="No record found.";
	
	  Assert.assertEquals(actual, expected);
  
}
  
}

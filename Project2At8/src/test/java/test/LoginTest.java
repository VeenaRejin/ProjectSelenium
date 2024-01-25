package test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import constant.Constant;
import page.LoginPage;
import utility.ExcelRead;


public class LoginTest extends BaseTest {
	  @Test(dataProvider = "dp")

  public void login(String username,String password) {
	  LoginPage lp=new LoginPage(driver);
	 // lp.doLogin();
	  String actual=lp.doLogin(username,password);
	  String expected="Notes";
	  Assert.assertEquals(actual, expected);
	  
  }
	  
	 @DataProvider
	  public Object[][] dp() throws InvalidFormatException, IOException {
		 Object [][] data= ExcelRead.getDataFromExcel(Constant.excelpath, 
					"Sheet1");
		 return data;
	  }	  
	  
}

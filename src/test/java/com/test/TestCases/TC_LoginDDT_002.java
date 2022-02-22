package com.test.TestCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.PageObjects.LoginPage;
import com.test.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider = "LoginData")
	public void LoginDDT(String user,String password) throws Exception {
		LoginPage loginPageObjects=new LoginPage(driver);
		loginPageObjects.setUserName(user);
		loginPageObjects.setPassword(password);
		loginPageObjects.clickSubmit();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			System.out.println("fail");
			logger.warn("Login Failed.Incorrect user");
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			System.out.println("success");
			logger.info("Logged in with correct user");
			System.out.println("success1");
			Thread.sleep(1000);
			loginPageObjects.LogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
		}
		
	}
	public Boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch (NoAlertPresentException e) {
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception {
		String path="C:\\Users\\Hinduja_L\\eclipse-workspace\\E_Banking_V1\\src\\test\\java\\com\\test\\TestData\\LoginData.xlsx";
		int r=XLUtils.getRowCount(path,"Sheet1");
		int c=XLUtils.getCellCount(path,"Sheet1",r);
		String data[][]=new String[r][c];
		for(int i=1;i<=r;i++) {
			for(int j=0;j<c;j++) {
				data[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
			}
		}
		return data;		
	}
}

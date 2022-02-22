package com.test.TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() {
		driver.get(baseURL);
		LoginPage loginPageObjects=new LoginPage(driver);
		loginPageObjects.setUserName(userName);
		loginPageObjects.setPassword(password);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPageObjects.clickSubmit();
		logger.info("Logged in Successfully");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true, "Title matches");
		}
		else {
			Assert.assertTrue(false,"Title doesn't match");
		}
		
	}
}

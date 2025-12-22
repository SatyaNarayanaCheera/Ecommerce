package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;


@Listeners(listeners.ExtentTestListener.class)
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	//HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		System.out.println("feature/cart-test... ----------> Updated to cart1....");
		String title = loginPage.validateLoginPageTitle();
		System.out.println("git commit changes...." +title);
		Assert.assertEquals(title, "#1 Free CRM Business Software - Free Forever");
	}
	@Test(priority = 2)
	public void testfailcheck() {
	//	loginPage.login(null, null)
		String title = loginPage.validateLoginPageTitle();
		Assert.assertTrue(false);
	}
	
	/*
	 * @Test(priority=2) public void crmLogoImageTest(){ boolean flag =
	 * loginPage.validateCRMImage(); Assert.assertTrue(flag); }
	 * 
	 * @Test(priority=3) public void loginTest(){ homePage =
	 * loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 * }
	 */
	
	
	
	@AfterMethod
	public void tearDown(){
		getdriver().quit();
	}
	
	
	
	

}

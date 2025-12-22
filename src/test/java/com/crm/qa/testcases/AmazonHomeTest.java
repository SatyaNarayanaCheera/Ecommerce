package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AmazonHome;
import com.crm.qa.pages.LoginPage;

public class AmazonHomeTest extends TestBase{
	AmazonHome loginPage;
	//HomePage homePage;
	
	public AmazonHomeTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new AmazonHome();	
		
	}
	
	@Test (priority = 1)
	public void Menuselect() throws InterruptedException {

		loginPage.clickonMenu();
		
	}
	
	@Test(priority = 2)
	public void Display() {
		Assert.assertEquals(true, false);
	}
	
	
	
	

}

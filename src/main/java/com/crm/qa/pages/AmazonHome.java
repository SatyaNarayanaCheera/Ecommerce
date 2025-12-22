package com.crm.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;



public class AmazonHome extends TestBase{
	
	@FindBy(css="div#nav-main a#nav-hamburger-menu span")
	WebElement menuicon;
	
	// button.a-button-text
	@FindBy(css="button.a-button-text")
	WebElement continue_shop;
	
	
			@FindBy(xpath="(//div//ul//li//a[text()=\"Sign in\"])[1]")
			WebElement sign_in;
	
	public AmazonHome() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void clickonMenu() throws InterruptedException {
		//continue_shop.click();

try {
    continue_shop.click();
} catch (NoSuchElementException e) {
    // Element not found, ignore and continue
}
		Thread.sleep(3000);
		menuicon.click();
		Thread.sleep(3000);
		sign_in.click();
		
		
	}
	
	
	public void doLogin(String uname, String pwd) {
		
		
	}

}

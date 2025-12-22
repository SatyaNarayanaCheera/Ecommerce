package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AmazonLogin {
	
	public AmazonLogin() {
		PageFactory.initElements(TestBase.getdriver(), this);
	}

}

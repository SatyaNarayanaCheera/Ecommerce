package com.crm.qa.util;

import org.openqa.selenium.support.events.WebDriverListener;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebEventListener implements WebDriverListener {

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Before clicking: " + element);
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("After clicking: " + element);
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("Navigating to: " + url);
    }
    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
    try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    
}


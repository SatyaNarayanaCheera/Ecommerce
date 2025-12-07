package com.crm.qa.testcases;
import java.net.HttpURLConnection;
	import java.net.URL;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class BrokenLinks {

	    public static void main(String[] args) {
	    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");	
	        WebDriver driver = new ChromeDriver();
			

	        driver.get("https://www.amazon.com/");

	        List<WebElement> links = driver.findElements(By.tagName("a"));

	        System.out.println("Total links: " + links.size());

	        for (WebElement element : links) {

	            String url = element.getAttribute("href");

	            if (url == null || url.isEmpty()) {
	                System.out.println("Skipped (no href): " + element.getText());
	                continue;
	            }

	            try {
	                HttpURLConnection conn = (HttpURLConnection) (new URL(url).openConnection());
	                conn.setRequestMethod("HEAD");   // faster than GET
	                conn.setConnectTimeout(5000);
	                conn.connect();

	                int status = conn.getResponseCode();

	                if (status >= 400) {
	                    System.out.println("❌ BROKEN: " + url + " → " + status);
	                } else {
	                    System.out.println("✔ Valid: " + url + " → " + status);
	                }

	            } catch (Exception e) {
	                System.out.println("❌ BROKEN (Exception): " + url);
	            }
	        }

	        driver.quit();
	    }
	}



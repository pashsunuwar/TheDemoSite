package com.qa.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TheDemoSiteLogin {
	
	private WebDriver driver;
	private WebElement target;
	
	@Before
	public void setupBefore() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\Pash\\Documents\\TheDemoSite\\src\\main\\resources\\WebDriver/chromedriver.exe"
				);
		driver = new ChromeDriver();
	}
	
	@Test
	public void testing() throws InterruptedException {
		driver.get("http://thedemosite.co.uk/");
		
		//create username & password
		driver.get("http://thedemosite.co.uk/addauser.php");
		target = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		target.sendKeys("testing123");
		target = driver.findElement(By.name("password"));
		target.sendKeys("123password");
		target.submit();
		
		//login
		target = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		target.click();
		target = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		target.sendKeys("testing123");
		target = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		target.sendKeys("123password");
		target = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		target.click();
		
		target = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		
		assertEquals("**Successful Login**", target.getText());
		
		Thread.sleep(7000);	
	}
	
	@After
	public void after() {
		driver.close();
	}
}

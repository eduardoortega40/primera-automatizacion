package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromeDriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:www.google.com/");
		
	
	}
	@Test
	public void testGooglePage() {
	WebElement searchbox=driver.findElement(By.name("q"));
	searchbox.clear();
	searchbox.sendKeys("introduccion a la automatizacion");
	searchbox.submit();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		assertEquals("introduccion a la automatizacion-google search",driver.getTitle());
		
}
	@After
	public void tearDown() {
		driver.quit();
		
		
		
	}
}

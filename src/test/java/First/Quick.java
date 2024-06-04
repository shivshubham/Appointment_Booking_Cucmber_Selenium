package First;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JList;

import org.junit.Before;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Quick {
	WebDriver driver=new EdgeDriver();
	@Test(priority=1)
	 void before() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shubh\\eclipse-workspace\\Thursday\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shubh\\eclipse-workspace\\Thursday\\msedgedriver.exe");
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.findElement(By.id("btn-make-appointment")).click();
		WebElement username=driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[2]/form/div[1]/div[1]/div/div/input"));
		String usernameValue=username.getText();
		WebElement password=driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[2]/form/div[1]/div[2]/div/div/input"));
		String passwordValue=password.getText();
		driver.findElement(By.id("txt-username")).sendKeys(usernameValue);
		driver.findElement(By.id("txt-password")).sendKeys(passwordValue);
		driver.findElement(By.id("btn-login")).click();
		driver.close();
		
		
	}
	
	@Test(priority=2,enabled = false)
	void createAccount() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.partialLinkText("Create an Account"));
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.partialLinkText("Create an Account")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("firstname")).sendKeys("Shubham0007");
		driver.findElement(By.id("lastname")).sendKeys("Carter");
		driver.findElement(By.id("email_address")).sendKeys("shivshubham801@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Shubhu861#@");
		driver.findElement(By.id("password-confirmation")).sendKeys("Shubhu861#@");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();
		WebElement w=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
		//Assert.assertEquals("Thank you for registering with Main Website Store.",w.getText());
		//System.out.println(d);
		
		System.out.println(w.getText());
		driver.close();
	}
	@Test(priority=1,enabled = false)
	void Dynamic_webtables() {
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		int table1 = driver.findElement(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table")).getSize();
		int Nrows=table1.
		System.out.print("No of rows"+Nrows);
		driver.close();
		
	}
	
	

}

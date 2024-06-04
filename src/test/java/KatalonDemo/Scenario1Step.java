package KatalonDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Scenario1Step {
	
	WebDriver driver;
	@Given("User Launches the browser\\/site")
	public void user_launches_the_browser_site() {
	    // Write code here that turns the phrase above into concrete actions
		driver=new EdgeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shubh\\eclipse-workspace\\Thursday\\msedgedriver.exe");
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.findElement(By.id("btn-make-appointment")).click();
		//WebElement username=driver.findElement(By.className("form-control"));
		//String usernameValue=username.getText();
		//System.out.print(usernameValue);
		//WebElement password=driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[2]/form/div[1]/div[2]/div/div/input"));
		//String passwordValue=password.getText();
		//System.out.print(passwordValue);
		driver.findElement(By.id("txt-username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();
		
		
		
	}

	@When("Useing Tokio and Medicare Facility")
	public void useing_tokio_and_medicare_facility() {
		WebElement facility=driver.findElement(By.id("combo_facility"));
		Select opt=new Select(facility);
		opt.selectByVisibleText("Tokyo CURA Healthcare Center");
		driver.findElement(By.id("radio_program_medicare")).click();
		driver.findElement(By.id("txt_visit_date")).click();
		// Locate the date input field and click it to open the date picker
        WebElement dateInputField = driver.findElement(By.id("txt_visit_date"));
        dateInputField.click();

        // Locate and select the desired date in the date picker
        WebElement desiredDate = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[3]/td[5]"));
        desiredDate.click();
        driver.findElement(By.id("txt_comment")).sendKeys("Shubham");
        driver.findElement(By.id("btn-book-appointment")).click();
	}

	@Then("Appointment booking Done")
	public void appointment_booking_done() {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Specify the location to save the screenshot
        String screenshotLocation = "C://Users//shubh//eclipse-workspace//Thursday//Screenshots//Screenshotsscreenshot.png";

        // Copy the screenshot to the specified location
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotLocation));
            System.out.println("Screenshot saved to: " + screenshotLocation);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
	    // Write code here that turns the phrase above into concrete actions
        System.out.print("Success");
		driver.close();
	}


}

package ProveSeleniumWebdriver;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestSeleniumUpload {
	
	 private WebDriver driver;
	 
	 @BeforeSuite
	 public void initDriver() throws Exception {
	     System.out.println("You are testing in chrome");
	     System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
	     driver = new ChromeDriver();
	     Reporter.log("il browser si sta aprendo");
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	     
	 }
  
@Test
public void SeleniumUpload() {
	  
	  	//define base URL
		String baseUrl = "http://demo.guru99.com/test/upload/";
		
		 driver.get(baseUrl);
	     WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

	        // enter the file path onto the file-selection input field
	        uploadElement.sendKeys("C:\\seleniumuploadtest\\provauploadselenium.txt");

	        // check the "I accept the terms of service" check box
	        driver.findElement(By.id("terms")).click();

	        // click the "UploadFile" button
	        driver.findElement(By.name("send")).click();
	        
	        }

@AfterSuite
public void quitDriver() throws Exception {
    driver.quit();
    Reporter.log("la finestra viene chiusa");
}

}

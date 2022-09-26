package ProveSeleniumWebdriver;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;		
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class ProvaTooltipSelenium {
	
	private WebDriver driver;
	
	//commit nr 3
	//commit nr 3 
	//commit nr 5 aggiunto terzo commento 
	@BeforeSuite
    public void initDriver() throws Exception {
        System.out.println("You are testing in chrome");
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        Reporter.log("il browser si sta aprendo");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        
    }	
 
@Test
 public void Tooltip() throws Exception  {
		
		
	  
		//define base url 
		String baseUrl = "http://demo.guru99.com/test/tooltip.html";
		
		//define expected text in tooltip
		String expectedTooltip = "What's new in 3.2";	
		
		
		driver.get(baseUrl);
	    Reporter.log("IL SITO DI GURU99 test tooltip si sta aprendo");
	    
	    
	    WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));							
       
	    //crea  Action builder
	    Actions builder = new Actions (driver);	
	    Reporter.log("creato elemento Action Builder");
	    
	    //mouse hover on element with tooltip
	    builder.clickAndHold().moveToElement(download);					
        builder.moveToElement(download).build().perform();
        Reporter.log("il tooltip viene visualizzato");
        ProvaTooltipSelenium.takeSnapShot(driver, "C://Users//39349/tooltip1.png") ;
        Reporter.log("fatto screenshot del tooltip");
       
        //save the text in tooltip 
        WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));							
        String actualTooltip = toolTipElement.getText();	
        Reporter.log("il testo del tooltip � stato salvato");
        
        //compare expected tooltip text with actual tooltip text 
        System.out.println("Actual Title of Tool Tip  "+actualTooltip);							
        if(actualTooltip.equals(expectedTooltip)) {							
            System.out.println("Test Case Passed");					
        }	
        
        Reporter.log("confrontato il testo del tooltip attuale con quello atteso");
        
         
        
}
        
@AfterSuite
public void quitDriver() throws Exception {
    driver.quit();
    Reporter.log("la finestra viene chiusa");
}

        public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

            //Convert web driver object to TakeScreenshot

            TakesScreenshot scrShot =((TakesScreenshot)webdriver);

            //Call getScreenshotAs method to create image file

                    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

                //Move image file to new destination

                    File DestFile=new File(fileWithPath);

                    //Copy file at destination

                    FileUtils.copyFile(SrcFile, DestFile);

       
        }
		
  }


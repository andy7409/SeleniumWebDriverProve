package ProveSeleniumWebdriver;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.Iterator;		
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class SeleniumProva1TestNG {
	
			
  
  @Test
  public void Prova1TestNG() throws Exception  {
	  
      //second commit
	  //second commit
	  System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Reporter.log("il browser si sta aprendo");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
  	
      String baseUrl = "http://demo.guru99.com/test/newtours/";
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = "";
      String actualTitle2 = "";
      String actualTitle3 = "";
     
      
	  // launch Chrome and direct it to the Base URL
      driver.get(baseUrl);
      Reporter.log("IL SITO DI GURU99 NEWTOURS si sta aprendo");
      driver.manage().window().maximize();
      Reporter.log("la finestra si sta massimizzando");
      SeleniumProva1TestNG.takeSnapShot(driver, "C://Users//39349/test.png") ; 

      // get the actual value of the title
      actualTitle = driver.getTitle();

      /*
       * compare the actual title of the page with the expected one and print
       * the result as "Passed" or "Failed"
       */
      if (actualTitle.contentEquals(expectedTitle)){
          System.out.println("Test Passed!");
      } else {
          System.out.println("Test Failed");
      }
     
      //click insurance project
     
      
    driver.findElement(By.xpath("//a[contains(text(), 'Insurance Project')]")).click();
    
 // get the actual value of the title
    actualTitle2 = driver.getTitle();
    
    // print actual title (actual title2)     
        System.out.println(actualTitle2);
        
        Thread.sleep(1000);
        
        //switch to iframe
        driver.switchTo().frame("_mN_main_224278574_0_n");
        System.out.println("********We are switch to the iframe*******");
        
        //select data scientist courses
        driver.findElement(By.xpath("//*[@id='dk1']")).click();
        Thread.sleep(1000);
        
        /*select payroll management software
        driver.findElement(By.xpath("//*[@id='ResultWrapper']/ul/li[1]/a")).click();
        Thread.sleep(1000);*/
        
        //switch to new window
        String MainWindow=driver.getWindowHandle();
        
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);
                    
                    Thread.sleep(1000);
                    
                    //get the title of child window
                    actualTitle3 = driver.getTitle();
                    
                    //print title of child window
                    System.out.println(actualTitle3);
                    
                    
                    
		
            }		
        }		
       
      
        
        
        
      //close child window
        driver.close();
         
        
        
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(MainWindow);	
        
        //close main window
        driver.close();
       
        
       
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

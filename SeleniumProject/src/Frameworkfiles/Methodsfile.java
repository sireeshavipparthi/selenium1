package Frameworkfiles;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Methodsfile extends Readingexcelfiledata
{
	//static WebDriver driver;

	
	static String fn;
	 public static void captureScreenshot(WebDriver driver,String screenshotName) throws IOException
	 {

	 TakesScreenshot ts=(TakesScreenshot)driver;
	  
	 File source=ts.getScreenshotAs(OutputType.FILE);
	 String fn = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();
	 FileUtils.copyFile(source, new File("C:\\Users\\Admin\\eclipse-workspace\\My Java Programs\\SeleniumProject\\Screenshots\\"+ screenshotName+ fn +".png"));
	 System.out.println("Screenshot taken");

	 }	

		
@BeforeTest
  public static void openbrowser() throws IOException, InterruptedException
	{
	
int j=1;
	 
	  Testplanfile();
	 if(flag[j-1].equals("Y") && drive[j-1].equals("Firefox"))
	    {
		  System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\eclipse-workspace\\My Java Programs\\SeleniumProject\\Driver\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  //driver.manage().window().maximize();
		  logger.info("Invoking browser");
		 }
	 else if(flag[j].equals("Y") && drive[j].equals("Chrome"))
		  {
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\My Java Programs\\SeleniumProject\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				logger.info("Invoking browser");
				
		  }
	 
	 for(int k=1;k<=Command.length;k++)
 		{
 		 if(Command[k-1].equals("Openpath"))
			try {
				{
				  String URL =Readingexcelfiledata.Objxpath[k-1];
				  driver.get(URL);
				  logger.info("URL path opened succesfully");
				  System.out.println("open URL succesfully");
				 
				  
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				captureScreenshot(driver,"open");
			}
		else
 			 if(Command[k-1].equals("type"))
 		 {
 			
			 try {
				String Value =Readingexcelfiledata.Objxpath[k-1];
				
				// String Value1=FileRead.Input[j-1];
				System.out.println(Value);
				driver.findElement(By.xpath(Value)).sendKeys(Input[k-1]);
				logger.info("data taken");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				captureScreenshot(driver,"type");
			}
			
 		 }
 			 else
 			 {
 				 if(Command[k-1].equals("click"))
 				 {
 			
 					try {
						String Value1 =Readingexcelfiledata.Objxpath[k-1];
						
						// String Value1=FileRead.Input[j-1];
						System.out.println(Value1);
						driver.findElement(By.xpath(Value1)).click(); 
						 Thread.sleep(10000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						captureScreenshot(driver,"click");
					}
 				 }
 					else
 					{
 						 if(Command[k-1].equals("select"))
 		 				 {
 		 			
 		 					try {
 								String Value1 =Readingexcelfiledata.Objxpath[k-1];
 								
 								// String Value1=FileRead.Input[j-1];
 								System.out.println(Value1);
 								driver.findElement(By.xpath(Value1)).click(); 
 								 Thread.sleep(10000);
 							} catch (Exception e) {
 								// TODO Auto-generated catch block
 								e.printStackTrace();
 								captureScreenshot(driver,"select");
 							}
 		 				 }
 					}
 				
 			
 			 }
 		}
	}
	

 		
	
	  
	
	
	

 					
@AfterTest			
 	public static void closebrowser()
 	{
 		driver.quit();
 		System.out.println("browser closed succesfully");
 	}
}

 			 
	



package Frameworkfiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Frameworkfiles.Methodsfile;

public class Readingexcelfiledata
{
	static String src;
	static String result;
	static String[] Command;
	static String[] Objects;
	static String[] Objectnames;
	static String[] Objxpath;
	static String[] Runflags;
	static String[] Sheetnames;
	static XSSFSheet Sheet;
	static String[] Driver;
	static String Sheetname1;
	static String Sheetname;
	static String[] Input;
	public static WebDriver driver;
	 static String[] drive;
	 static String[] flag;;

	 static Logger logger =  Logger.getLogger("Readingdata");

@Test(priority=2)
	public static void Readtestsuitefile() throws IOException, InterruptedException
	{
	 PropertyConfigurator.configure("Log4j.properties");
		File src=new File("C:\\Users\\Admin\\eclipse-workspace\\My Java Programs\\SeleniumProject\\Datafiles\\Testsuite.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb2=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb2.getSheetAt(0);
		int rowcount=sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		System.out.println("No of rows in testsuite file: "+rowcount);
		Runflags = new String[rowcount];
		Sheetnames =new String[rowcount];
		
		logger.info("Reading TestSuite");
		for(int i=1;i<=rowcount;i++)
		{
			
			Runflags[i-1]= sheet1.getRow(i).getCell(0).getStringCellValue();
			Sheetnames[i-1]=sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println(Runflags[i-1] + " " +Sheetnames[i-1]) ;
			//String[] value= sheets.split("");
		
		boolean res = Runflags[i-1].equals("Y");
		boolean res2= Runflags[i-1].equals("N");
		boolean res1 =Sheetnames[i-1].equals(Sheetname1);
		
		//System.out.println(res1 + Sheetname1 + res + "****************************");
		
    	if(res&&res1 )
		{
    		
			Methodsfile.openbrowser();
		   Methodsfile.closebrowser();
    		
		}
    	else
    	{
    		System.out.println("no data found");
    	}
    	
}
		}
@Test(priority=1)	
public static void Testscriptfile() throws IOException, InterruptedException
 		{
	PropertyConfigurator.configure("Log4j.properties");
		 File src1=new File("C:\\Users\\Admin\\eclipse-workspace\\My Java Programs\\SeleniumProject\\Datafiles\\Testscript.xlsx");
		 FileInputStream fis1=new FileInputStream(src1);
		 XSSFWorkbook wb1=new XSSFWorkbook(fis1);
		 int noofsheetsintestscriptfile=wb1.getNumberOfSheets();
	 	 System.out.println("No of sheets in script files is:"+ noofsheetsintestscriptfile);
        for(int i=0; i<noofsheetsintestscriptfile;i++)
		 {
		   Sheet=wb1.getSheetAt(i);
		   Sheetname1 = Sheet.getSheetName();
		   //s = Sheetname1.toString();
		   System.out.println(Sheetname1+"$$$$$$$$$$$$");
		  int rowcount=Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		  Command=new String[rowcount];
		  Objects=new String[rowcount];
		  Objxpath=new String[rowcount];
		  Input=new String[rowcount];
		 //System.out.println(rowcount1);
		 //script data
		System.out.println("Script file data: ");
		for(int k=1;k<=rowcount;k++)
		{
			Command[k-1] =Sheet.getRow(k).getCell(0).getStringCellValue();
			//System.out.print(Command[j-1] + "           ");
 			Objects[k-1]= Sheet.getRow(k).getCell(1).getStringCellValue();
			//System.out.println(Objects[j-1]);
 			Objxpath[k-1]= Sheet.getRow(k).getCell(2).getStringCellValue();
 			// Input[k-1]= Sheet.getRow(k).getCell(3).getStringCellValue();
 			 // System.out.println(Command[k-1] + " "+Objects[k-1]+ " "+Objxpath[k-1] + " "+Input[k-1]);
 			XSSFCell emptycell=Sheet.getRow(k).getCell(3);
 			
 			if(emptycell != null)
 			{
 		    Input[k-1]= Sheet.getRow(k).getCell(3).getStringCellValue();
 			}
 			else
 			{
 				Command[k-1] =Sheet.getRow(k).getCell(0).getStringCellValue();
 				//System.out.print(Command[j-1] + "           ");
 	 			Objects[k-1]= Sheet.getRow(k).getCell(1).getStringCellValue();
 				//System.out.println(Objects[j-1]);
 	 			Objxpath[k-1]= Sheet.getRow(k).getCell(2).getStringCellValue();
 			}
 		    
 		 
			
		}
		 // continue;
		 Readtestsuitefile();
		}
		 }
 		
		 
 		
@Test(priority=3)
  public static void Testplanfile() throws IOException, InterruptedException
   {
	  PropertyConfigurator.configure("Log4j.properties");
    File src1=new File("C:\\Users\\Admin\\eclipse-workspace\\My Java Programs\\SeleniumProject\\Datafiles\\Testplan.xlsx");
     FileInputStream fis1=new FileInputStream(src1);
      XSSFWorkbook wb3=new XSSFWorkbook(fis1);
      Sheet=wb3.getSheetAt(0);
      int rowcount=Sheet.getLastRowNum()-Sheet.getFirstRowNum();
      System.out.println("No of rows in testplan file" + rowcount);
        flag = new String[rowcount];
        drive = new String[rowcount];
        System.out.println("testplan file data");
      for(int j=1;j<=rowcount;j++)
          {
           flag[j-1] =Sheet.getRow(j).getCell(0).getStringCellValue();
           System.out.print(flag[j-1] + "           ");
           drive[j-1]= Sheet.getRow(j).getCell(1).getStringCellValue();
           System.out.println(drive[j-1]);
            System.out.println("                  ");
            //continue;
          }	 		
	
   }

public static void main(String[] args) throws IOException, InterruptedException
{
	
	Testscriptfile();
	//Testplanfile();
	//Readtestsuitefile();
}
}

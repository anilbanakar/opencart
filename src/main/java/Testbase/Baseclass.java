package Testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import org.testng.annotations.Parameters;

public class Baseclass {

	public static WebDriver driver;
	public Logger logger; // create variable for logging the logs 
	
	public ResourceBundle rb;
	
	@BeforeClass(groups={"Master", "Regression", "Sanity"}) // to group the testcase 
	@Parameters("browser")
	public void setup(String br)
	{
		
	rb=ResourceBundle.getBundle("config"); // load config.properties file 
	
	logger =  LogManager.getLogger(this.getClass());// for logging 		
		
	//WebDriverManager.chromedriver().setup(); // no need this is latest selenium version 

	if(br.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(br.equals("edge"))
	{
		driver= new EdgeDriver();
	}

	

	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get(rb.getString("appurl"));
	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	
	}


	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
        }

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;


}
}
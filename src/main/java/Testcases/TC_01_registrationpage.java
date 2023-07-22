package Testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Testbase.Baseclass;
import pageobjects.Homepage;
import pageobjects.Registrationpage;

public class TC_01_registrationpage extends Baseclass {

	
	@Test(groups={"Master", "Regression", "Sanity"})
	void login()
	{
		logger.info("Starting TC_01_registrationpage");
		
		try 
		{
 		Homepage hp= new Homepage(driver);
        hp.clickMyAccount();
        logger.info("clicked my account"); // you can write for all actions if need logs 
        hp.clickRegister();
        
    
        Registrationpage reg= new Registrationpage(driver);
        reg.setfirstname("anil");
        reg.setlastname("kumar");
        reg.setemail("anil@gmail.com");
        reg.settelephone("123");
        reg.setpassword("test@123");
        reg.confirm();
        reg.agree();
        reg.clickcontinue();
		}
		catch (Exception e)
		{
			
		}
	}
	
	


}

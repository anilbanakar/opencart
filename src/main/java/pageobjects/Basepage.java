package pageobjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;

	public class Basepage {

		
		// create constructor 
		
		WebDriver driver;
	    public Basepage(WebDriver driver)	
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver, this);
	    }
		

	}

	



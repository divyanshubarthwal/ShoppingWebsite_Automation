package SeleniumFrameworkDesign.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driverdriver) {
		//initialization
		this.driver=driver;
		//this method will trigger initialization of all elements
		//this initElemets is inside constructor bcz we want this to be execute first
		PageFactory.initElements(driver,this);
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//PageFactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	

	@FindBy(id="login")
	WebElement submit;
	
	
}

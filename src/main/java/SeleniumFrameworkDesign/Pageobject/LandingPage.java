package SeleniumFrameworkDesign.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		//initialization
		super(driver);
		//using super we are putting this child driver to parent abstract method AbstractComponent
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
	
	public ProductCatalogue loginApplication(String email,String password1) {
		userEmail.sendKeys(email);
		password.sendKeys(password1);
		submit.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}

package SeleniumFrameworkDesign.Pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		//initialization
		super(driver);
		this.driver=driver;
		//this method will trigger initialization of all elements
		//this initElemets is inside constructor bcz we want this to be execute first
		PageFactory.initElements(driver,this);
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//PageFactory
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="..ng-animating")
	WebElement spinner;
	
	//Here pagefactory is not used as it is only for driver object
	By prodcutsBy=By.cssSelector(".mb-3");
	By addToCart=By.xpath("/html/body/app-root/app-dashboard/section[2]/div[1]/div[2]/div[1]/div/div/button[2]");
	By toastMessage=By.cssSelector("#toast-container");
	public List<WebElement> getProductList() {
		waitForElementToAppear(prodcutsBy);
		return products;
	}
	public WebElement getProductByName(String productName) {
		WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText()
				.equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}
	
}

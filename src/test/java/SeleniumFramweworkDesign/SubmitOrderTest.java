package SeleniumFramweworkDesign;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;
import SeleniumFrameworkDesign.Pageobject.CartPage;
import SeleniumFrameworkDesign.Pageobject.LandingPage;
import SeleniumFrameworkDesign.Pageobject.ProductCatalogue;



public class SubmitOrderTest extends AbstractComponent {

	public SubmitOrderTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException  {
	
	WebDriver driver=new ChromeDriver();
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
	String productName="ZARA COAT 3";
	
	driver.manage().window().maximize();
	
	LandingPage landingPage=new LandingPage(driver);
	landingPage.goTo();
	//landingPage.loginApplication("D@gmail.com","Dd@123456");
	ProductCatalogue productCatalogue=landingPage.loginApplication("D@gmail.com","Dd@123456");
	
	List<WebElement>products=productCatalogue.getProductList();
	productCatalogue.addProductToCart(productName);
	CartPage cartPage=productCatalogue.goToCartPage();
	
	Boolean match=cartPage.VerifyProductDisplay(productName);
	//System.out.print(products.size());
	//validation cannot go in Page object file

	Assert.assertTrue(match);
	cartPage.goToCheckout();
	
	
	driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
	
	
	driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
	
	String Expected=driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	
	Assert.assertTrue(Expected.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	
	driver.quit();

	}

}

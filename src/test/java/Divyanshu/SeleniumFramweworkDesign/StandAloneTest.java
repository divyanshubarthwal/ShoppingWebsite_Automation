package Divyanshu.SeleniumFramweworkDesign;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException  {
	
	WebDriver driver=new ChromeDriver();
	
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	
	String productname="ZARA COAT 3";
	driver.get("https://rahulshettyacademy.com/client");
	driver.manage().window().maximize();
	driver.findElement(By.id("userEmail")).sendKeys("D@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Dd@123456");
	
	driver.findElement(By.id("login")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	
	List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	//System.out.print(products.size());
	
	WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText()
			.equals(productname)).findFirst().orElse(null);
	prod.findElement(By.xpath("/html/body/app-root/app-dashboard/section[2]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
	
Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
	//ng-animating
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("[routerlink=\"/dashboard/cart\"]")).click();
	Thread.sleep(2000);
	
	List<WebElement> cartproducts =driver.findElements(By.cssSelector("//*[@class='cartSection']/h3"));
	Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
			
	Assert.assertTrue(match);
	
	driver.quit();

	}

}

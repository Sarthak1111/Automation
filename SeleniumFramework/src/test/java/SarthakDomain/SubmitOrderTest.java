package SarthakDomain;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SarthakDomain.TestComponents.BaseTest;
import SarthakDomain.pageObjects.CartPage;
import SarthakDomain.pageObjects.ConfirmationPage;
import SarthakDomain.pageObjects.LandingPage;
import SarthakDomain.pageObjects.PlaceOrderPage;
import SarthakDomain.pageObjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
		
	@Test
	public void submitOrder() throws IOException {	
	
		String productName="ADIDAS ORIGINAL";
		ProductCatalogue pc =landingPage.loginApplication("saru@gmail.com", "123456");
		List<WebElement> products= pc.getProductList();
		pc.selectProductToCart(productName);

		CartPage cp=pc.gotoCartPage();
		Boolean match= cp.checkProductinCart(productName);
		Assert.assertTrue(match);
		PlaceOrderPage placeOrderPage=cp.checkout();
		//Selecting india from autosuggestion dropdown
		
		  placeOrderPage.countryfield("india");
		  ConfirmationPage confirmationPage=placeOrderPage.submitOrder();
		  
			
			  String textString= confirmationPage.getconfirmationMsg();
			  System.out.println(textString);
			  Assert.assertTrue(textString.equalsIgnoreCase("THANKYOU FOR THE ORDER."));			 
		
		//List<WebElement> a= driver.findElements(By.cssSelector(".infoWrap"));
		//a.stream().filter(s->s.findElement(By.cssSelector(".cartSection"))).ge.equals("ADIDAS ORIGINAL").
		
		
		//Country
		/*
		 * driver.findElement(By.xpath("//div[@class=\"form-group\"]/input")).sendKeys(
		 * "ind"); //List<WebElement> options= driver.findElements();
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[contains(@class,\"ta-results\")]")));
		 * //driver.findElements(By.xpath("//*[contains(@class,\"ta-results\")]"));
		 * driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).
		 * click();
		 * 
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
		 * "//*[contains(@class,\"ta-results\")]"))); JavascriptExecutor
		 * js=(JavascriptExecutor)driver; js.executeScript(null, args) WebElement
		 * element= driver.findElement(By.cssSelector(".btnn")); element.click();
		 */
		
		
		  
			/*
			 * actions.sendKeys(driver.findElement(By.xpath(
			 * "//div[@class=\"form-group\"]/input")), "ind").build().perform();
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * "//*[contains(@class,\"ta-results\")]")));
			 * driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).
			 * click();
			 */
		 
		
			/*
			 * JavascriptExecutor js =(JavascriptExecutor) driver;
			 * js.executeScript("window.scrollBy(0,900)");
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
			 * ".action__submit")));
			 * driver.findElement(By.cssSelector(".action__submit")).click();
			 */
		

			/*
			 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
			 * "(//button[contains(@class,'ta-item')])[2]"))); Thread.sleep(3000);
			 */
			/*
			 * JavascriptExecutor jse = (JavascriptExecutor)driver;
			 * 
			 * // jse.executeScript("scroll(250, 0)"); // if the element is on top.
			 * 
			 * jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
			 * 
			 * 
			 * WebElement element =driver.findElement(By.cssSelector(".action__submit"));
			 * Actions actions = new Actions(driver);
			 * actions.moveToElement(element).click().perform();
			 */
	}
	
	@Test
	public void name() {
		driver.get("https://www.google.com/");
	}
}

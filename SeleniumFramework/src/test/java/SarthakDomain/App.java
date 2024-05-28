package SarthakDomain;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SarthakDomain.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.cssSelector("input[formcontrolname=\"userEmail\"]")).sendKeys("saru@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("[value=\"Login\"]")).click();
		LandingPage lp= new LandingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));// ".card-body" and ".mb-3" are
																						// same locator

		System.out.println(products.size());
		////wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));

		WebElement product = products.stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst()
				.orElse(null);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[style=\\\"float:
		// right;\\\"]")));
		product.findElement(By.cssSelector("[style=\"float: right;\"]")).click();

		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-success')]")));
		WebElement cart = driver.findElement(By.cssSelector("[routerlink=\"/dashboard/cart\"]"));
		cart.click();
		
		//List<WebElement> a= driver.findElements(By.cssSelector(".infoWrap"));
		//a.stream().filter(s->s.findElement(By.cssSelector(".cartSection"))).ge.equals("ADIDAS ORIGINAL").
		List<WebElement> cartElements= driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=	cartElements.stream().anyMatch(s->s.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
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
		
		//Selecting india from autosuggestion dropdown
		Actions actions=new Actions(driver);
		actions.sendKeys(driver.findElement(By.xpath("//div[@class=\"form-group\"]/input")), "ind")
		.build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,\"ta-results\")]")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		driver.findElement(By.cssSelector(".action__submit")).click();
		

	}
}

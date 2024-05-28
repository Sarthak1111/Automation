package SarthakDomain.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SarthakDomain.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialize all webelements as name suggest with driver
	}

	// WebElement userEmail
	// =driver.findElement(By.cssSelector("input[formcontrolname=\"userEmail\"]"));

	// Pagefactory at runtime id in parameter will be converted to
	// findElement(By.cssSelector..
	// and assigned to webelement variable
	// but findBy doesnt work without driver it need driver so in constructor write
	// Pagefactory.initElements()
	@FindBy(css = ".card-body")
	List<WebElement> products;

	@FindBy(xpath = "//div[contains(@class,'toast-success')]")
	WebElement toastMsg;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector("[style=\"float: right;\"]");

	public List<WebElement> getProductList() {
		waitForElements(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement product = getProductList().stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return product;

	}

	public CartPage selectProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementsDisappear(toastMsg);
		CartPage cp = new CartPage(driver);
		return cp;

	}

}

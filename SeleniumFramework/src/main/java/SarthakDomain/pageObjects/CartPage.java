package SarthakDomain.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SarthakDomain.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); //initialize all webelements as name suggest with driver
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartElements;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;
	
	public boolean checkProductinCart(String productName) {
		Boolean match= cartElements.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	public PlaceOrderPage checkout() {
		checkoutButton.click();
		PlaceOrderPage pop=new PlaceOrderPage(driver);
		return pop;
	}
}

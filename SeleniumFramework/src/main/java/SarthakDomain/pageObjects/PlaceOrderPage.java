package SarthakDomain.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SarthakDomain.AbstractComponents.AbstractComponents;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class PlaceOrderPage extends AbstractComponents{

	WebDriver driver;
	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this); //initialize all webelements as name suggest with driver
	}
	
	@FindBy(xpath = "//div[@class='form-group']/input")
	WebElement inputField;
	
	By countryDropdown =By.xpath("//*[contains(@class,\"ta-results\")]");
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement placeorder;
	
	@FindBy(css = ".action__submit")
	WebElement submit;
	
	@FindBy(css = ".action__submit")
	WebElement element;
	
	public void countryfield(String countryName) {
		Actions actions=new Actions(driver);
		actions.sendKeys(inputField, countryName).build().perform();
		waitForElements(countryDropdown);
		placeorder.click();
	}
	
	public ConfirmationPage submitOrder() {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		ConfirmationPage cp=new ConfirmationPage(driver);
		return cp;
	
	}

}

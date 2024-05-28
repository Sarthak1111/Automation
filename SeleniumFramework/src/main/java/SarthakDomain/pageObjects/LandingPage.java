package SarthakDomain.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SarthakDomain.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); //initialize all webelements as name suggest with driver
	}
	
	
	//Pagefactory at runtime id in parameter will be converted to findElement(By.cssSelector..
	//and assigned to webelement variable
	//but findBy doesnt work without driver it need driver so in constructor write Pagefactory.initElements()
	@FindBy(css = "input[formcontrolname=\"userEmail\"]")
	WebElement userEmail;
	//	WebElement pass= driver.findElement(By.id("userPassword")).sendKeys("123456");
	@FindBy(id = "userPassword")
	WebElement userpassword;
	//	driver.findElement(By.cssSelector("[value=\"Login\"]")).click();
	@FindBy(css = "[value='Login']")
	WebElement submit;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalogue loginApplication(String email, String pass) {
		userEmail.sendKeys(email);
		userpassword.sendKeys(pass);
		submit.click();
		ProductCatalogue pc=new ProductCatalogue(driver);
		return pc;
	}
	


}

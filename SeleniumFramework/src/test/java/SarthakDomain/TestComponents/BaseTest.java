package SarthakDomain.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SarthakDomain.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException {
		
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Eclipse\\SeleniumFramework\\src\\main\\java\\SarthakDomain\\resources\\GlobalData.properties");
		properties.load(fis);
		
		String browserName=properties.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();;
			 driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		
		driver=initializeDriver();
		 landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;	
	}
	
	  @AfterMethod public void teardown() { driver.close(); }
	 
}

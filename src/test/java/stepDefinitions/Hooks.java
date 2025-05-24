package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.configReader;
import io.cucumber.java.Before;

public class Hooks {

	
	  @Before
	    public void setup() {
	        configReader.loadProperties();
	        String browser = configReader.getProperty("browser");

	        if (browser.equalsIgnoreCase("chrome")) {
	            BaseClass.driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            BaseClass.driver = new FirefoxDriver();
	        } else {
	            throw new RuntimeException("Browser not supported: " + browser);
	        }

	        BaseClass.driver.manage().window().maximize();
	        BaseClass.driver.get(configReader.getProperty("url"));

	        // Initialize page objects
	        BaseClass.lp = new pageObjects.LoginPage(BaseClass.driver);
	        BaseClass.addProduct = new pageObjects.AddProduct(BaseClass.driver);
	        BaseClass.cartCheckout = new pageObjects.CartCheckOut(BaseClass.driver);
	    }

	    @After
	    public void tearDown() {
	        if (BaseClass.driver != null) {
	            BaseClass.driver.quit();
	        }
	    }
	}


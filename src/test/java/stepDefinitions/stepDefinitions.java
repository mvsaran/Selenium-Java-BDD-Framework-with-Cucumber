package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;
import utilities.configReader;
import pageObjects.AddProduct;
import pageObjects.CartCheckOut;

public class stepDefinitions extends BaseClass {

//    @Given("User Launch Chrome browser")
//    public void user_launch_chrome_browser() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        lp = new LoginPage(driver);
//        addProduct = new AddProduct(driver);
//        cartCheckout = new CartCheckOut(driver);
    //}
	
	@Given("Browser is initialized")
	public void browser_is_initialized() {
	    // Already handled by Hooks
	}

    @When("User Opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("user click on Login option")
    public void user_click_on_login_option() {
        lp.loginLink();
    }

//    @When("User enters Username as {string} and Passwod as {string}")
//    public void user_enters_username_as_and_passwod_as(String uname, String pwd) {
//        lp.setUserName(uname);
//        lp.setPassword(pwd);
//    }
    @When("User logs in using credentials from config")
    public void user_logs_in_using_credentials_from_config() {
        String uname = configReader.getProperty("username");
        String pwd = configReader.getProperty("password");
        lp.setUserName(uname);
        lp.setPassword(pwd);
    }

    @When("click on Login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @When("user click on Logout")
    public void user_click_on_logout() {
        lp.logout();
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

    // ==============================
    // AddProduct Feature StepDefs
    // ==============================

    @When("User navigates to Laptops category")
    public void user_navigates_to_laptops_category() {
        addProduct.clickLaptopLink();
    }

    @When("User selects Product")
    public void user_selects_product() {
        addProduct.clickProductLink();
    }

    @When("User clicks on Add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        addProduct.clickAddToCart();
    }

    @Then("A confirmation alert with message {string} should appear")
    public void a_confirmation_alert_with_message_should_appear(String expectedMessage) {
        String actualAlert = addProduct.handleAndValidateAlert();
        Assert.assertTrue("Expected alert to contain message: " + expectedMessage + 
                          ", but was: " + actualAlert, actualAlert.contains(expectedMessage));
    }
    
    //-------------------------------
    //Cart Checkout Step Definitions	
    //-------------------------------
    
   
    @When("User clicks on Cart")
    public void user_clicks_on_cart() {
        cartCheckout.clickCart();
    }
    @Then("The product {string} should be visible in the cart")
    public void the_product_should_be_visible_in_the_cart(String productName) {
        Assert.assertTrue(cartCheckout.isProductVisibleInCart(productName));
    }
    @When("I clear the cart if more than one product added")
    public void i_clear_the_cart() {
        cartCheckout.clearCart(); // Assuming cartPage is initialized in your StepDef class
    }
    @Then("User clicks on Place Order button")
    public void user_clicks_on_place_order_button() {
       cartCheckout.clickPlaceOrder();
    }
   

    @When("User fills the order form with dynamic random values")
    public void user_fills_the_order_form_with_dynamic_random_values() {
    	cartCheckout.fillOrderFormDynamically();
    }



    /*@When("^User fills the order form with Name \"([^\"]*)\", Country \"([^\"]*)\", City \"([^\"]*)\", Credit card \"([^\"]*)\", Month \"([^\"]*)\", Year \"([^\"]*)\"$")
    public void user_fills_the_order_form_dynamically() {
        cartCheckout.fillOrderFormDynamically();
    }*/

    @When("User clicks on Purchase button")
    public void user_clicks_on_purchase_button() {
        cartCheckout.clickPurchase();
    }
    @Then("Success message {string} should be displayed")
    public void success_message_should_be_displayed(String string) {
        cartCheckout.getSuccessMessage();
    }
    @Then("User clicks OK on the success alert")
    public void user_clicks_ok_on_the_success_alert() {
        cartCheckout.closeSuccessAlert();
    }



}

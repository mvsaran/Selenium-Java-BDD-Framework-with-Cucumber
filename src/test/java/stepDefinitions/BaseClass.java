package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.AddProduct;
import pageObjects.CartCheckOut;

public class BaseClass {
    public static WebDriver driver;
    public static LoginPage lp;
    public static AddProduct addProduct;
    public static CartCheckOut cartCheckout;
}

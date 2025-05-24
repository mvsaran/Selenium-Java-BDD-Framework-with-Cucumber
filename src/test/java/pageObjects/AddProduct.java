package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddProduct {

    WebDriver ldriver;
    WebDriverWait wait;

    // Locators
    By laptoplink = By.xpath("//a[normalize-space(text())='Laptops']");
    By productlink = By.xpath("//a[text()='Sony vaio i5']");
    By addtoCart = By.xpath("//a[text()='Add to cart']");

    // Constructor
    public AddProduct(WebDriver rdriver) {
        ldriver = rdriver;
        wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        PageFactory.initElements(ldriver, this);
    }

    // Click on Laptops and wait for product to load
 // Click on Laptops and wait for product to load
    public void clickLaptopLink() {
        int maxRetries = 3;
        int attempts = 0;

        while (attempts < maxRetries) {
            try {
                WebElement laptopElement = wait.until(ExpectedConditions.elementToBeClickable(laptoplink));
                laptopElement.click();

                // Wait until "Sony vaio i5" is visible after clicking
                wait.until(ExpectedConditions.visibilityOfElementLocated(productlink));
                break; // Exit loop if successful
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Attempt " + (attempts + 1) + ": Caught stale element. Retrying...");
                attempts++;
                try {
                    Thread.sleep(500); // Brief wait before retrying
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                }
            }
        }

        if (attempts == maxRetries) {
            throw new RuntimeException("Failed to click on Laptops link after " + maxRetries + " attempts due to stale element reference.");
        }
    }


    // Click on Sony Vaio i5
    public void clickProductLink() {
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(productlink));
        productElement.click();
    }

    // Click on Add to cart
    public void clickAddToCart() {
        WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addtoCart));
        addToCartElement.click();
    }

    // Handle and return alert text
    public String handleAndValidateAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = ldriver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}

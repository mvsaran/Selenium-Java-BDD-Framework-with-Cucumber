package pageObjects;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartCheckOut {
	
	WebDriver ldriver;
	WebDriverWait wait;
	
	public CartCheckOut(WebDriver rdriver) {
		ldriver = rdriver;
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		PageFactory.initElements(ldriver, this);
	}
	
	// Locators
	// Add locators for cart and checkout elements here
	
	By cartLink = By.xpath("//a[normalize-space(text())='Cart']");
	By productTitle = By.xpath("//td[normalize-space()='Sony vaio i5']");
	By placeOrderButton = By.xpath("//button[normalize-space()='Place Order']");
	By nameField = By.xpath("//input[@id='name']");
	By countryField = By.xpath("//input[@id='country']");
	By cityField = By.xpath("//input[@id='city']");
	By cardField = By.xpath("//input[@id='card']");
	By monthField = By.xpath("//input[@id='month']");
	By yearField = By.xpath("//input[@id='year']");
	By purchaseButton = By.xpath("//button[normalize-space()='Purchase']");
	By successMessage = By.xpath("//h2[normalize-space()='Thank you for your purchase!']");
	By closeAlertButton = By.xpath("//div[@id='orderModal']//button[contains(@type,'button')][normalize-space()='Close']");
	
	// Actions
	public void clickCart() {
		ldriver.findElement(cartLink).click();
		
	}
	public void clearCart() {
		List<WebElement> deleteLinks = ldriver.findElements(By.xpath("//a[text()='Delete']"));

	    // Only delete if more than one product is present
	    while (deleteLinks.size() > 1) {
	        deleteLinks.get(0).click();  // Click the first "Delete" link

	        try {
	            Thread.sleep(2000); // Wait for deletion to reflect
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt(); // Preserve interrupt status
	        }

	        // Refresh list after deletion
	        deleteLinks = ldriver.findElements(By.xpath("//a[text()='Delete']"));
	    }
	}
	public boolean isProductVisibleInCart(String productName) {
	    try {
	        By productLocator = By.xpath("//td[contains(text(),'" + productName + "')]");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
	        return ldriver.findElement(productLocator).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	public void clickPlaceOrder() {
		ldriver.findElement(placeOrderButton).click();
	}
	public void fillOrderFormDynamically() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
	    String name = "User_" + UUID.randomUUID().toString().substring(0, 5);
	    String[] countries = {"USA", "India", "Germany", "France", "Brazil"};
	    String country = countries[new Random().nextInt(countries.length)];
	    String city = "City_" + new Random().nextInt(1000);
	    String card = "4111" + (100000000 + new Random().nextInt(899999999));  // random 12-digit Visa-like
	    String month = String.valueOf(new Random().nextInt(12) + 1);
	    String year = String.valueOf(LocalDateTime.now().getYear() + new Random().nextInt(5)); // e.g., 2025–2029

	    ldriver.findElement(nameField).sendKeys(name);
	    ldriver.findElement(countryField).sendKeys(country);
	    ldriver.findElement(cityField).sendKeys(city);
	    ldriver.findElement(cardField).sendKeys(card);
	    ldriver.findElement(monthField).sendKeys(month);
	    ldriver.findElement(yearField).sendKeys(year);
	}

	
	public void clickPurchase() {
		ldriver.findElement(purchaseButton).click();
	}
	public String getSuccessMessage() {
		return ldriver.findElement(successMessage).getText();
	}
	public void closeSuccessAlert() {
		ldriver.findElement(closeAlertButton).click();
	}
	

}

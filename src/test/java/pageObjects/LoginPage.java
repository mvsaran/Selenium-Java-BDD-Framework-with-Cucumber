package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@id='login2']")
	WebElement loginLink;
	
	@FindBy(xpath = "//input[@id='loginusername']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='loginpassword']")
	WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement loginButton;
	

	
	@FindBy(xpath = "//a[@id='logout2']")
	WebElement logout;
	
	public void loginLink() {
	    loginLink.click();
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(username)); // Wait for modal to be visible
	}

	public void setUserName(String uname) {
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(username));
	    username.clear();
	    username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(password));
	    password.clear();
	    password.sendKeys(pwd);
	}

	public void clickLogin() {
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(loginButton));
	    loginButton.click();
	}
	
	
	public void logout() {
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(logout));
	    wait.until(ExpectedConditions.elementToBeClickable(logout));
	    logout.click();
	}
}

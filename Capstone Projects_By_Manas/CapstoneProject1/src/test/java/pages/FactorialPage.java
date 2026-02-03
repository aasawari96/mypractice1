package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactorialPage {

	public FactorialPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initializes WebElements only after driver is available.
	}

	WebDriver driver;

//	public WebElement textbox = driver.findElement(By.id("number"));
//	public WebElement calButton = driver.findElement(By.id("getFactorial"));
//	public WebElement about = driver.findElement(By.id("About"));
//	public WebElement termsCondition = driver.findElement(By.id("Terms and Conditions"));
//	public WebElement privacy = driver.findElement(By.id("Privacy"));

	@FindBy(id = "number")
	public WebElement textbox;

	@FindBy(id = "getFactorial")
	public WebElement calButton;

	@FindBy(linkText = "About")
	public WebElement aboutLink;

	@FindBy(linkText = "Terms and Conditions")
	public WebElement termsCondition;

	@FindBy(linkText = "Privacy")
	public WebElement privacy;

	@FindBy(id = "resultDiv")
	public WebElement resultDiv;

}

package MyCucumberProject.Qkart_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class QkartPages extends BaseTest {

	// Constructor
	public QkartPages(WebDriver driver) {
		QkartPages.driver = driver;

		// Auto wait for all @FindBy elements (15 sec)
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this); // Takes the driver, Scans the
																					// current class (this), Initializes
																					// all
																					// elements marked with @FindBy
	}

	// Locators
	@FindBy(xpath = "//*[text()='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//*[text()='Register']")
	private WebElement regButton;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBox;

	@FindBy(id = "username")
	private WebElement usrnameTextBox;

	@FindBy(id = "password")
	private WebElement passTextBox;

	@FindBy(xpath = "//*[text()='Login to QKart']")
	private WebElement loginToQkarBtn;

	@FindBy(xpath = "//*[text()='Logout']")
	private WebElement logoutButton;

//	@FindBy(xpath = "(//button[contains(@class,'MuiButton-root')])[4]")
//	private WebElement racquet;

	@FindBy(xpath = "//div[@id='notistack-snackbar']")
	private WebElement alertMessage;

	// Wait Utilities
	private WebElement waitForClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private WebElement waitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Getters for the WebElements
	public WebElement getloginButton() {
		return waitForClickable(loginButton);
	}

	public WebElement getregButton() {
		return waitForClickable(regButton);
	}

	public WebElement getsearchBox() {
		return waitForVisible(searchBox);
	}

	public WebElement getusrnameTextBox() {
		return waitForVisible(usrnameTextBox);
	}

	public WebElement getpassTextBox() {
		return waitForVisible(passTextBox);
	}

	public WebElement getloginToQkarBtn() {
		return waitForClickable(loginToQkarBtn);
	}

	public WebElement getlogoutButton() {
		return waitForClickable(logoutButton);
	}

//	public WebElement getracquet() {
//		return racquet;
//	}

	public void clickRacquet() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement racquetBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class,'MuiButton-root')])[4]")));

		racquetBtn.click();
	}

	// Capture product name dynamically (first product / racquet)
	public String getracquetName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement product = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//p[contains(@class,'MuiTypography-root')])[5]")));
		return product.getText();
	}

	// Verify product present in cart
	public boolean isProductInCart(String productName) {

		List<WebElement> items = driver.findElements(
				By.xpath("//div[contains(@class, 'MuiCardContent-root')]//p[text()='" + productName + "']"));

		return items.size() > 0;
	}

	public void waitUntilProductAppearsInCart(String productName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class, 'MuiCardContent-root')]//p[text()='" + productName + "']")));
	}

	public String getAlertMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement alert = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(@class,'SnackbarItem-message')]")));

		return alert.getText();
	}

	public void waitForAlertToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'SnackbarItem-message')]")));
	}

}

package MyCucumberProject.Qkart_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class QkartProject extends BaseTest {
	QkartPages q;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browserName) throws Exception {
		launchBrowser(browserName);
		q = new QkartPages(driver); // Initializes Page Object with WebDriver.
		Thread.sleep(1500);
	}

	// Scenario: 1
	// Validation All the necessary UI Elements are Present and Clickable (Login
	// Button, Register Button, Search Text box)
	@Test(priority = 1)
	public void testCase1() {
		boolean loginBtnDisplay = q.getloginButton().isDisplayed();
		boolean loginBtnEnable = q.getloginButton().isEnabled();
		boolean regBtnDisplay = q.getregButton().isDisplayed();
//		boolean regBtnEnable = q.getregButton().isEnabled();
		boolean searchBoxDisplay = q.getsearchBox().isDisplayed();

		SoftAssert s = new SoftAssert();
		s.assertEquals(loginBtnDisplay, true);
		s.assertEquals(loginBtnEnable, true);
		s.assertEquals(regBtnDisplay, true);
//		s.assertEquals(regBtnEnable, true);
		s.assertEquals(searchBoxDisplay, true);
		s.assertAll(); // It collects and reports all assertion failures that happened in the test.
						// Without assertALL() SoftAssert does NOTHING.

	}

	// Scenario: 2
	// Verify the total number of images in QKart Home page.
	// Verify the total number of link in QKart Home page.

	@Test(priority = 2)
	public void testCase2() {
		List<WebElement> img = driver.findElements(By.tagName("img"));
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of images: " + img.size());
		System.out.println("Number of links: " + links.size());

	}

	@Test(priority = 3)
	public void testCase3() {
		String searchBoxText = q.getsearchBox().getAttribute("placeholder");
		String pageTitle = pageTitle();
		System.out.println(pageTitle);
		String pageUrl = pageUrl();
		System.out.println(pageUrl);
		String Expt = "https";
		boolean contains = pageUrl().contains(Expt);

		SoftAssert s = new SoftAssert();
		s.assertEquals(searchBoxText, "Search for items/categories");
		s.assertEquals(pageTitle, "QKart");
		s.assertTrue(contains, "URL does not contains 'https'");
		s.assertAll();

	}

	@DataProvider(name = "Login_data")
	public Object[][] LoginData() {
		return new Object[][] { { "admin123", "admin123" } };
	}

	@Test(priority = 4, dataProvider = "Login_data")
	public void testCase4(String uid, String pass) {
		q.getloginButton().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		q.getusrnameTextBox().sendKeys(uid);
		q.getpassTextBox().sendKeys(pass);
		q.getloginToQkarBtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		boolean logoutBtnDisplay = q.getlogoutButton().isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		SoftAssert s = new SoftAssert();
		s.assertEquals(logoutBtnDisplay, true, "Logout Successfully");
		s.assertAll();

	}

	@Test(priority = 5, dataProvider = "Login_data")
	public void testCaseBug(String uid, String pass) {

		SoftAssert s = new SoftAssert();

		// Capture product name dynamically
		String productName = q.getracquetName();
		System.out.println("Product Selected: " + productName);

//		// Item added 1st time
		q.clickRacquet();

		q.waitUntilProductAppearsInCart(productName);
		s.assertTrue(q.isProductInCart(productName), "Item not added in cart");

		q.waitForAlertToDisappear();

		// item added 2nd time
		q.clickRacquet();

		String secondMsg = q.getAlertMessage();
		s.assertTrue(
				secondMsg.contains("Item already in cart. Use the cart sidebar to update quantity or remove item."),
				"BUG FOUND: System allows duplicate product addition");
		s.assertAll();

	}

	public void closeTheBrowser() {
		closeBrowser();
	}

}

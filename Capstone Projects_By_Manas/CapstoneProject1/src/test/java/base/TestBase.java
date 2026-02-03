package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {

	public WebDriver driver;

	@Parameters({ "browser" })
	@BeforeMethod // Run before each test
	public void setUp(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\Desktop\\Selenium Jar files\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get("https://qainterview.pythonanywhere.com/");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void closeWindow() {
		driver.quit();
	}

}

package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;

	public static Properties prop;

	public void LoadProperties() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\HP\\eclipse-workspace\\Qkart_Project\\config.properties"); // opening config file from path
		prop = new Properties();
		prop.load(file); // load config.properties file
	}

	@BeforeClass // class will Run at once before group of tests runs
	@Parameters("browser")
	public void launchBrowser(String browserName) throws IOException {
		LoadProperties(); // To Reads config.properties
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\HP\\Desktop\\Selenium Jar files\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\Desktop\\Selenium Jar files\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
//		else if (browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.firefox.driver",
//					"C:\\Users\\HP\\Desktop\\Selenium Jar files\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url")); // Opens the URL from config.properties

	}

//	@AfterClass(alwaysRun = true)
//	public void closeWindow() {
//		System.out.println("AfterClass executed...");
//		if (driver != null) {
//			driver.quit(); // closes all browser windows & ends session
//		}
//	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void quiteBrowser() {
		driver.quit();

	}

	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String pageUrl() {
		String Url = driver.getCurrentUrl();
		return Url;
	}
}

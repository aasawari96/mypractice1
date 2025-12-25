package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium2 {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new EdgeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("Kishore");
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys("Qshore");
		Thread.sleep(1000);

		System.out.println(driver.getTitle());
		driver.close();

	}

}

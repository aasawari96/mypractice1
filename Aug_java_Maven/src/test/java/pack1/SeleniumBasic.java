package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasic {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
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

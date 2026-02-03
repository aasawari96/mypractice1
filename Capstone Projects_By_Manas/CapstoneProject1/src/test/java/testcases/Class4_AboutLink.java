package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FactorialPage;

public class Class4_AboutLink extends TestBase {

	@Test
	public void checkAboutLinks() {
		FactorialPage fp = new FactorialPage(driver);

		fp.aboutLink.click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> links = w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("a")));

		Assert.assertTrue(links.size() > 5, "Link count is not greater than 5");
		System.out.println("Total no of links: " + links.size());
		for (WebElement lc : links) {
			System.out.println("Link on About Page: " + lc.getText());
		}

	}

}

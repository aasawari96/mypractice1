package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FactorialPage;

public class Class2_PlaceholderTitleURL extends TestBase {

	@Test
	public void verifyPlaceholderTitleURL() {

		FactorialPage fp = new FactorialPage(driver);

		// Verify the Placeholder in Textbox is = 'Enter an integer'
		Assert.assertEquals(fp.textbox.getDomAttribute("placeholder"), "Enter an integer"); // .getAttribute() method is
																							// deprecated

		// Verify the Title of the page contains = 'Factorial'
		Assert.assertTrue(driver.getTitle().contains("Factorial"));

		// Verify the URL contains = 'https'
		Assert.assertTrue(driver.getCurrentUrl().contains("https"));
	}
}

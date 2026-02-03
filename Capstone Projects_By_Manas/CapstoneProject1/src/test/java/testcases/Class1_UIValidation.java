package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FactorialPage;

public class Class1_UIValidation extends TestBase {

	@Test
	public void verifyUIElements() {

		FactorialPage fp = new FactorialPage(driver);

		Assert.assertTrue(fp.textbox.isDisplayed());
		Assert.assertTrue(fp.calButton.isDisplayed());
		Assert.assertTrue(fp.aboutLink.isDisplayed());
		Assert.assertTrue(fp.termsCondition.isDisplayed());
		Assert.assertTrue(fp.privacy.isDisplayed());

		Assert.assertTrue(fp.textbox.isEnabled());
		Assert.assertTrue(fp.calButton.isEnabled());
	}

}

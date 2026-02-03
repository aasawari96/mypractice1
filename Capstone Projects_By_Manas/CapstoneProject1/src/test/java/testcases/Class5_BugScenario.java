package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FactorialPage;

public class Class5_BugScenario extends TestBase {

	@Test
	public void VerifyNegativeNumberBug() {

		FactorialPage fp = new FactorialPage(driver);

		fp.textbox.sendKeys("-5");
		fp.calButton.click();

		String result = fp.resultDiv.getText();
		Assert.assertTrue(result.isBlank() || result.isEmpty(), "BUG: System is accepting negative interger!");
	}

}

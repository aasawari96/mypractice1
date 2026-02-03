package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FactorialPage;

public class Class3_DataDrivenFactorial extends TestBase {
	@DataProvider(name = "factorialData")
	public Object[][] factorData() {
		return new Object[][] { { 4, "The factorial of 4 is: 24" }, { 5, "The factorial of 5 is: 120" },
				{ 6, "The factorial of 6 is: 720" }, { 7, "The factorial of 7 is: 5040" },
				{ 8, "The factorial of 8 is: 40320" }, { 9, "The factorial of 9 is: 362880" },
				{ 10, "The factorial of 10 is: 3628800" } };
	}

	@Test(dataProvider = "factorialData")
	public void varifyFactorial(int input, String expectedOutput) {

		FactorialPage fp = new FactorialPage(driver);
		// Clear Textbox
		fp.textbox.clear();

		// send input value
		fp.textbox.sendKeys(String.valueOf(input)); // sendkeys() only accepts a String

		// Calculate
		fp.calButton.click();

		// Expected output
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> !fp.resultDiv.getText().trim().isEmpty());

		String result = fp.resultDiv.getText();
		System.out.println("Actual UI Text: [" + result + "]");
//		Assert.assertTrue(result.contains(String.valueOf(expectedOutput)));
		Assert.assertTrue(result.contains(expectedOutput));

	}

}

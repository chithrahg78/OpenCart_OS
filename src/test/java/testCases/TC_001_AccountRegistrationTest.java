package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression", "Master"})
	public void Registration() {
		try {
			logger.info("Starting TC001_AccountRegistrationTest");
			logger.debug("This is a debug log message");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");

			hp.clickRegister();
			logger.info("Clicked on Register link");

			RegistrationPage rp = new RegistrationPage(driver);
			logger.info("Providing Customer details");

			rp.setFirstName(randomStringAlphabets().toUpperCase());
			rp.setLastName(randomStringAlphabets().toUpperCase());
			rp.setEmail(randomStringAlphabets() + "@gmail.com");
			rp.setTelephone(randomStringNumeric());
			String pwd = randomAlphaNumeric();
			rp.setPassword(pwd);
			rp.setConfirmPassword(pwd);
			rp.setPrivacyPolicy();
			rp.clickContinue();
			logger.info("Validating expected message....");
			
			String cnfmsg = rp.getConfirmMessage();
			if (cnfmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed ..");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("** Finished TC001_Account ***");
		// Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");-> hard assert
	}

}

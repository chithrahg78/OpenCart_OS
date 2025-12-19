package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/* Data is valid - login success -Test pass - logout
 * 				 - login failed - Test fail
 * 
 * Data is invalid -login success -Test fail - logout
 * 					login failed - Test pass 
  */
public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriver")

	public void verify_Login_DDT(String email, String password, String exp) {

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.enterEmail(email);
			lp.enterPassword(password);
			lp.clickLogin();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("valid")) // if expected result = valid
			{
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(targetPage);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("invalid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.info("***Finished TC_003_ Login DDT**********");
	}
}

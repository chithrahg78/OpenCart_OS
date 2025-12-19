package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyAccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li[1]/a")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//html//body//nav//div//div[2]//ul//li[2]//ul//li[2]//a")
	WebElement lnkLogin;

	public void clickMyAccount() {
		lnkMyAccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}

}

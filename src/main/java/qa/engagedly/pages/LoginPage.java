package qa.engagedly.pages;

import qa.engagedly.base.BasePage;
import qa.engagedly.utils.Constants;
import qa.engagedly.utils.ElementUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private WebDriver driver;

	// 1. By locators -- OR
	By username = By.name("user[user_name]");
	By password = By.name("user[password]");
	By loginButton = By.xpath("//button[@class='signin-btn'][contains(.,'Sign in')]");


	// 2. create const.. of page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 3. page actions:
	@Step("get login page title....")
	public String getLoginPageTitle()  {
		return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}

	@Step("check sign up link on login page....")
	public boolean verifySignUpLink() {
		elementUtil.waitForElementPresent(loginButton, 5);
		return elementUtil.doIsDisplayed(loginButton);
	}

	@Step("login to app with username: {0} and password: {1}")
	public HomePage doLogin(String username, String password) {
		elementUtil.waitForElementPresent(this.username, 10);
		elementUtil.doSendKeys(this.username, username);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doClick(this.loginButton);

		return new HomePage(driver);
	}

}

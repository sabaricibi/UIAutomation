package qa.engagedly.tests;

import qa.engagedly.base.BaseTest;
import qa.engagedly.utils.Constants;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Epic - 101 : design login page with different features...")
@Story("US - 102 : design basic login page with singup, title and login form...")
public class LoginPageTest extends BaseTest {
	
	@Test(priority = 2)
	@Description("verify Login Page Title Test.....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest() throws InterruptedException {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched...");
	}

	@Test(priority = 1)
	@Description("Verify Sign in Button is Displayed.....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "sing up link is not displayed....");
	}

	@Test(priority = 3)
	@Description("verify Login Test.....")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

}

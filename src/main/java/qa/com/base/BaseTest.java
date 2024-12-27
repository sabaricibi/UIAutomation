package qa.engagedly.base;

import qa.engagedly.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

	public WebDriver driver;

	public qa.engagedly.base.BasePage basePage;
	public LoginPage loginPage;
	public Properties prop;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) {
		System.out.println(browserName);
		basePage = new qa.engagedly.base.BasePage();
		prop = basePage.init_prop();
		prop.setProperty("browser", browserName);
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

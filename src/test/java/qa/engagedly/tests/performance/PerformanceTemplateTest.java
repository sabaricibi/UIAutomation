package qa.engagedly.tests.performance;

import org.testng.annotations.BeforeClass;
import qa.engagedly.base.BasePage;
import qa.engagedly.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import qa.engagedly.pages.HomePage;
import qa.engagedly.pages.LoginPage;
import qa.engagedly.pages.performance.PerformancePage;


public class PerformanceTemplateTest extends BaseTest {
    HomePage homePage;
    PerformancePage performancePage;

    @BeforeClass
    public void performanceSetup() {
        basePage = new BasePage();
        prop = basePage.init_prop();
        driver = basePage.init_driver(prop);
        loginPage = new LoginPage(driver);
        homePage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        performancePage = homePage.gotoPerformance();
    }


    @Test (priority = 1)
    public void gotoTemplatePage(){
        performancePage.gotoTemplate();
        String flag = performancePage.getCurrentSubPage();
        Assert.assertEquals(flag, "template","Problem in navigating to Performance Template Page");
    }

}

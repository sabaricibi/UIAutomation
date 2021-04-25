package qa.engagedly.tests.performance;

import org.testng.annotations.BeforeClass;
import qa.engagedly.base.BaseTest;
import qa.engagedly.pages.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PerformanceTemplateTest extends BaseTest {

    HomePage homePage;

    @BeforeClass
    public void homeSetup() {
        homePage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }


    @Test (priority = 1)
    public void gotoTemplatePage(){
        template = performancePage.gotoTemplate();
        String flag = performancePage.getCurrentSubPage();
        Assert.assertEquals(flag, "template","Problem in navigating to Performance Template Page");
    }

    @Test(priority = 2)
    public void createTemplateTest(){
        template.createTemplate();
        Assert.assertEquals(template.createPopupAppears(),true);
    }

}

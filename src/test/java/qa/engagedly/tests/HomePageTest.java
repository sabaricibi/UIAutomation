package qa.engagedly.tests;

import org.testng.annotations.BeforeClass;
import qa.engagedly.base.BaseTest;
import qa.engagedly.pages.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeClass
    public void homeSetup() {
        homePage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }


    @Test(priority = 1)
    @Description("Closing the Tutorial Popup, if exists")
    public void closeTutorialPopup() {
            homePage.closeTutorialPopupIfExists();
    }


    @Test(priority = 2)
    public void verifyLoggedInUserTest() {
        String loggedInUser = homePage.getLoggedInUser();
        System.out.println("Logged in user is : " + loggedInUser);

        Assert.assertEquals(loggedInUser, prop.getProperty("accountID"), "logged in user is not matched...");
    }

    @Test(priority = 3)
    public void verifyAdminViewIsActive() {
         homePage.gotoAdminView();
         String activeTab = homePage.getActiveTab();
         Assert.assertEquals(activeTab, "adminView", "Problem navigating to Admin");
    }
    @Test(priority = 4)
    public void gotoPerformanceTest(){
        homePage.gotoPage("admin_performance");
        String flag = homePage.getActiveModule();
        Assert.assertEquals(flag, "performance","Problem in navigating to Performance");


    }



}

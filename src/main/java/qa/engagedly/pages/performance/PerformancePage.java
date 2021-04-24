package qa.engagedly.pages.performance;

import qa.engagedly.base.BasePage;
import qa.engagedly.pages.HomePage;
import qa.engagedly.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PerformancePage extends BasePage {
    private WebDriver driver;

    By template = By.xpath("//a[contains(.,'TEMPLATES')]");

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    public void gotoTemplate(){
        elementUtil.waitForElementPresent(this.template,30);
        elementUtil.doClick(this.template);
    }

    public String getCurrentSubPage(){
        String view = null;
        if(elementUtil.hasClass(this.template,"active", 20))
            view = "template";
        else
            view = "null";

        return view;
    }
}

package qa.engagedly.pages.performance;

import qa.engagedly.base.BasePage;
import qa.engagedly.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PerformancePage extends BasePage {
    public static WebDriver driver;

    By template = By.xpath("//a[contains(.,'TEMPLATES')]");
    By overview = By.xpath("//a[contains(.,'DASHBOARD')]");
    By cycle = By.xpath("//a[contains(.,'CYCLES')]");
    By analytics = By.xpath("//a[contains(.,'ANALYTICS')]");
    By manage_review = By.xpath("//a[contains(.,'MANAGE REVIEWS')]");


    public PerformancePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);

    }

    public void gotoPerformanceOverview(){
        elementUtil.waitForElementPresent(this.template,30);
        elementUtil.doClick(this.template);
    }

    public void gotoManageReview(){
        elementUtil.waitForElementPresent(this.template,30);
        elementUtil.doClick(this.template);
    }

    public void gotoAnalytics(){
        elementUtil.waitForElementPresent(this.template,30);
        elementUtil.doClick(this.template);
    }

    public void gotoCycle(){
        elementUtil.waitForElementPresent(this.template,30);
        elementUtil.doClick(this.template);
    }

    public Template gotoTemplate(){
        elementUtil.waitForElementPresent(this.template,30);
        elementUtil.doClick(this.template);
        return new Template(driver);
    }


    public String getCurrentSubPage(){
        String view = null;
        if(elementUtil.hasClass(this.template,"active", 20))
            view = "template";
        else if(elementUtil.hasClass(this.manage_review,"active", 20))
            view = "manage_review";
        else if(elementUtil.hasClass(this.analytics,"active", 20))
            view = "analytics";
        else if(elementUtil.hasClass(this.overview,"active", 20))
            view = "overview";
        else if(elementUtil.hasClass(this.cycle,"active", 20))
            view = "cycle";


        return view;
    }
}

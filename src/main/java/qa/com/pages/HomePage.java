package qa.engagedly.pages;

import qa.engagedly.base.BasePage;
import qa.engagedly.pages.performance.PerformancePage;
import qa.engagedly.utils.Constants;
import qa.engagedly.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	private WebDriver driver;

	By profilePicture = By.xpath("//img[@class='_eng-profile-image']");
	By tutorialPopup = By.xpath("//span[contains(.,'Remind me later')]");
	By adminView = By.id("manageOrgAsideLink");
	By teamView = By.id("myTeamAsideLink");
	By homeView = By.id("myCornerAsideLink");

	By overview = By.xpath("//a[contains(@class,'landing-page')]");

	By performance = By.xpath("//a[contains(@id,'performance')]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}

	public String getHomePageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}

	public String getLoggedInUser() {
		elementUtil.waitForElementPresent(this.profilePicture,30);
		if (elementUtil.doGetAttribute(this.profilePicture, "id",20) != null) {
			System.out.println("Saba" + elementUtil.doGetAttribute(this.profilePicture, "user-id",20));
			return elementUtil.doGetAttribute(this.profilePicture, "user-id",20);
		}
		return null;
	}

	public void closeTutorialPopupIfExists() {
		elementUtil.waitForElementPresent(this.tutorialPopup,30);
		elementUtil.doClick(this.tutorialPopup);
	}

	public void gotoAdminView(){
		elementUtil.waitForElementPresent(this.adminView,30);
		elementUtil.doClick(this.adminView);
	}

	public void gotoTeamView(){
		elementUtil.waitForElementPresent(this.teamView,30);
		elementUtil.doClick(this.teamView);
	}

	public void gotoHomeView(){
		elementUtil.waitForElementPresent(this.homeView,30);
		elementUtil.doClick(this.homeView);
	}

	public PerformancePage gotoPerformance(){
		elementUtil.waitForElementPresent(this.performance,30);
		elementUtil.doClick(this.performance);
		return new PerformancePage(this.driver);
	}

	public void gotoLandingPage(){
		elementUtil.waitForElementPresent(this.overview,30);
		elementUtil.doClick(this.overview);
	}
	public String getActiveTab(){
		String view = null;
		if(elementUtil.hasClass(this.adminView, "active", 20))
			view = "adminView";
		else if(elementUtil.hasClass(this.teamView, "active", 20))
			view = "teamView";
		else if(elementUtil.hasClass(this.homeView, "active", 20))
			view = "homeView";
		return view;
	}

	public String getActiveModule(){
		String view = null;
		if(elementUtil.hasClass(this.performance,"active", 20))
			view = "performance";
		else
			view = "null";

		return view;
	}

	public void gotoPage(String page){
		switch (page){
			case "admin_performance":
				gotoAdminView();
				gotoPerformance();
				break;

			default:
				gotoLandingPage();
				 break;


		}
	}



}

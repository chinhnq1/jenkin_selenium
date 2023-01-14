package pageobject.amazon;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.amazon.SearchPageUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToFirstItem() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_PAGE_TITLE);
		clickToElementByIndex(driver, SearchPageUI.SEARCH_PAGE_TITLE, 0);
	}

}

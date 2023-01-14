package pageUI.amazon;

import org.openqa.selenium.WebDriver;

import pageobject.amazon.HomePageObject;
import pageobject.amazon.ItemPageObject;
import pageobject.amazon.SearchPageObject;

public class PageGenerator {
	private static HomePageObject homePage;
	private static SearchPageObject searchPage;
	private static ItemPageObject itemPage;

	public PageGenerator() {

	}

	public static HomePageObject getHomePage(WebDriver driver) {
		if (homePage == null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;

	}

	public static SearchPageObject getSearchPage(WebDriver driver) {
		if (searchPage == null) {
			searchPage = new SearchPageObject(driver);
		}
		return searchPage;

	}

	public static ItemPageObject getItemPage(WebDriver driver) {
		if (itemPage == null) {
			itemPage = new ItemPageObject(driver);
		}
		return itemPage;

	}

}

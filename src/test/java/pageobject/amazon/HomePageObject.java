package pageobject.amazon;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.amazon.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInDropDownList(String value) {
		selectItemByVisibleText(driver, HomePageUI.DROP_DOWNLIST, value);

	}

	public void sendKeysToSearchTextBox(String value) {
		waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, HomePageUI.SEARCH_TEXTBOX, value);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON);
	}

}

package pageobject.amazon;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.amazon.ItemPageUI;

public class ItemPageObject extends BasePage {
	WebDriver driver;

	public ItemPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductTitle() {
		waitForElementVisible(driver, ItemPageUI.ITEM_TITLE);
		return getTextFromElement(driver, ItemPageUI.ITEM_TITLE);
	}

}

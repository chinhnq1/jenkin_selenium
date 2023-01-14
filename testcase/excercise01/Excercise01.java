package excercise01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.ExcelUtils;
import pageUI.amazon.PageGenerator;
import pageobject.amazon.HomePageObject;
import pageobject.amazon.ItemPageObject;
import pageobject.amazon.SearchPageObject;

public class Excercise01 extends BaseTest {
	WebDriver driver;
	String path = System.getProperty("user.dir");
	Actions action;
	Alert alert;
	HomePageObject homePage;
	SearchPageObject searchPage;
	ItemPageObject itemPage;

	@BeforeClass
	public void beforeClass() {
		driver = getBrowserDriver("chrome", "https://www.amazon.com");
	}

	@Test(dataProvider = "amazon")
	public void TC_01_Amazon(String searchKey, String productTitle) {
		homePage = PageGenerator.getHomePage(driver);
		homePage.selectItemInDropDownList("Books");
		homePage.sendKeysToSearchTextBox(searchKey);
		System.out.println("Book>> " + searchKey);
		homePage.clickToSearchButton();

		searchPage = PageGenerator.getSearchPage(driver);
		searchPage.clickToFirstItem();

		itemPage = PageGenerator.getItemPage(driver);
		Assert.assertEquals(itemPage.getProductTitle(), productTitle);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@DataProvider(name = "amazon")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(path + "\\inputData\\input_data_Amazon.xlsx", "Sheet1");

		return (testObjArray);

	}

}

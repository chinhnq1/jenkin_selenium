package commons;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void refreshCurrentpage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public WebElement getElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public List<WebElement> getElementsByXpath(WebDriver driver, String locator) {
		return driver.findElements(By.xpath(locator));
	}

	public By getLocatorByXpath(WebDriver driver, String locator) {
		return By.xpath(locator);
	}

	protected void clickToElement(WebDriver driver, String locator) {
		getElementByXpath(driver, locator).click();
	}

	protected void clickToElementByIndex(WebDriver driver, String locator, int index) {
		getElementsByXpath(driver, locator).get(index).click();
	}

	protected void sendKeyToElement(WebDriver driver, String locator, String value) {
		getElementByXpath(driver, locator).clear();
		getElementByXpath(driver, locator).sendKeys(value);
	}

	protected String getTextFromElement(WebDriver driver, String locator) {
		return getElementByXpath(driver, locator).getText();
	}

	protected boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElementByXpath(driver, locator).isDisplayed();
	}

	protected boolean isElementEnable(WebDriver driver, String locator) {
		return getElementByXpath(driver, locator).isEnabled();
	}

	protected boolean isElementSelected(WebDriver driver, String locator) {
		return getElementByXpath(driver, locator).isSelected();
	}

	protected WebElement waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(getLocatorByXpath(driver, locator)));
	}

	protected WebElement waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorByXpath(driver, locator)));
	}

	protected Boolean waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getLocatorByXpath(driver, locator)));
	}

	protected WebElement waitForElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.presenceOfElementLocated(getLocatorByXpath(driver, locator)));
	}

	public String getRandomEmail() {
		Random random = new Random();
		return "testing" + random.nextInt(9999) + "@gmail.com";
	}

	protected int getSizeOfElement(WebDriver driver, String locator) {
		return getElementsByXpath(driver, locator).size();
	}

	public void sleepInSecond(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	protected void clickByJsExecutor(WebDriver driver, String locator) {
		jsExcutor = (JavascriptExecutor) driver;
		jsExcutor.executeScript("arguments[0].click();", getElementByXpath(driver, locator));
	}

	public void backToThePage(WebDriver driver) {
		driver.navigate().back();
	}

	public void moveForwardToThePage(WebDriver driver) {
		driver.navigate().forward();
	}

	public Set<Cookie> getAllCookiesOfCurrentPage(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void selectItemByVisibleText(WebDriver driver, String locator, String item) {
		select = new Select(getElementByXpath(driver, locator));
		select.selectByVisibleText(item);
	}

	private JavascriptExecutor jsExcutor;
	private long timeout = 30;
	private WebDriverWait explicitWait;
	private Select select;

}

package com.springernature.fluffy.pages;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage extends AbstractBasePage {
	private final String pageURL = getBaseURL();

	@FindBy(how = How.CSS, using = "#query")
	private WebElement searchTextInput;

	@FindBy(how = How.CSS, using = "#search")
	private WebElement searchButton;

	@FindBy(how = How.CSS, using = "#number-of-search-results-and-search-terms > strong")
	private List<WebElement> searchResult;

	@FindBy(how = How.CSS, using = "#search-options")
	private WebElement searchOptionsButton;

	@FindBy(how = How.CSS, using = "#advanced-search-link")
	private WebElement advancedSearchLink;

	/*
	 * @FindBy(how = How.CSS, using = ".lang > button > div") private WebElement
	 * currentLanguage;
	 */

	@FindBy(how = How.CSS, using = "div.cross-nav.cross-nav--wide > div.lang.flyout > button > span")
	private WebElement clickLanuageEnglish;

	@FindBy(how = How.CSS, using = ".change-language-Deutsch")
	private WebElement changeLanguageDeutsch;

	@FindBy(how = How.XPATH, using = "//h2/a[starts-with(@title ,\"Ethnobotany of\")]")
	private List<WebElement> resultList;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getUrl() {
		return pageURL;
	}

	public HomePage searchFor(String text) {
		if (!searchTextInput.isDisplayed()) {
			fail("Search Text input not found in DOM");
		}
		searchTextInput.sendKeys(text);
		searchButton.click();
		return this;
	}

	private int getNumberOfResults() {
		String resultsStr = searchResult.get(0).getText().replace(",", "");
		return Integer.parseInt(resultsStr);
	}

	public HomePage matchSearchResults() {
		System.out.println("------------------->" + resultList.size());
		assertTrue("FAILED: Expected results per page to be 20 but failed. ", resultList.size() == 20);
		return this;
	}

	public HomePage returnsResults() {
		int numberOfResults = getNumberOfResults();
		assertTrue("FAILED: Expected results but no results were found", numberOfResults > 0);
		return this;
	}

	public HomePage checkNoResultsFound() {
		int numberOfResults = getNumberOfResults();
		assertTrue("FAILED: Expected no result, but some results were found: " + numberOfResults + " results",
				numberOfResults == 0);
		return this;
	}

	public HomePage checkSearchTerm(String term) {
		String actualSearchTerm = searchResult.get(1).getText().replace("'", "");
		assertEquals(term, actualSearchTerm);
		return this;
	}

	public AdvancedSearch navigateToAdvancedSearch() {
		searchOptionsButton.click();
		advancedSearchLink.click();

		return new AdvancedSearch(driver);
	}

	public HomePage changeLanguageDeutsch() {
		clickLanuageEnglish.click();
		changeLanguageDeutsch.click();
		return this;
	}

	public HomePage checkLanguage(String expected) {
		String current = clickLanuageEnglish.getText();
		assertEquals(current, expected);
		return this;
	}

}

package com.springernature.fluffy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.fail;

public class AdvancedSearch extends AbstractBasePage {

    private static final String advancedSearchURL = "/advanced-search";
    private final String pageURL = getBaseURL() + advancedSearchURL;

    @FindBy(how = How.CSS, using = "#all-words")
    private WebElement allWordsTextInput;

    @FindBy(how = How.CSS, using = "#exact-phrase")
    private WebElement exactPhraseTextInput;

    @FindBy(how = How.CSS, using = "#least-words")
    private WebElement oneOfTheWordsTextInput;

    @FindBy(how = How.CSS, using = "#without-words")
    private WebElement withoutWordsTextInput;

    @FindBy(how = How.CSS, using = "#title-is")
    private WebElement titleContainsTextInput;

    @FindBy(how = How.CSS, using = "#author-is")
    private WebElement authorEditorTextInput;

    @FindBy(how = How.CSS, using = "#facet-start-year")
    private WebElement startYearTextInput;

    @FindBy(how = How.CSS, using = "#facet-end-year")
    private WebElement endYearTextInput;

    @FindBy(how = How.CSS, using = "#submit-advanced-search")
    private WebElement advancedSearchButton;

    public AdvancedSearch(WebDriver driver)
    {
        super(driver);
    }

    public String getUrl() {
        return pageURL;
    }

    public AdvancedSearch insertAllWords(String text)
    {
        if(!allWordsTextInput.isDisplayed()){
            fail("The input field is not diplayed");
        }
        allWordsTextInput.sendKeys(text);
        return this;
    }

    public AdvancedSearch insertExactPhrase(String text)
    {
        if(!exactPhraseTextInput.isDisplayed()){
            fail("The input field is not diplayed");
        }
        exactPhraseTextInput.sendKeys(text);
        return this;
    }

    public AdvancedSearch insertAtLeastOneWord(String text)
    {
        if(!oneOfTheWordsTextInput.isDisplayed()){
            fail("The input field is not diplayed");
        }
        oneOfTheWordsTextInput.sendKeys(text);
        return this;
    }

    public AdvancedSearch insertWithoutTheWords(String text)
    {
        if(!withoutWordsTextInput.isDisplayed()){
            fail("The input field is not diplayed");
        }
        withoutWordsTextInput.sendKeys(text);
        return this;
    }

    public AdvancedSearch insertTitleContains(String text)
    {
        if(!titleContainsTextInput.isDisplayed()){
            fail("The input field is not diplayed");
        }
        titleContainsTextInput.sendKeys(text);
        return this;
    }

    public AdvancedSearch insertAuthorEditor(String text)
    {
        if(!authorEditorTextInput.isDisplayed()){
            fail("The input field is not diplayed");
        }
        authorEditorTextInput.sendKeys(text);
        return this;
    }

    public AdvancedSearch insertStartYear(String text)
    {
        if(!startYearTextInput.isDisplayed()){
            fail("The input field is not diplayed");
        }
        startYearTextInput.sendKeys(text);
        return this;
    }

    public AdvancedSearch insertEndYear(String text)
    {
        if(!endYearTextInput.isDisplayed()){
            fail("The input field is not diplayed");
        }
        endYearTextInput.sendKeys(text);
        return this;
    }

    public HomePage clickAdvancedSearchButton()
    {
        advancedSearchButton.click();
        return new HomePage(driver);
    }
}

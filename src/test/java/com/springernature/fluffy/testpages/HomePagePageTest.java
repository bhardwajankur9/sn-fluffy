package com.springernature.fluffy.testpages;


import com.springernature.fluffy.basetest.BaseTest;
import org.junit.*;
import com.springernature.fluffy.pages.HomePage;

public class HomePagePageTest extends BaseTest
{
    private static HomePage homePage;

    @Before
    public void beforeTest()
    {
        homePage = new HomePage(getDriver());
        homePage.open();
    }

    @After
    public void afterTest()
    {
        homePage.close();
    }

    @AfterClass
    public static void afterClass()
    {
        homePage.quit();
    }

    @Test
    public void searchForTextReturnsResults()
    {
        homePage.searchFor("corona virus")
                .returnsResults()
                .checkSearchTerm("corona virus");
    }

    @Test
    public void checkChangeLanguageToDeutsch()
    {
        homePage.changeLanguageDeutsch()
                .checkLanguage("Deutsch");

    }

}

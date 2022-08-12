package com.springernature.fluffy.basetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest
{
    private WebDriver driver;

    @BeforeClass
    public static void setupClass()
    {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        try
        {
            this.driver = new ChromeDriver(options);
        }
        catch (Exception ex)
        {
            throw new RuntimeException("could not create the chrome driver");
        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}

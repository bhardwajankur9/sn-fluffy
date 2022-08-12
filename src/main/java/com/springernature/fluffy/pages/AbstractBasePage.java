package com.springernature.fluffy.pages;

import com.springernature.fluffy.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractBasePage
{
    protected WebDriver driver;
    private final String baseURL = PropertyManager.INSTANCE.getBaseURL();

    public AbstractBasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public abstract String getUrl();

    public AbstractBasePage open()
    {
        driver.get(getUrl());
        return this;
    }

    public String getBaseURL()
    {
        return this.baseURL;
    }

    public void quit()
    {
        driver.quit();
    }

    public void close()
    {
        driver.close();
    }

}

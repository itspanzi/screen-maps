package com.thoughtworks.sample.page;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.driver.Element;
import com.thoughtworks.sample.states.CurrentPageState;
import com.thoughtworks.sample.states.PageName;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @understands The representation of the application home page
 */
public class OnHomePage extends Page {

    public OnHomePage(Browser browser, CurrentPageState currentPageState) {
        super(browser, currentPageState);
    }

    @Override
    protected void open() {
        browser.navigateTo(getUrl());
    }

    @Override
    protected String getUrl() {
        return "/app/home";
    }

    @Override
    protected PageName getPageName() {
        return PageName.HOME_PAGE;
    }

    public String currentlyLoggedInUser() {
        return elementCurrentUser().getText();
    }

    private Element elementCurrentUser() {
        return browser.div("loggedInUser");
    }
}

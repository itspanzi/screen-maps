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

    private static final String URL = "/app/home";

    public OnHomePage(Browser browser, CurrentPageState currentPageState) {
        super(browser, currentPageState);
    }

    @Override
    protected void setCurrentPageState(CurrentPageState currentPageState) {
        currentPageState.onPage(PageName.HOME_PAGE);
    }

    @Override
    protected void open() {
        browser.navigateTo(URL);
    }

    public String currentlyLoggedInUser() {
        return elementCurrentUser().getText();
    }

    private Element elementCurrentUser() {
        return browser.div("loggedInUser");
    }

    public boolean isOnLoginPage() {
        return browser.getUrl().contains(OnLoginPage.URL);
    }
}

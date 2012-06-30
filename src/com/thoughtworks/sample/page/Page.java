package com.thoughtworks.sample.page;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.driver.Element;
import com.thoughtworks.sample.states.CurrentPageState;

/**
 * @understands what it means to be a page in the application
 */
public abstract class Page {
    protected Browser browser;
    protected CurrentPageState currentPageState;

    public Page(Browser browser, CurrentPageState currentPageState) {
        this.currentPageState = currentPageState;
        this.browser = browser;
        open();
        setCurrentPageState(currentPageState);
    }

    protected abstract void setCurrentPageState(CurrentPageState currentPageState);

    protected abstract void open();

    public static void logout(Browser browser) {
        elementLogoutLink(browser).click();
    }

    private static Element elementLogoutLink(Browser browser) {
        return browser.link("logout");
    }
}

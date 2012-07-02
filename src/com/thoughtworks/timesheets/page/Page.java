package com.thoughtworks.timesheets.page;

import com.thoughtworks.timesheets.driver.Browser;
import com.thoughtworks.timesheets.driver.Element;
import com.thoughtworks.timesheets.page.exceptions.IllegalScreenStateException;
import com.thoughtworks.timesheets.states.CurrentPageState;
import com.thoughtworks.timesheets.states.PageName;

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
        currentPageState.onPage(getPageName());
    }

    protected abstract String getUrl();

    protected abstract PageName getPageName();

    protected void open() {
        browser.navigateTo(getUrl());
    }

    public void alreadyOnPageCheck() {
        if (!browser.getUrl().contains(getUrl())) {
            throw new IllegalScreenStateException(getPageName(), getUrl(), browser.getUrl());
        }
    }

    public static void logout(Browser browser) {
        elementLogoutLink(browser).click();
    }

    private static Element elementLogoutLink(Browser browser) {
        return browser.link("logout");
    }
}

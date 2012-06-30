package com.thoughtworks.sample.page;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.driver.Element;
import com.thoughtworks.sample.page.exceptions.IllegalScreenStateException;
import com.thoughtworks.sample.states.CurrentPageState;
import com.thoughtworks.sample.states.PageName;

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

    protected abstract void open();

    protected abstract String getUrl();

    protected abstract PageName getPageName();

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

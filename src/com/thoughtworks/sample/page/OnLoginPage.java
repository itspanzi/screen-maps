package com.thoughtworks.sample.page;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.driver.Element;
import com.thoughtworks.sample.states.CurrentPageState;
import com.thoughtworks.sample.states.Page;

/**
 * @understands The represenation of the login page of the application
 */
public class OnLoginPage {

    private Browser browser;
    private CurrentPageState currentPageState;

    public OnLoginPage(Browser browser, CurrentPageState currentPageState) {
        this.browser = browser;
        this.currentPageState = currentPageState;
        currentPageState.onPage(Page.LOGIN_PAGE);
    }

    public void enterUserNameAndPassword(String username, String password) {
        elementUsername().setText(username);
        elementPassword().setPassword(password);
    }

    private Element elementPassword() {
        return browser.password("password");
    }

    private Element elementUsername() {
        return browser.text("username");
    }

    public OnHomePage submit() {
        elementSubmit().click();
        currentPageState.onPage(Page.HOME_PAGE);
        return new AlreadyOnHomePage(browser, currentPageState);
    }

    private Element elementSubmit() {
        return null;
    }
}
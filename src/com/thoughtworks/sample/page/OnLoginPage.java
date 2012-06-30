package com.thoughtworks.sample.page;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.driver.Element;
import com.thoughtworks.sample.states.CurrentPageState;
import com.thoughtworks.sample.states.PageName;

/**
 * @understands The representation of the login page of the application
 */
public class OnLoginPage extends Page {

    public static final String URL = "/app/login";

    public OnLoginPage(Browser browser, CurrentPageState currentPageState) {
        super(browser, currentPageState);
    }

    @Override
    protected void setCurrentPageState(CurrentPageState currentPageState) {
        currentPageState.onPage(PageName.LOGIN_PAGE);
    }

    @Override
    protected void open() {
        browser.navigateTo(URL);
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
        currentPageState.onPage(PageName.HOME_PAGE);
        return new AlreadyOnHomePage(browser, currentPageState);
    }

    private Element elementSubmit() {
        return browser.submit("submit_login");
    }
}
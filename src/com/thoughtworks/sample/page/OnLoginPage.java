package com.thoughtworks.sample.page;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.driver.Element;
import com.thoughtworks.sample.states.CurrentPageState;
import com.thoughtworks.sample.states.PageName;

/**
 * @understands The representation of the login page of the application
 */
public class OnLoginPage extends Page {

    public OnLoginPage(Browser browser, CurrentPageState currentPageState) {
        super(browser, currentPageState);
    }

    @Override
    protected void open() {
        browser.navigateTo(getUrl());
    }

    @Override
    protected String getUrl() {
        return "/app/login";
    }

    @Override
    protected PageName getPageName() {
        return PageName.LOGIN_PAGE;
    }

    public void enterUserNameAndPassword(String username, String password) {
        elementUsername().setText(username);
        elementPassword().setPassword(password);
    }

    public OnHomePage submit() {
        elementSubmit().click();
        return new AlreadyOnHomePage(browser, currentPageState);
    }

    private Element elementPassword() {
        return browser.password("password");
    }

    private Element elementUsername() {
        return browser.text("username");
    }

    private Element elementSubmit() {
        return browser.submit("submit_login");
    }
}
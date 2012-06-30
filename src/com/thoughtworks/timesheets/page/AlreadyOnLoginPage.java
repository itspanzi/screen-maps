package com.thoughtworks.timesheets.page;

import com.thoughtworks.timesheets.driver.Browser;
import com.thoughtworks.timesheets.states.CurrentPageState;

/**
 * @understands a state where the browser is already pointing to the Login Page. Typically, this is the case if you
 * click a link that takes you to the home page instead of you manually opening the page by entering the URL to the page.
 */
public class AlreadyOnLoginPage extends OnLoginPage {
    public AlreadyOnLoginPage(Browser browser, CurrentPageState currentPageState) {
        super(browser, currentPageState);
        alreadyOnPageCheck();
    }

    @Override
    protected void open() {
        //No op
    }
}

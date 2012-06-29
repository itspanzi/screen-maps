package com.thoughtworks.sample.page;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.driver.Element;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @understands The representation of the application home page
 */
public class OnHomePage {
    protected Browser browser;

    public OnHomePage(Browser browser) {
        this.browser = browser;
    }

    public void assertThatUserIsLoggedIn(String username) {
        assertThat(elementCurrentUser().getText(), is(username));
    }

    private Element elementCurrentUser() {
        return browser.div("loggedInUser");
    }
}

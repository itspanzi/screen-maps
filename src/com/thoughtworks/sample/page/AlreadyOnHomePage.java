package com.thoughtworks.sample.page;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.driver.Element;
import com.thoughtworks.sample.states.CurrentPageState;
import com.thoughtworks.sample.states.Page;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AlreadyOnHomePage extends OnHomePage {

    public AlreadyOnHomePage(Browser browser, CurrentPageState currentPageState) {
        super(browser);
        currentPageState.assertOnPage(Page.HOME_PAGE);
    }

}

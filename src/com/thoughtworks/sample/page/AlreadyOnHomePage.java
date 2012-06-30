package com.thoughtworks.sample.page;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.states.CurrentPageState;
import com.thoughtworks.sample.states.PageName;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AlreadyOnHomePage extends OnHomePage {

    public AlreadyOnHomePage(Browser browser, CurrentPageState currentPageState) {
        super(browser, currentPageState);
    }

    @Override
    protected void open() {
        //no op
    }
}

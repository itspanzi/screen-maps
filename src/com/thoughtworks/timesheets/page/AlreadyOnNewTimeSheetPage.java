package com.thoughtworks.timesheets.page;

import com.thoughtworks.timesheets.driver.Browser;
import com.thoughtworks.timesheets.states.CurrentPageState;

public class AlreadyOnNewTimeSheetPage extends OnNewTimeSheetPage {
    public AlreadyOnNewTimeSheetPage(Browser browser, CurrentPageState currentPageState) {
        super(browser, currentPageState);
        alreadyOnPageCheck();
    }

    @Override
    protected void open() {
        //no op
    }
}

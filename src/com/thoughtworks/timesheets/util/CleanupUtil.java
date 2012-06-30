package com.thoughtworks.timesheets.util;

import com.thoughtworks.timesheets.driver.Browser;
import com.thoughtworks.timesheets.framework.Autowired;
import com.thoughtworks.timesheets.page.Page;

/**
 * @understands how to clean up after each test
 */
public class CleanupUtil {

    private Browser browser;

    @Autowired
    public CleanupUtil(Browser browser) {
        this.browser = browser;
    }

    public void cleanup() {
        Page.logout(browser);
    }
}

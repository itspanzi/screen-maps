package com.thoughtworks.util;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.framework.Autowired;
import com.thoughtworks.sample.page.Page;

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

package com.thoughtworks.timesheets.states;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @understands the currently open application page
 */
public class CurrentPageState {
    private PageName pageName;

    public void onPage(PageName pageName) {
        this.pageName = pageName;
    }

    public void assertOnPage(PageName pageName) {
        assertThat(pageName, is(this.pageName));
    }
}

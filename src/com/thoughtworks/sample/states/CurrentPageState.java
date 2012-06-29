package com.thoughtworks.sample.states;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @understands the currently open application page
 */
public class CurrentPageState {
    private Page page;

    public void onPage(Page page) {
        this.page = page;
    }

    public void assertOnPage(Page page) {
        assertThat(page, is(this.page));
    }
}

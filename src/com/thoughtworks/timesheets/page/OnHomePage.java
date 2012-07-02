package com.thoughtworks.timesheets.page;

import com.thoughtworks.timesheets.driver.Browser;
import com.thoughtworks.timesheets.driver.Element;
import com.thoughtworks.timesheets.states.CurrentPageState;
import com.thoughtworks.timesheets.states.PageName;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @understands The representation of the application home page
 */
public class OnHomePage extends Page {

    public OnHomePage(Browser browser, CurrentPageState currentPageState) {
        super(browser, currentPageState);
    }

    @Override
    protected String getUrl() {
        return "/app/home";
    }

    @Override
    protected PageName getPageName() {
        return PageName.HOME_PAGE;
    }

    public String currentlyLoggedInUser() {
        return elementCurrentUser().getText();
    }

    public String emptyListingMessage() {
        return elementMessagePane().getText();
    }

    public OnNewTimeSheetPage openNewTimeSheetPage() {
        elementAddNewTimeSheetLink().click();
        return new AlreadyOnNewTimeSheetPage(browser, currentPageState);
    }

    public String flashMessage() {
        return elementFlashMessagePane().getText();
    }

    public void assertLatestTimeSheetEntry(String client, String date, String totalHours) {
        assertThat(elementTimeSheetCell(0, client, "Client").exists(), is(true));
        assertThat(elementTimeSheetCell(0, date, "Date").exists(), is(true));
        assertThat(elementTimeSheetCell(0, totalHours, "Total Hours").exists(), is(true));
    }

    private Element elementTimeSheetCell(int rowNumber, String locator, String header) {
        return browser.cell(locator, rowNumber).under(browser.header(header));
    }

    private Element elementCurrentUser() {
        return browser.div("loggedInUser");
    }

    private Element elementMessagePane() {
        return browser.div("empty_message").in(browser.div("listing"));
    }

    private Element elementAddNewTimeSheetLink() {
        return browser.link("Add New Timesheet");
    }

    private Element elementFlashMessagePane() {
        return browser.div("flash");
    }
}

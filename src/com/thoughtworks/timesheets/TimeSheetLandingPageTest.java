package com.thoughtworks.timesheets;

import com.thoughtworks.timesheets.driver.Browser;
import com.thoughtworks.timesheets.framework.Autowired;
import com.thoughtworks.timesheets.page.OnHomePage;
import com.thoughtworks.timesheets.page.OnLoginPage;
import com.thoughtworks.timesheets.page.OnNewTimeSheetPage;
import com.thoughtworks.timesheets.page.Page;
import com.thoughtworks.timesheets.states.CurrentPageState;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TimeSheetLandingPageTest {

    @Autowired private Browser browser;
    @Autowired private CurrentPageState currentPageState;

    @After
    public void tearDown() throws Exception {
        Page.logout(browser);
    }

    @Test
    public void shouldSayThereAreNoEntriesForANewEmployee() throws Exception {
        OnHomePage onHomePage = new OnLoginPage(browser, currentPageState).loginAs("newUser", "password");
        assertThat(onHomePage.emptyListingMessage(), is("There are no time sheet entries found."));
    }

    @Test
    public void shouldCreateANewTimeSheetEntryUsing() {
        OnHomePage homePage = new OnLoginPage(browser, currentPageState).loginAs("username", "password");
        OnNewTimeSheetPage newPage = homePage.openNewTimeSheetPage();
        newPage.enterClientCode("FOO_BAR_CLIENT");
        newPage.enterWeekEnding("23-12-1984");
        newPage.detailsForActivity("Coding");
        newPage.onMonday(8.0);
        newPage.onTuesday(8.0);
        newPage.onWednesday(8.0);
        newPage.onThursday(8.0);
        newPage.onFriday(8.0);
        homePage = newPage.submit();
        assertThat(homePage.flashMessage(), is("Added 1 new time sheet entry"));
        homePage.assertLatestTimeSheetEntry("FOO_BAR_CLIENT", "23-12-1984", "40.0");
    }

    @Test
    public void shouldListTheLast5ExistingTimeSheetEntries() throws Exception {

    }
}

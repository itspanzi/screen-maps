package com.thoughtworks.timesheets;

import com.thoughtworks.timesheets.driver.Browser;
import com.thoughtworks.timesheets.framework.Autowired;
import com.thoughtworks.timesheets.page.AlreadyOnLoginPage;
import com.thoughtworks.timesheets.page.OnHomePage;
import com.thoughtworks.timesheets.page.OnLoginPage;
import com.thoughtworks.timesheets.states.CurrentPageState;
import com.thoughtworks.timesheets.util.CleanupUtil;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class LoginFlowTest {

    @Autowired Browser browser;
    @Autowired CurrentPageState currentPageState;
    @Autowired CleanupUtil cleanupUtil;

    @After
    public void tearDown() throws Exception {
        cleanupUtil.cleanup();
    }

    @Test
    public void shouldBeAbleToLogin() {
        OnLoginPage loginPage = new OnLoginPage(browser, currentPageState);
        loginPage.enterUserNameAndPassword("username", "password");
        OnHomePage homePage = loginPage.submit();
        assertThat(homePage.currentlyLoggedInUser(), is("username"));
    }

    @Test
    public void shouldTakeToLoginPageIfNotLoggedIn() {
        new OnHomePage(browser, currentPageState);
        new AlreadyOnLoginPage(browser, currentPageState);
    }
}

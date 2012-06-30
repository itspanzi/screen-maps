package com.thoughtworks.sample;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.framework.Autowired;
import com.thoughtworks.sample.page.OnHomePage;
import com.thoughtworks.sample.page.OnLoginPage;
import com.thoughtworks.sample.states.CurrentPageState;
import com.thoughtworks.util.CleanupUtil;
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
        OnHomePage onHomePage = new OnHomePage(browser, currentPageState);
        assertThat(onHomePage.isOnLoginPage(), is(true));
    }
}

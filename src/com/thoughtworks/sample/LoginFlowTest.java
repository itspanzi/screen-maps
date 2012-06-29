package com.thoughtworks.sample;

import com.thoughtworks.sample.driver.Browser;
import com.thoughtworks.sample.framework.Autowired;
import com.thoughtworks.sample.page.OnHomePage;
import com.thoughtworks.sample.page.OnLoginPage;
import com.thoughtworks.sample.states.CurrentPageState;
import org.junit.Test;


public class LoginFlowTest {

    @Autowired Browser browser;
    @Autowired CurrentPageState currentPageState;

    @Test
    public void shouldBeAbleToLogin() {
        OnLoginPage loginPage = new OnLoginPage(browser, currentPageState);
        loginPage.enterUserNameAndPassword("username", "password");
        OnHomePage homePage =  loginPage.submit();
        homePage.assertThatUserIsLoggedIn("username");
    }
}

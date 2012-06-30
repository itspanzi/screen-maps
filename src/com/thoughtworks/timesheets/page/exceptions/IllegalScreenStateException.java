package com.thoughtworks.timesheets.page.exceptions;

import com.thoughtworks.timesheets.states.PageName;

/**
 * @understands Representing a state where the browser does not have the expected page open
 */
public class IllegalScreenStateException extends RuntimeException {
    public IllegalScreenStateException(PageName loginPage, String expectedUrl, String actualUrl) {
        super(String.format("Expected to be on '%s' with URL '%s'. Was actually on '%s'.", loginPage, expectedUrl, actualUrl));
    }
}

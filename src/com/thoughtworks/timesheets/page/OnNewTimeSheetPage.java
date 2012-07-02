package com.thoughtworks.timesheets.page;

import com.thoughtworks.timesheets.driver.Browser;
import com.thoughtworks.timesheets.driver.Element;
import com.thoughtworks.timesheets.driver.ElementCollection;
import com.thoughtworks.timesheets.states.CurrentPageState;
import com.thoughtworks.timesheets.states.PageName;

import java.util.List;

public class OnNewTimeSheetPage extends Page {

    private int row = 0;

    public OnNewTimeSheetPage(Browser browser, CurrentPageState currentPageState) {
        super(browser, currentPageState);
    }

    @Override
    protected String getUrl() {
        return "/app/timesheet/new";
    }

    @Override
    protected PageName getPageName() {
        return PageName.NEW_TIME_SHEET_PAGE;
    }

    public void enterClientCode(String code) {
        elementClientCode().setText(code);
    }

    public void enterWeekEnding(String date) {
        elementWeekEnding().setText(date);
    }

    public void detailsForActivity(String activity) {
        List<String> cells = elementActivityCells().values();
        if (cells.contains(activity)) {
            row = cells.indexOf(activity);
        } else {
            addNewActivityRow();
            browser.cell("activity", cells.size()).in(elementActivityTable()).setText(activity);
            row = cells.size() + 1;
        }
    }

    public void onMonday(double hours) {
        elementDayOfWeekExpense(row, "Monday").setText(String.valueOf(hours));
    }

    public void onTuesday(double hours) {
        elementDayOfWeekExpense(row, "Tuesday").setText(String.valueOf(hours));
    }

    public void onWednesday(double hours) {
        elementDayOfWeekExpense(row, "Wednesday").setText(String.valueOf(hours));
    }

    public void onThursday(double hours) {
        elementDayOfWeekExpense(row, "Thursday").setText(String.valueOf(hours));
    }

    public void onFriday(double hours) {
        elementDayOfWeekExpense(row, "Friday").setText(String.valueOf(hours));
    }

    public OnHomePage submit() {
        elementSubmit().click();
        return new AlreadyOnHomePage(browser, currentPageState);
    }

    private Element elementClientCode() {
        return browser.text("client_code");
    }

    private Element elementWeekEnding() {
        return browser.text("week_ending");
    }

    private ElementCollection elementActivityCells() {
        return browser.cells("Title").in(elementActivityTable());
    }

    private Element elementActivityTable() {
        return browser.table("activities_table");
    }

    private Element elementNewActivityLink() {
        return browser.link("Add New Activity");
    }

    private Element elementDayOfWeekExpense(int row, String dayOfWeek) {
        return browser.cell("hours", row).under(browser.header(dayOfWeek));
    }

    private void addNewActivityRow() {
        elementNewActivityLink().click();
    }

    private Element elementSubmit() {
        return browser.submit("Submit Time Sheet");
    }
}

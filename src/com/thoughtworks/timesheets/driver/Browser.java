package com.thoughtworks.timesheets.driver;

import java.util.List;

/**
 * @understands The abstraction of a Browser in a testing driver
 */
public interface Browser {
    void navigateTo(String url);

    String getUrl();

    Element text(String locator);

    Element password(String locator);

    Element div(String locator);

    Element link(String locator);

    Element submit(String locator);

    ElementCollection cells(String locator);

    Element table(String locator);

    Element cell(String locator, int rowNumber);

    Element header(String locator);
}

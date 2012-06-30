package com.thoughtworks.timesheets.driver;

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
}

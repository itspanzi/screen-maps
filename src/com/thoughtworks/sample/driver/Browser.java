package com.thoughtworks.sample.driver;

/**
 * @understands The abstraction of a Browser in a testing driver
 */
public interface Browser {
    Element text(String usernameLocator);

    Element password(String passwordLocator);

    Element div(String locator);
}

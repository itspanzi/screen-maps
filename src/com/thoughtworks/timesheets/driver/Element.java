package com.thoughtworks.timesheets.driver;

/**
 * @understands A UI element which can be interacted with
 */
public interface Element {
    void setText(String text);

    void setPassword(String password);

    void click();

    String getText();

    Element in(Element parent);

    Element under(Element topElement);

    boolean exists();
}

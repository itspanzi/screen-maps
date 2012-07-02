package com.thoughtworks.timesheets.driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @understands a collection of elements
 */
public interface ElementCollection extends Iterable<Element> {
    ElementCollection in(Element parent);

    List<String> values();
}

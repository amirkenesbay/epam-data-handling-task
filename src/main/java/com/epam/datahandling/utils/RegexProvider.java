package com.epam.datahandling.utils;

import java.util.ResourceBundle;

public class RegexProvider {

    public static String get(String key) {
        return ResourceBundle.getBundle("regular_expressions").getString(key);
    }

}

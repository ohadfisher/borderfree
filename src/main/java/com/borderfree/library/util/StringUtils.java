package com.borderfree.library.util;

public class StringUtils {

    public static String standardizeString(String name) {
        name = name.stripLeading().stripTrailing();
        if (name.length() >= 1) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        return name;
    }

}

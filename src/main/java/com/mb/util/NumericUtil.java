package com.mb.util;

public class NumericUtil {

    public static boolean isNumeric(String string) {
        if (string == null || string.equals(""))
            return false;

        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
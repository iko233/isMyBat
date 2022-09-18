package icu.bitchigo.ismybat.util;

import java.util.stream.Stream;

public class StringUtil {
    public static boolean isEmpty(String string) {
        return string == null || string.equals("");
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static String toUpperUnderline(String string) {
        if (isEmpty(string)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isUpperCase(c) && i != 0) {
                sb.append('_');
            }
            sb.append(Character.toUpperCase(c));
        }
        return sb.toString();
    }

    public static String toUpperCase(String string) {
        if (isEmpty(string)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stream.of(string).forEach(sb::append);
        return sb.toString();
    }
}

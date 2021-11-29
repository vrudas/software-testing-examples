package io.testing.tdd;

public class LeftPad {
    public static String leftPad(String str, int spacesCount) {
        if (str == null) {
            return "";
        }

        return " ".repeat(Math.max(0, spacesCount)) + str;
    }
}

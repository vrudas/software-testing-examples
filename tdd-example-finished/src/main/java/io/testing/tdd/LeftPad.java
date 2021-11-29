package io.testing.tdd;

/**
 * Problem described in article
 *
 * <a href="https://medium.com/@laravelfeed/how-one-developer-just-broke-node-babel-and-thousands-of-projects-in-11-lines-of-javascript-ddb6844772a8">How one developer just broke Node, Babel and thousands of projects in 11 lines of JavaScript</a>
 */
public class LeftPad {
    public static String leftPad(String str, int spacesCount) {
        if (str == null) {
            return "";
        }

        return " ".repeat(Math.max(0, spacesCount)) + str;
    }
}

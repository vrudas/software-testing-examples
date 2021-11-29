package io.testing.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeftPadTest {

    @Test
    void empty_string_returned_for_null_input() {
        String actualString = LeftPad.leftPad(null, 0);
        assertEquals("", actualString);
    }

    @Test
    void empty_string_returned_for_empty_input() {
        String actualString = LeftPad.leftPad("", 0);
        assertEquals("", actualString);
    }

    @Test
    void spaces_not_prepended_for_0_spaces_count() {
        String actualString = LeftPad.leftPad("str", 0);
        assertEquals("str", actualString);
    }

    @Test
    void spaces_not_prepended_for_negative_spaces_count() {
        String actualString = LeftPad.leftPad("str", -1);
        assertEquals("str", actualString);
    }

    @Test
    void spaces_not_prepended_for_1_spaces_count() {
        String actualString = LeftPad.leftPad("str", 1);
        assertEquals(" str", actualString);
    }

}

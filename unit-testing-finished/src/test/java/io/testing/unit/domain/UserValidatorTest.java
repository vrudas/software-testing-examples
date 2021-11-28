package io.testing.unit.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    private UserValidator userValidator;

    @BeforeEach
    void setUp() {
        userValidator = new UserValidator();
    }

    @Test
    void validation_fails_for_null_email() {
        assertThrows(
            IllegalArgumentException.class,
            () -> userValidator.validate(null, "password")
        );
    }

    @Test
    void validation_fails_for_null_password() {
        assertThrows(
            IllegalArgumentException.class,
            () -> userValidator.validate("email", null)
        );
    }

    @Test
    void validation_fails_for_empty_email() {
        assertThrows(
            IllegalArgumentException.class,
            () -> userValidator.validate("", "password")
        );
    }

    @Test
    void validation_fails_for_empty_password() {
        assertThrows(
            IllegalArgumentException.class,
            () -> userValidator.validate("email", "")
        );
    }

    @Test
    void validation_fails_for_email_without_AT_symbol() {
        assertThrows(
            IllegalArgumentException.class,
            () -> userValidator.validate("email", "pass")
        );
    }

    @Test
    void validation_fails_for_password_with_length_less_than_required() {
        assertThrows(
            IllegalArgumentException.class,
            () -> userValidator.validate("test@email.com", "pass")
        );
    }
}
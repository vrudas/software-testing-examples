package io.testing.unit;

public class UserValidator {

    private static final String AT_SYMBOL = "@";
    private static final int MIN_PASSWORD_LENGTH = 6;

    void validate(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Empty input email or password");
        }

        if (!email.contains(AT_SYMBOL)) {
            throw new IllegalArgumentException(
                String.format(
                    "Email should contain '%s' symbol, but got %s",
                    AT_SYMBOL,
                    email
                )
            );
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException(
                String.format(
                    "Password length is %d but minimum amount is %d",
                    password.length(),
                    MIN_PASSWORD_LENGTH
                )
            );
        }
    }
}

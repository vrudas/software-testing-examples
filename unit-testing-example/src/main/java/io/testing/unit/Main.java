package io.testing.unit;

import io.testing.unit.domain.User;
import io.testing.unit.domain.UserService;

public class Main {

    public static void main(String[] args) {
        var userService = new UserService();

        User user = userService.createUser(
            "user@email.com",
            "password"
        );

        System.out.println("user = " + user);
    }
}

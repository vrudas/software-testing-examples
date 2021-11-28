package io.testing.unit;

import io.testing.unit.domain.User;
import io.testing.unit.domain.UserService;
import io.testing.unit.domain.UserValidator;
import io.testing.unit.random.UserIdGenerator;
import io.testing.unit.storage.UserRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var userService = new UserService(
            new UserValidator(),
            new UserRepository(),
            new UserIdGenerator()
        );

        try (var scanner = new Scanner(System.in)) {
            System.out.println("User email:");
            String email = scanner.nextLine();

            System.out.println("User password:");
            String password = scanner.nextLine();

            User user = userService.createUser(
                email,
                password
            );

            System.out.println("user = " + user);
        }
    }
}

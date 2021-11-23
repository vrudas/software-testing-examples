package io.testing.unit;

public class Main {

    public static void main(String[] args) {
        var userService = new UserService(
            new UserValidator(),
            new UserRepository()
        );

        User user = userService.createUser(
            "user@email.com",
            "password"
        );

        System.out.println("user = " + user);
    }
}

package io.testing.unit;

class UserRepository {

    public User saveUser(String email, String password) {
        System.out.printf("User with email: %s was created%n", email);
        return new User(email, password);
    }

}

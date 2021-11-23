package io.testing.unit.domain;

import io.testing.unit.storage.UserRepository;

@SuppressWarnings({"java:S2142"})
public class UserService {

    private UserValidator userValidator = new UserValidator();
    private UserRepository userRepository = new UserRepository();

    public User createUser(
        String email,
        String password
    ) {
        userValidator.validate(email, password);

        var user = new User(email, password);

        try {
            userRepository.saveUser(user);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to save user: " + user, e);
        }

        return user;
    }
}

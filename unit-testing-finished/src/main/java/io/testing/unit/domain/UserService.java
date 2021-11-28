package io.testing.unit.domain;

import io.testing.unit.random.UserIdGenerator;
import io.testing.unit.storage.UserRepository;

@SuppressWarnings({"ClassCanBeRecord", "java:S2142"})
public class UserService {

    private final UserValidator userValidator;
    private final UserRepository userRepository;
    private final UserIdGenerator userIdGenerator;

    public UserService(
        UserValidator userValidator,
        UserRepository userRepository,
        UserIdGenerator userIdGenerator
    ) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
        this.userIdGenerator = userIdGenerator;
    }

    public User createUser(
        String email,
        String password
    ) {
        userValidator.validate(email, password);

        var user = new User(userIdGenerator.generateId(), email, password);

        try {
            userRepository.saveUser(user);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to save user: " + user, e);
        }

        return user;
    }
}

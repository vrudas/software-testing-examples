package io.testing.unit;

class UserService {

    private final UserValidator userValidator;
    private final UserRepository userRepository;

    UserService(
        UserValidator userValidator,
        UserRepository userRepository
    ) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
    }

    User createUser(
        String email,
        String password
    ) {
        userValidator.validate(email, password);
        return userRepository.saveUser(email, password);
    }
}

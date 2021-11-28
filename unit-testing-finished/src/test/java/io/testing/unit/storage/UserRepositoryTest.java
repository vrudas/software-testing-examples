package io.testing.unit.storage;

import io.testing.unit.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    @DisplayName("user saved without error")
    void user_saved_without_error() {
        var user = new User("id", "email", "password");
        assertDoesNotThrow(() -> userRepository.saveUser(user));
    }

}
package io.testing.unit.domain;

import io.testing.unit.random.UserIdGenerator;
import io.testing.unit.storage.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserValidator userValidator;

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserIdGenerator userIdGenerator;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(
            userValidator,
            userRepository,
            userIdGenerator
        );
    }

    @Test
    void user_created_without_errors() {
        var expectedUser = new User("id", "email", "password");

        when(userIdGenerator.generateId()).thenReturn("id");

        User actualUser = userService.createUser("email", "password");

        assertEquals(expectedUser, actualUser);
    }

    @Test
    void failed_to_create_user_because_of_error_during_save() throws Exception {
        doThrow(Exception.class).when(userRepository).saveUser(any(User.class));

        assertThrows(
            IllegalStateException.class,
            () -> userService.createUser("email", "password")
        );
    }

    @Test
    void verify_that_user_input_was_validated() {
        userService.createUser("email", "password");

        verify(userValidator).validate(eq("email"), eq("password"));
    }

    @Test
    void verify_that_user_input_was_validated_without_using_matchers() {
        userService.createUser("email", "password");

        verify(userValidator).validate("email", "password");
    }

    @Test
    void verify_that_user_input_was_validated_with_any_input_values() {
        userService.createUser("email", "password");

        verify(userValidator).validate(anyString(), anyString());
    }

    @Test
    void verify_that_user_input_was_validated_with_any_email_but_exact_password() {
        userService.createUser("email", "pass");

        verify(userValidator).validate(anyString(), eq("pass"));
    }


}
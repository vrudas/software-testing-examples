package io.testing.unit.random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserIdGeneratorTest {

    private UserIdGenerator userIdGenerator;

    @BeforeEach
    void setUp() {
        userIdGenerator = new UserIdGenerator();
    }

    @Test
    void generated_not_empty_user_id() {
        String userId = userIdGenerator.generateId();
        assertFalse(userId.isEmpty());
    }
}
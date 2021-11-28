package io.testing.unit.random;

import java.util.UUID;

public class UserIdGenerator {

    /**
     * Write test that checks returned id is not empty
     */
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}

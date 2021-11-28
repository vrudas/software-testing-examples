package io.testing.unit.storage;

import io.testing.unit.domain.User;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("java:S112")
public class UserRepository {

    public void saveUser(User user) throws Exception {
        TimeUnit.SECONDS.sleep(5);
        System.out.printf("User was saved: %s%n", user);
    }

}

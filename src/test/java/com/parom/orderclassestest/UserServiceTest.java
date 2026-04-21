package com.parom.orderclassestest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(2)
public class UserServiceTest {
    @BeforeAll
    static void setup() {
        System.out.println("Test methods related to User");
    }

    @Test
    void testCreateUser_whenFirstNameIsMissing_throwsUserServiceException() {
    }
}

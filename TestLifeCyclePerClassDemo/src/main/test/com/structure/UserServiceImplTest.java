package com.structure;

import com.structure.io.UsersDatabase;
import com.structure.io.UsersDatabaseMapImpl;
import com.structure.service.UserService;
import com.structure.service.UserServiceImpl;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {

    UsersDatabase usersDatabase;
    UserService userService;

    String createUserId = "";

    @BeforeAll
    void setup() {
        // Create & initialize database
        usersDatabase = new UsersDatabaseMapImpl();
        usersDatabase.init();
        userService = new UserServiceImpl(usersDatabase);
    }

    @AfterAll
    void cleanup() {
        // Close connection
        // Delete database
        usersDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {
        // Arrange
        Map<String, String> user = new HashMap<>();
        user.put("firstName", "Evgen");
        user.put("lastName", "Parom");

        // Act
        createUserId = userService.createUser(user);

        // Assert
        assertNotNull(createUserId, "User id should not be null");
    }


    @Test
    @Order(2)
    @DisplayName("Update user works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {
        // Arrange
        Map<String, String> newUserDetails = new HashMap<>();
        newUserDetails.put("firstName", "John");
        newUserDetails.put("lastName", "Parom");

        // Act
        Map updatedUserDetails = userService.updateUser(createUserId, newUserDetails);

        // Arrange
        assertEquals(
                newUserDetails.get("firstName"),
                updatedUserDetails.get("firstName"),
                "Returned value of user's first name is incorrect"
        );
        assertEquals(
                newUserDetails.get("lastName"),
                updatedUserDetails.get("lastName"),
                "Returned value of user's last name is incorrect"
        );
    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUserDetails_whenProvidedWithValidUserId_returnsUserDetails() {
        // Act
        Map userDetails = userService.getUserDetails(createUserId);

        // Assert
        assertNotNull(userDetails, "User details should not be null");
        assertEquals(
                createUserId,
                userDetails.get("userId"),
                "Returned user details contains incorrect user id");
    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsUserDetails() {
        // Act
        userService.deleteUser(createUserId);

        // Assert
        assertNull(
                userService.getUserDetails(createUserId),
                "User should not be found"
        );
    }

}

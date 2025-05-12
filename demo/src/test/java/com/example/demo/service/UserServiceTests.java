package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.FakeRepoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UserServiceTests {

    private FakeRepoInterface fakeRepo; // mock of the FakeRepoInterface
    private UserServiceImpl userService; // service class to be tested

    @BeforeEach
    void setUp() {
        // Create a mock FakeRepoInterface before each test
        fakeRepo = mock(FakeRepoInterface.class);

        // Inject the mock into UserServiceImpl (constructor injection)
        userService = new UserServiceImpl(fakeRepo);
    }

    @Test
    void testAddUser() {
        // Mock the insertUser method to return "John" when called with any long ID, "John", and "Doe"
        when(fakeRepo.insertUser(anyLong(), eq("John"), eq("Doe"))).thenReturn("John");

        // Call the service method
        userService.addUser("John", "Doe");

        // Verify that insertUser was called once with expected parameters
        verify(fakeRepo, times(1)).insertUser(anyLong(), eq("John"), eq("Doe"));
    }

    @Test
    void testRemoveUser() {
        // Mock the deleteUser method to return "John" when called with ID 1
        when(fakeRepo.deleteUser(1L)).thenReturn("John");

        // Call the service method
        userService.removeUser(1L);

        // Verify that deleteUser was called once with ID 1
        verify(fakeRepo).deleteUser(1L);
    }

    @Test
    void testGetUser() {
        // Mock findUserById to return a User object when called with ID 1
        when(fakeRepo.findUserById(1L)).thenReturn(new User(1L, "Jane", "Smith"));

        // Call the service method
        userService.getUser(1L);

        // Verify that findUserById was called once with ID 1
        verify(fakeRepo).findUserById(1L);
    }
}
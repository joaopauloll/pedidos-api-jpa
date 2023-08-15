package com.jp.springbootH2.controllers;

import com.jp.springbootH2.entities.User;
import com.jp.springbootH2.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class UserControllerTests {

    private AutoCloseable closeable;
    private User mockUser1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    private User mockUser2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void close() throws Exception {
        closeable.close();
    }

    @Test
    public void testGetAll() {
        List<User> mockUsers = new ArrayList<User>();
        mockUsers.add(mockUser1);
        mockUsers.add(mockUser2);

        when(userService.findAll()).thenReturn(mockUsers);

        ResponseEntity<List<User>> responseEntity = userController.getAll();

        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals(mockUsers, responseEntity.getBody());
    }

    @Test
    public void testGetById() {
        Long userId = 1L;

        when(userService.findById(userId)).thenReturn(mockUser1);

        ResponseEntity<User> responseEntity = userController.getById(userId);

        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals(mockUser1, responseEntity.getBody());
    }

    @Test
    public void testCreate() {
        when(userService.create(mockUser1)).thenReturn(mockUser1);

        ResponseEntity<User> responseEntity = userController.create(mockUser1);

        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals(mockUser1, responseEntity.getBody());

    }

    @Test
    public void testUpdate() {
        Long userId = 1L;
        User mockUser = mockUser1;

        when(userService.update(userId, mockUser)).thenReturn(mockUser);

        ResponseEntity<User> responseEntity = userController.update(userId, mockUser);

        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals(mockUser, responseEntity.getBody());
    }

    @Test
    public void testDelete() {
        Long userId = 9L;

        // Configuring mock service's delete method to do nothing (void method)
        doNothing().when(userService).delete(userId);

        ResponseEntity<Void> responseEntity = userController.delete(userId);

        assertEquals(204, responseEntity.getStatusCode().value());
    }
}

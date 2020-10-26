package com.billreminder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserTest {

    private User user = new User(1L,
            "Name",
            "Surname",
            "Email",
            "Password",
            LocalDateTime.of(2020, 1, 1, 12, 0));

    @Test
    public void testGetId() {
        //Given user
        //When
        long id = user.getId();
        //Then
        assertEquals(1L, id);
    }

    @Test
    public void testGetName() {
        //Given user
        //When
        String name = user.getName();
        //Then
        assertEquals("Name", name);
    }

    @Test
    public void testGetSurname() {
        //Given user
        //When
        String surname = user.getSurname();
        //Then
        assertEquals("Surname", surname);
    }

    @Test
    public void testGetEmail() {
        //Given user
        //When
        String email = user.getEmail();
        //Then
        assertEquals("Email", email);
    }

    @Test
    public void testGetPassword() {
        //Given user
        //When
        String password = user.getPassword();
        //Then
        assertEquals("Password", password);
    }

    @Test
    public void testGetSignUpDate() {
        //Given user
        //When
        LocalDateTime signUpDate = user.getSignUpDate();
        //Then
        assertEquals(LocalDateTime.of(2020, 1, 1, 12, 0), signUpDate);
    }
}
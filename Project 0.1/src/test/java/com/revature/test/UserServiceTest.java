package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.revature.daos.UserDao;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserServiceTest {

	private static UserService us = new UserService();
	private static UserDao ud = new UserDao();
	
 @Test 
    void register() {
	 	User user = new User("Name", "Username", "Password", 0);
        int before = us.register(user);
        int after = 17;
        assertEquals(before, after);
    }
 
 @Test 
    void Login() {
        User actual = us.Login("3456", "3456");
        assertAll(() -> assertEquals(8, actual.getId()),
       		 () -> assertEquals("ThreeFour", actual.getName()),
             () -> assertEquals("3456", actual.getUsername()),
           	 () -> assertEquals("CUSTOMER", actual.getRole())
        );
        		
    }
 
 @AfterAll
	public static void tearDown() {

		ud.delete(17);
	}
}

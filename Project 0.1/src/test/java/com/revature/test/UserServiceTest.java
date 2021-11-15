package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.daos.UserDao;
import com.revature.models.User;
import com.revature.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

//	private static UserService us = new UserService();
//	private static UserDao ud = new UserDao();

	@Mock
	private UserDao ud;
	
	@InjectMocks
	private UserService us;
	
	@Test
	public void addEmployeeTestValid() {
		
		Mockito.when(ud.add(new User("test","test","test","test",0))).thenReturn(29);
		
		int expected = 29;   //new User(29,"test","test","test","test",0);
		int p = us.register(new User("test","test","test","test",0));
		assertEquals(expected, p);
	}	
	
	
	
	
// @Test 
//    void register() {
//	 	User user = new User("Name", "Username", "Password", 0);
//        int before = us.register(user);
//        int after = 17;
//        assertEquals(before, after);
//    }
 
// @Test 
//    void Login() {
//        User actual = us.Login("3456", "3456");
//        assertAll(() -> assertEquals(8, actual.getId()),
//       		 () -> assertEquals("ThreeFour", actual.getName()),
//             () -> assertEquals("3456", actual.getUsername()),
//           	 () -> assertEquals("CUSTOMER", actual.getRole())
//        );
//        		
//    }
 
// @AfterAll
//	public static void tearDown() {
//
//		ud.delete(17);
//	}
}

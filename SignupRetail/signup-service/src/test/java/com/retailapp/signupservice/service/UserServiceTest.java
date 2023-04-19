package com.retailapp.signupservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.retailapp.signupservice.POJO.User;
import com.retailapp.signupservice.dao.UserDao;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)

public class UserServiceTest {
	
	
	private UserServiceImpl userServiceImpl;
	
	private static User user;
	private UserService userService;
	
	@Mock 
	private UserDao userDao;
@BeforeEach
public void setup()
{
	MockitoAnnotations.initMocks(this);
	userServiceImpl = new UserServiceImpl();
}
	@BeforeAll
	public static void init(){
		 user = new User((int) 1L,"Ans","12345678","ans@ans.com","ans");
	}
		@Test
		void signUp() {
			HashSet userData = new HashSet();
			((Collection) userData).add(user);
		when(userServiceImpl.signUp(null)).thenReturn(null);
		
		ResponseEntity<String> user =userServiceImpl.signUp(null);
		  
		assertEquals(((Collection) user).size(),1);
		((UserServiceTest) verify(userDao, times(1))).signUp();
	}
	

}

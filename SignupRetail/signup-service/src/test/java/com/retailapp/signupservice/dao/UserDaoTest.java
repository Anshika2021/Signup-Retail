package com.retailapp.signupservice.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailapp.signupservice.POJO.User;

@RunWith(SpringRunner.class)
	@DataJpaTest
	public class UserDaoTest {

	    @Autowired
	    private UserDao userDao;

	    @Test
	    public void testFindByEmailId() {
	        // create a user
	        User user = new User();
	        user.setEmail("test@example.com");
	        userDao.save(user);

	        // find the user by email
	        User foundUser = userDao.findByEmailId("test@example.com");

	        // assert that the user was found
	        assertNotNull(foundUser);
	        assertEquals(user.getEmail(), foundUser.getEmail());
	    }
	}



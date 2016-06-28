package com.example;

import com.example.Entities.User;
import com.example.services.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RegistrationFormSpringApplication.class)
@WebAppConfiguration
public class RegistrationFormSpringApplicationTests {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Autowired
    UserRepository users;

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setUsername("Alice");
        user.setAddress("17 Princess St");
        user.setEmail("alice@gmail.com");

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(user);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                        .content(json)
                        .contentType("application/json")
        );
        Assert.assertTrue(users.count() == 1);
    }
}

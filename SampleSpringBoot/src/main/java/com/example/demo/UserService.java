package com.example.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    @LogExecution
    public User createNewUser(User userToCreate) {

        // business logics
        User user = new User(userToCreate.getName(), userToCreate.getField());

        logger.info("user created successfully");

        return user;
    }
}
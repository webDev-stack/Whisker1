package com.jdbc.demo;
import java.sql.SQLException;
import java.util.List;

interface IUserDAO {
        void addUser(User user);
        void updateUser(User user);
        void deleteUser(int userId);
        User getUserById(int userId);
        List<User> getAllUsers();
}


package com.user_manager.bo;

import com.user_manager.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IUserBO {
    void insertUser(User user) throws SQLException;

     User selectUser(int id);

     List<User> selectAllUsers();

     boolean deleteUser(int id) throws SQLException;

   boolean updateUser(User user) throws SQLException;

   List<User> getUserByCountry(String country);
    List<User> sortByName();

    void   addUserTransaction();
}

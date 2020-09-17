package com.user_manager.bo;

import com.user_manager.dao.IUserDAO;
import com.user_manager.dao.UserDAO;
import com.user_manager.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class UserBO implements IUserBO {
    private IUserDAO iUserDAO =new UserDAO();
    @Override
    public void insertUser(User user) throws SQLException {
         iUserDAO.insertUser(user);
    }
    @Override
    public boolean deleteUser(int id) throws SQLException {
        return iUserDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return iUserDAO.updateUser(user);
    }
    @Override
    public List<User> selectAllUsers() {
        return iUserDAO.selectAllUsers();
    }

    @Override
    public User selectUser(int id) {
        return iUserDAO.selectUser(id);
    }


    @Override
    public List<User> getUserByCountry(String country) {
        return iUserDAO.getUserByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return iUserDAO.sortByName();
    }


}

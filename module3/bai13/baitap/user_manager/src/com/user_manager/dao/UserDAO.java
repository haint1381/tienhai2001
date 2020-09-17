package com.user_manager.dao;

import com.user_manager.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserDAO implements IUserDAO {

    private static final String INSERT_USERS_SQL = "INSERT INTO users   (name, email, country) VALUES  (?, ?, ?);";
    private static final String SELECT_USER_BY_COUNTRY = "select* from users where country like ?;";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "Call select_all_users()";
    private static final String DELETE_USERS_SQL = "Call delete_users(?)";
    private static final String UPDATE_USERS_SQL = "Call update_users(?,?,?,?)";
    private static final String SORT_USERS_SQL = "select* from  users order by name asc;";

    public static DBConnection dbConnection =new DBConnection();



    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();

        try (
                Connection connection = dbConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_USERS);
             ) {
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }




    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (
                Connection connection = dbConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(DELETE_USERS_SQL);)
        {
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }



    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = dbConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(UPDATE_USERS_SQL);) {
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            callableStatement.setInt(1, user.getId());
            rowUpdated = callableStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }




    @Override
    public List<User> getUserByCountry(String country) {
        List<User> users1 = new ArrayList<>();
        try (
             Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY))
        {
            preparedStatement.setString(1, "%" + country + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country1 = rs.getString("country");
                users1.add(new User(id, name, email, country1));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users1;
    }

    @Override
    public List<User> sortByName() {
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = dbConnection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }


    @Override
    public void addUserTransaction(User user, int id,int user_id ,String name) {
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement =null;
        try{
            if(connection!=null){
                connection.setAutoCommit(false);
                preparedStatement=connection.prepareStatement("insert into users values (?,?,?,?)");
                preparedStatement.setInt(1,user.getId());
                preparedStatement.setString(2,user.getName());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getCountry());
                preparedStatement.executeUpdate();

                preparedStatement=connection.prepareStatement("insert into users_1 values (?,?,?)");
                preparedStatement.setInt(1,id);
                preparedStatement.setInt(2,user_id);
                preparedStatement.setString(3,name);
                preparedStatement.executeUpdate();
                connection.commit();
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = dbConnection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }


        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
}

package com.codegym.dao;

import com.codegym.model.Premises;
import com.codegym.model.RentalSpaceManagement;
import com.codegym.model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalSpaceManagementDAO implements IRentalSpaceManagementDAO {
    private static final String SELECT_ALL="select* from rental_space_management;";
    private static final String SELECT_PREMISES="select* from rental_space_management where type_of_premises in (?);";
    private static final String SELECT_FLOORS="select* from rental_space_management where floors in (?);";
    private static final String SELECT_PRICE="select* from rental_space_management where price in (?);";
    private static final String INSERT_SQL ="insert into rental_space_management(id,status_name,acreage,floors,type_of_premises,price,start_day,end_date) values (?,?,?,?,?,?,?,?)";
    private static final String DELETE_SQL ="delete from rental_space_management where id = ?;";
    private static final String SELECT_SQL ="select* from rental_space_management where floors =? and price = ? and type_of_premises=?";
    @Override
    public List<RentalSpaceManagement> findAll() {
        List<RentalSpaceManagement> rentalSpaceManagementList =new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(SELECT_ALL);
                resultSet=statement.executeQuery();
                while ( resultSet.next() ){
                    String id=resultSet.getString("id");
                    String statusName=resultSet.getString("status_name");
                    String acreage=  resultSet.getString("acreage");
                    String floors=  resultSet.getString("floors");
                    String typeOfPremises=  resultSet.getString("type_of_premises");
                    String price=  resultSet.getString("price");
                    String startDay=  resultSet.getString("start_day");
                    String endDate=  resultSet.getString("end_date");
                    rentalSpaceManagementList.add(new RentalSpaceManagement(id,statusName,acreage,floors,typeOfPremises,price,startDay,endDate));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return rentalSpaceManagementList;
    }


    @Override
    public void create(RentalSpaceManagement rentalSpaceManagement) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(INSERT_SQL);
                statement.setString(1,rentalSpaceManagement.getId());
                statement.setString(2,rentalSpaceManagement.getStatusName());
                statement.setString(3,rentalSpaceManagement.getAcreage());
                statement.setString(4,rentalSpaceManagement.getFloors());
                statement.setString(5,rentalSpaceManagement.getTypeOfPremises());
                statement.setString(6,rentalSpaceManagement.getPrice());
                statement.setString(7,rentalSpaceManagement.getStartDay());
                statement.setString(8,rentalSpaceManagement.getEndDate());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public RentalSpaceManagement findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<RentalSpaceManagement> findByPremises(String name) throws SQLException {
        List<RentalSpaceManagement> rentalSpaceManagementList = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PREMISES))
        {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String id=resultSet.getString("id");
                String statusName=resultSet.getString("status_name");
                String acreage=  resultSet.getString("acreage");
                String floors=  resultSet.getString("floors");
                String typeOfPremises=  resultSet.getString("type_of_premises");
                String price=  resultSet.getString("price");
                String startDay=  resultSet.getString("start_day");
                String endDate=  resultSet.getString("end_date");
                rentalSpaceManagementList.add(new RentalSpaceManagement(id,statusName,acreage,floors,typeOfPremises,price,startDay,endDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rentalSpaceManagementList;
    }

    @Override
    public List<RentalSpaceManagement> findByFloors(String name) throws SQLException {
        List<RentalSpaceManagement> rentalSpaceManagementList = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FLOORS))
        {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String id=resultSet.getString("id");
                String statusName=resultSet.getString("status_name");
                String acreage=  resultSet.getString("acreage");
                String floors=  resultSet.getString("floors");
                String typeOfPremises=  resultSet.getString("type_of_premises");
                String price=  resultSet.getString("price");
                String startDay=  resultSet.getString("start_day");
                String endDate=  resultSet.getString("end_date");
                rentalSpaceManagementList.add(new RentalSpaceManagement(id,statusName,acreage,floors,typeOfPremises,price,startDay,endDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rentalSpaceManagementList;
    }

    @Override
    public List<RentalSpaceManagement> findByPrice(String name) throws SQLException {
        List<RentalSpaceManagement> rentalSpaceManagementList = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRICE))
        {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String id=resultSet.getString("id");
                String statusName=resultSet.getString("status_name");
                String acreage=  resultSet.getString("acreage");
                String floors=  resultSet.getString("floors");
                String typeOfPremises=  resultSet.getString("type_of_premises");
                String price=  resultSet.getString("price");
                String startDay=  resultSet.getString("start_day");
                String endDate=  resultSet.getString("end_date");
                rentalSpaceManagementList.add(new RentalSpaceManagement(id,statusName,acreage,floors,typeOfPremises,price,startDay,endDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rentalSpaceManagementList;
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
}

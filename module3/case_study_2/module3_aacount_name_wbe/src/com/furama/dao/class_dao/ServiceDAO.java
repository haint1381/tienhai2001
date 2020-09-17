package com.furama.dao.class_dao;

import com.furama.dao.DBConnection;
import com.furama.dao.interface_dao.IServiceDAO;
import com.furama.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO implements IServiceDAO {
    private static final String SELECT_ALL_USERS ="select* from service";
    private static final String INSERT_USERS_SQL =
            "insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id ,service_type_id,standard_room ,description_other_convenience,pool_area,number_of_floors) values (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String DELETE_SERVICE_SQL = "delete from service where service_id = ?;";
    private static final String UPDATE_SERVICE_SQL = "update service set service_name=?,service_area=?,service_cost=?,service_max_people=?,rent_type_id =?,service_type_id=?,standard_room =?,description_other_convenience=?,pool_area=?,number_of_floors=? where service_id =?";
    private static final String SELECT_SERVICE_BY_ID = "select* from service where service_id =?";


    @Override
    public List<Service> findAll() {
        List<Service> serviceList =new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(SELECT_ALL_USERS);
                resultSet=statement.executeQuery();
                while ( resultSet.next() ){
                    String service_id=resultSet.getString("service_id");
                    String service_name=resultSet.getString("service_name");
                    String service_area=resultSet.getString("service_area");
                    String service_cost=resultSet.getString("service_cost");
                    String service_max_people=resultSet.getString("service_max_people");
                    String rent_type_id=resultSet.getString("rent_type_id");
                    String service_type_id=resultSet.getString("service_type_id");
                    String standard_room=resultSet.getString("standard_room");
                    String description_other_convenience=resultSet.getString("description_other_convenience");
                    String pool_area=resultSet.getString("pool_area");
                    String number_of_floors=resultSet.getString("number_of_floors");
                    serviceList.add(new Service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience, pool_area,number_of_floors));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return serviceList;
    }
    @Override
    public void create(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(INSERT_USERS_SQL);
                statement.setString(1,service.getService_id());
                statement.setString(2,service.getService_name());
                statement.setString(3,service.getService_area());
                statement.setString(4,service.getService_cost());
                statement.setString(5,service.getService_max_people());
                statement.setString(6,service.getRent_type_id());
                statement.setString(7,service.getService_type_id());
                statement.setString(8,service.getStandard_room());
                statement.setString(9,service.getDescription_other_convenience());
                statement.setString(10,service.getPool_area());
                statement.setString(11,service.getNumber_of_floors());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public boolean deleteService(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SERVICE_SQL);) {
            statement.setString(1,service.getService_name());
            statement.setString(2,service.getService_area());
            statement.setString(3,service.getService_cost());
            statement.setString(4,service.getService_max_people());
            statement.setString(5,service.getRent_type_id());
            statement.setString(6,service.getService_type_id());
            statement.setString(7,service.getStandard_room());
            statement.setString(8,service.getDescription_other_convenience());
            statement.setString(9,service.getPool_area());
            statement.setString(10,service.getNumber_of_floors());
            statement.setString(11,service.getService_id());
            rowUpdated = statement.executeUpdate() > 0;
        }finally {
            DBConnection.close();
        }
        return rowUpdated;
    }

    @Override
    public Service findById(String id) throws SQLException {
        Service service = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if(connection!=null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
                preparedStatement.setString(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while ( resultSet.next() ) {
                    String service_id=resultSet.getString("service_id");
                    String service_name=resultSet.getString("service_name");
                    String service_area=resultSet.getString("service_area");
                    String service_cost=resultSet.getString("service_cost");
                    String service_max_people=resultSet.getString("service_max_people");
                    String rent_type_id=resultSet.getString("rent_type_id");
                    String service_type_id=resultSet.getString("service_type_id");
                    String standard_room=resultSet.getString("standard_room");
                    String description_other_convenience=resultSet.getString("description_other_convenience");
                    String pool_area=resultSet.getString("pool_area");
                    String number_of_floors=resultSet.getString("number_of_floors");
                    service=new Service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors);
                }

            } finally {
                DBConnection.close();
            }
        }
        return service;

    }
}

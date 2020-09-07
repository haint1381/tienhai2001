package com.furama.dao.service_dao;

import com.furama.dao.DBConnection;
import com.furama.model.Customer;
import com.furama.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO implements IServiceDAO{
    private static final String SELECT_ALL_USERS ="select* from service";
    private static final String INSERT_USERS_SQL =
            "insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id ,service_type_id,standard_room ,description_other_convenience,pool_area,number_of_floors) values (?,?,?,?,?,?,?,?,?,?,?);";
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
                    int service_id=resultSet.getInt("service_id");
                    String service_name=resultSet.getString("service_name");
                    int service_area=resultSet.getInt("service_area");
                    double service_cost=resultSet.getDouble("service_cost");
                    int service_max_people=resultSet.getInt("service_max_people");
                    int rent_type_id=resultSet.getInt("rent_type_id");
                    int service_type_id=resultSet.getInt("service_type_id");
                    String standard_room=resultSet.getString("standard_room");
                    String description_other_convenience=resultSet.getString("description_other_convenience");
                    double pool_area=resultSet.getDouble("pool_area");
                    int numer_of_floors=resultSet.getInt("number_of_floors");
                    serviceList.add(new Service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience, pool_area,numer_of_floors));
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
                statement.setInt(1,service.getService_id());
                statement.setString(2,service.getService_name());
                statement.setInt(3,service.getService_area());
                statement.setDouble(4,service.getService_cost());
                statement.setInt(5,service.getService_max_people());
                statement.setInt(6,service.getRent_type_id());
                statement.setInt(7,service.getService_type_id());
                statement.setString(8,service.getStandard_room());
                statement.setString(9,service.getDescription_other_convenience());
                statement.setDouble(10,service.getPool_area());
                statement.setInt(11,service.getNumber_of_floors());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }
}

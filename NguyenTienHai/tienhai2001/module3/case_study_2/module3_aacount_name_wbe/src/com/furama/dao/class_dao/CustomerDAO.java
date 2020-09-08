package com.furama.dao.class_dao;

import com.furama.dao.DBConnection;
import com.furama.dao.interface_dao.ICustomerDAO;
import com.furama.model.Customer;
import com.furama.model.CustomerUsingService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    private static final String INSERT_USERS_SQL =
            "INSERT INTO customer (customer_id ,customer_type_id ,customer_name, customer_birthday,customer_gender,customer_id_card ,customer_phone ,customer_email ,customer_address) VALUES  (?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_USERS ="select* from customer";
    private static final String DELETE_USERS_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_USERS_SQL = "update customer set customer_type_id= ?, customer_name =?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? where customer_id = ?;";
    private static final String SELECT_USER_BY_ID = "select* from customer where customer_id =?";
    private static final String SELECT_USER_BY_NAME = "select* from customer where customer_name like ?;";
    private static final String CUSTOMERS_USING_THE_SERVICE ="select customer.customer_id, customer.customer_name,service.service_id,service.service_name,contract.contract_id,attach_service.attach_service_id,attach_service.attach_service_name\n" +
            "from customer\n" +
            "inner join contract on\tcontract.contract_id = customer.customer_id\n" +
            "inner join service on\tservice.service_id = contract.service_id\n" +
            "inner join contract_detail on\tcontract_detail.contract_id = contract.contract_id\n" +
            "inner join attach_service on\tattach_service.attach_service_id = contract_detail.attach_service_id;";

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList =new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(SELECT_ALL_USERS);
                resultSet=statement.executeQuery();
                while ( resultSet.next() ){
                    String id=resultSet.getString("customer_id");
                    String type_id=resultSet.getString("customer_type_id");
                    String name=resultSet.getString("customer_name");
                    String birthday=resultSet.getString("customer_birthday");
                    String gender=resultSet.getString("customer_gender");
                    String id_card=resultSet.getString("customer_id_card");
                    String phone=resultSet.getString("customer_phone");
                    String email=resultSet.getString("customer_email");
                    String address=resultSet.getString("customer_address");
                    customerList.add(new Customer(id,type_id , name , birthday, gender, id_card, phone, email, address));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return customerList;
    }

    @Override
    public void create(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(INSERT_USERS_SQL);
                statement.setString(1,customer.getId());
                statement.setString(2,customer.getType_id());
                statement.setString(3,customer.getName());
                statement.setString(4,customer.getBirthday());
                statement.setString(5,customer.getGender());
                statement.setString(6,customer.getId_card());
                statement.setString(7,customer.getPhone());
                statement.setString(8,customer.getEmail());
                statement.setString(9,customer.getAddress());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1,customer.getType_id());
            statement.setString(2,customer.getName());
            statement.setString(3,customer.getBirthday());
            statement.setInt(4,Integer.parseInt(customer.getGender()));
            statement.setString(5,customer.getId_card());
            statement.setString(6,customer.getPhone());
            statement.setString(7,customer.getEmail());
            statement.setString(8,customer.getAddress());
            statement.setString(9,customer.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }finally {
            DBConnection.close();
        }
        return rowUpdated;
    }

    @Override
    public Customer findById(String id) throws SQLException {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if(connection!=null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
                preparedStatement.setString(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while ( resultSet.next() ) {
                    String id1=resultSet.getString("customer_id");
                    String type_id=resultSet.getString("customer_type_id");
                    String name=resultSet.getString("customer_name");
                    String birthday=resultSet.getString("customer_birthday");
                    String gender=resultSet.getString("customer_gender");
                    String id_card=resultSet.getString("customer_id_card");
                    String phone=resultSet.getString("customer_phone");
                    String email=resultSet.getString("customer_email");
                    String address=resultSet.getString("customer_address");
                    customer =new Customer(id1,type_id , name , birthday, gender, id_card, phone, email, address);
                }

            } finally {
                DBConnection.close();
            }
        }
        return customer;

    }

    @Override
    public List<Customer> selectByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME))
        {
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String id1=resultSet.getString("customer_id");
                String type_id=resultSet.getString("customer_type_id");
                String name1=resultSet.getString("customer_name");
                String birthday=resultSet.getString("customer_birthday");
                String gender=resultSet.getString("customer_gender");
                String id_card=resultSet.getString("customer_id_card");
                String phone=resultSet.getString("customer_phone");
                String email=resultSet.getString("customer_email");
                String address=resultSet.getString("customer_address");
                customerList.add(new Customer(id1,type_id , name1 , birthday, gender, id_card, phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerList;
    }

    @Override
    public List<CustomerUsingService> customersUsingTheService() {
        List<CustomerUsingService> customerUsingServiceList =new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(CUSTOMERS_USING_THE_SERVICE);
                resultSet=statement.executeQuery();
                while ( resultSet.next() ){
                    String customer_id=resultSet.getString("customer.customer_id");
                    String customer_name=resultSet.getString("customer.customer_name");
                    String service_id=resultSet.getString("service.service_id");
                    String service_name=resultSet.getString("service.service_name");
                    String contract_id=resultSet.getString("contract.contract_id");
                    String attach_service_id=resultSet.getString("attach_service.attach_service_id");
                    String attach_service_name=resultSet.getString("attach_service.attach_service_name");
                    customerUsingServiceList.add(new CustomerUsingService(customer_id,customer_name,service_id,service_name,contract_id,attach_service_id,attach_service_name));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return customerUsingServiceList;
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
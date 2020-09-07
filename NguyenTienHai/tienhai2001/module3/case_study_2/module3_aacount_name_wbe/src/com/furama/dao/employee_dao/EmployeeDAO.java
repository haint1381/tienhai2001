package com.furama.dao.employee_dao;

import com.furama.dao.DBConnection;
import com.furama.model.Customer;
import com.furama.model.Employee;
import com.furama.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    private static final String SELECT_ALL_EMPLOYEE ="select* from employee";
    private static final String INSERT_EMPLOYEE_SQL="insert into employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_EMPLOYEE_SQL ="delete from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_name=?,employee_birthday=?,employee_id_card=?,employee_salary=?,employee_phone=?,employee_email=?,employee_address=?,position_id=?,education_degree_id=?,division_id=?,username=? where employee_id = ?;";
    private static final String SELECT_EMPLOYEE_BY_ID = "select* from employee where employee_id =?";
    private static final String SELECT_EMPLOYEE_BY_NAME="select* from employee where employee_name like ?;";



    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList =new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                resultSet=statement.executeQuery();
                while ( resultSet.next() ){
                    int employee_id=resultSet.getInt("employee_id");
                    String employee_name=resultSet.getString("employee_name");
                    String employee_birthday=resultSet.getString("employee_birthday");
                    String employee_id_card=resultSet.getString("employee_id_card");
                    double employee_salary=resultSet.getDouble("employee_salary");
                    String employee_phone=resultSet.getString("employee_phone");
                    String employee_email=resultSet.getString("employee_email");
                    String employee_address=resultSet.getString("employee_address");
                    int position_id=resultSet.getInt("position_id");
                    int education_degree_id=resultSet.getInt("education_degree_id");
                    int division_id=resultSet.getInt("division_id");
                    String username=resultSet.getString("username");
                    employeeList.add(new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id, username));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return employeeList;
    }

    @Override
    public void create(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(INSERT_EMPLOYEE_SQL);
                statement.setInt(1,employee.getEmployee_id());
                statement.setString(2,employee.getEmployee_name());
                statement.setString(3,employee.getEmployee_birthday());
                statement.setString(4,employee.getEmployee_id_card());
                statement.setDouble(5,employee.getEmployee_salary());
                statement.setString(6,employee.getEmployee_phone());
                statement.setString(7,employee.getEmployee_email());
                statement.setString(8,employee.getEmployee_address());
                statement.setInt(9,employee.getPosition_id());
                statement.setInt(10,employee.getEducation_degree_id());
                statement.setInt(11,employee.getDivision_id());
                statement.setString(12,employee.getUsername());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }
    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
            statement.setString(1,employee.getEmployee_name());
            statement.setString(2,employee.getEmployee_birthday());
            statement.setString(3,employee.getEmployee_id_card());
            statement.setDouble(4,employee.getEmployee_salary());
            statement.setString(5,employee.getEmployee_phone());
            statement.setString(6,employee.getEmployee_email());
            statement.setString(7,employee.getEmployee_address());
            statement.setInt(8,employee.getPosition_id());
            statement.setInt(9,employee.getEducation_degree_id());
            statement.setInt(10,employee.getDivision_id());
            statement.setString(11,employee.getUsername());
            statement.setInt(12,employee.getEmployee_id());
            rowUpdated = statement.executeUpdate() > 0;
        }finally {
            DBConnection.close();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Employee findById(int id) throws SQLException {
        Employee employee = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if(connection!=null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while ( resultSet.next() ) {
                    int employee_id =resultSet.getInt("employee_id");
                    String employee_name=resultSet.getString("employee_name");
                    String employee_birthday=resultSet.getString("employee_birthday");
                    String employee_id_card=resultSet.getString("employee_id_card");
                    double employee_salary=resultSet.getDouble("employee_salary");
                    String employee_phone=resultSet.getString("employee_phone");
                    String employee_email=resultSet.getString("employee_email");
                    String employee_address=resultSet.getString("employee_address");
                    int position_id=resultSet.getInt("position_id");
                    int education_degree_id=resultSet.getInt("education_degree_id");
                    int division_id=resultSet.getInt("division_id");
                    String username=resultSet.getString("username");
                     employee= new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username);
                }

            } finally {
                DBConnection.close();
            }
        }
        return employee;
    }

    @Override
    public List<Employee> selectByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME))
        {
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                int employee_id =resultSet.getInt("employee_id");
                String employee_name=resultSet.getString("employee_name");
                String employee_birthday=resultSet.getString("employee_birthday");
                String employee_id_card=resultSet.getString("employee_id_card");
                double employee_salary=resultSet.getDouble("employee_salary");
                String employee_phone=resultSet.getString("employee_phone");
                String employee_email=resultSet.getString("employee_email");
                String employee_address=resultSet.getString("employee_address");
                int position_id=resultSet.getInt("position_id");
                int education_degree_id=resultSet.getInt("education_degree_id");
                int division_id=resultSet.getInt("division_id");
                String username=resultSet.getString("username");
                employeeList.add(new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeList;
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

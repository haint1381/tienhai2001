package com.furama.dao.contract_dao;

import com.furama.dao.DBConnection;
import com.furama.model.Contract;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO implements IContractDAO {
    private static final String SELECT_ALL_USERS ="select* from contract";
    private static final String INSERT_USERS_SQL =
            "insert into contract(contract_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id) values (?,?,?,?,?,?,?,?)";

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList =new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(SELECT_ALL_USERS);
                resultSet=statement.executeQuery();
                while ( resultSet.next() ){
                    int contract_id=resultSet.getInt("contract_id");
                    String contract_start_date=resultSet.getString("contract_start_date");
                    String contract_end_date=resultSet.getString("contract_end_date");
                    double contract_deposit=resultSet.getDouble("contract_deposit");
                    double contract_total_money=resultSet.getDouble("contract_total_money");
                    int employee_id=resultSet.getInt("employee_id");
                    int customer_id=resultSet.getInt("customer_id");
                    int service_id=resultSet.getInt("service_id");
                    contractList.add(new Contract(contract_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return contractList;
    }
    @Override
    public void create(Contract contract) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(INSERT_USERS_SQL);
                statement.setInt(1,contract.getContract_id());
                statement.setString(2,contract.getContract_start_date());
                statement.setString(3,contract.getContract_end_date());
                statement.setDouble(4,contract.getContract_deposit());
                statement.setDouble(5,contract.getContract_total_money());
                statement.setInt(6,contract.getEmployee_id());
                statement.setInt(7,contract.getCustomer_id());
                statement.setInt(8,contract.getService_id());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }


}

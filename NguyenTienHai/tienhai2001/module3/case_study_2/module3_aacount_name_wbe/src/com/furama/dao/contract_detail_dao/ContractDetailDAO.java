package com.furama.dao.contract_detail_dao;

import com.furama.dao.DBConnection;
import com.furama.model.Contract;
import com.furama.model.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailDAO implements IContractDetailDAO {
    private static final String SELECT_ALL_USERS ="select* from contract_detail;";
    private static final String INSERT_USERS_SQL =
    "insert into contract_detail(contract_detail_id,contract_id,attach_service_id,quantity) value (?,?,?,?);";
    @Override
    public List<ContractDetail> findAll() {
        List<ContractDetail> contractDetailList =new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(SELECT_ALL_USERS);
                resultSet=statement.executeQuery();
                while ( resultSet.next() ){
                    int contract_detail_id=resultSet.getInt("contract_detail_id");
                    int contract_id=resultSet.getInt("contract_id");
                    int attach_service_id=resultSet.getInt("attach_service_id");
                    int quantity=resultSet.getInt("quantity");
                    contractDetailList.add(new ContractDetail(contract_detail_id,contract_id,attach_service_id,quantity));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return contractDetailList;
    }
    @Override
    public void create(ContractDetail contractDetail) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(INSERT_USERS_SQL);
                statement.setInt(1,contractDetail.getContract_detail_id());
                statement.setInt(2,contractDetail.getContract_id());
                statement.setInt(3,contractDetail.getAttach_service_id());
                statement.setInt(4,contractDetail.getQuantity());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }
}

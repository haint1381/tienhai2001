package com.furama.dao.class_dao;

import com.furama.dao.DBConnection;
import com.furama.dao.interface_dao.IContractDetailDAO;
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
                    String contract_detail_id=resultSet.getString("contract_detail_id");
                    String contract_id=resultSet.getString("contract_id");
                    String attach_service_id=resultSet.getString("attach_service_id");
                    String quantity=resultSet.getString("quantity");
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
                statement.setString(1,contractDetail.getContract_detail_id());
                statement.setString(2,contractDetail.getContract_id());
                statement.setString(3,contractDetail.getAttach_service_id());
                statement.setString(4,contractDetail.getQuantity());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }
}

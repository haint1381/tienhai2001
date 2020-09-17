package com.codegym.dao;

import com.codegym.model.Premises;
import com.codegym.model.RentalSpaceManagement;
import com.codegym.model.Status;

import java.sql.SQLException;
import java.util.List;

public interface IRentalSpaceManagementDAO {
    List<RentalSpaceManagement> findAll();
//    List<RentalSpaceManagement> findBy3(String name1,String name2,String name3);
    void create(RentalSpaceManagement rentalSpaceManagement);
    boolean delete(String id) throws SQLException;
    RentalSpaceManagement findById(String id) throws SQLException;
    List<RentalSpaceManagement> findByPremises(String name) throws SQLException;
    List<RentalSpaceManagement> findByFloors(String name) throws SQLException;
    List<RentalSpaceManagement> findByPrice(String name) throws SQLException;
}

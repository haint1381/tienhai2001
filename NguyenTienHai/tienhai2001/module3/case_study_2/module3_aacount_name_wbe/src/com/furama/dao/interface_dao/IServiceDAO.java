package com.furama.dao.interface_dao;

import com.furama.model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceDAO {
    List<Service> findAll();
    void create(Service service);
    boolean deleteService(String id) throws SQLException;
    boolean updateService(Service service) throws SQLException;
    Service findById(String id) throws SQLException;
}

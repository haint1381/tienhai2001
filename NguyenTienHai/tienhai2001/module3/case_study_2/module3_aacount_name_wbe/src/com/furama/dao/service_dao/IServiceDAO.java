package com.furama.dao.service_dao;

import com.furama.model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceDAO {
    List<Service> findAll();
    void create(Service service);
    boolean deleteService(int id) throws SQLException;
    boolean updateService(Service service) throws SQLException;
    Service findById(int id) throws SQLException;
}

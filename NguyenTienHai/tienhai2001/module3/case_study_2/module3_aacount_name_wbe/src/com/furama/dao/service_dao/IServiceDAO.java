package com.furama.dao.service_dao;

import com.furama.model.Customer;
import com.furama.model.Service;

import java.util.List;

public interface IServiceDAO {
    List<Service> findAll();
    void create(Service service);
}

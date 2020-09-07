package com.furama.bo.service_bo;

import com.furama.model.Service;

import java.util.List;

public interface IServiceBO {
    List<Service> findAll();
    void create(Service service);
}

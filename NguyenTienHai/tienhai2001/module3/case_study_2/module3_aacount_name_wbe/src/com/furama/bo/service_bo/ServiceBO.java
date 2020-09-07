package com.furama.bo.service_bo;

import com.furama.dao.service_dao.IServiceDAO;
import com.furama.dao.service_dao.ServiceDAO;
import com.furama.model.Service;

import java.util.List;

public class ServiceBO implements IServiceBO{
    IServiceDAO iServiceDAO =new ServiceDAO();
    @Override
    public List<Service> findAll() {
        return iServiceDAO.findAll();
    }

    @Override
    public void create(Service service) {
        iServiceDAO.create(service);
    }
}

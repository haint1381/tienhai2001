package com.furama.bo.class_bo;

import com.furama.bo.interface_bo.IServiceBO;
import com.furama.dao.interface_dao.IServiceDAO;
import com.furama.dao.class_dao.ServiceDAO;
import com.furama.model.Customer;
import com.furama.model.Service;

import java.sql.SQLException;
import java.util.List;

public class ServiceBO implements IServiceBO {
    IServiceDAO iServiceDAO =new ServiceDAO();
    @Override
    public List<Service> findAll() {
        return iServiceDAO.findAll();
    }

    @Override
    public void create(Service service) {
        iServiceDAO.create(service);
    }

    @Override
    public boolean deleteService(String id) throws SQLException {
        return iServiceDAO.deleteService(id);
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        return iServiceDAO.updateService(service);
    }

    @Override
    public Service findById(String id) throws SQLException {
        return iServiceDAO.findById(id);
    }

    @Override
    public boolean checkId(String id) {
        boolean check=true;
        List<Service> serviceList =iServiceDAO.findAll();
        for (int i=0;i<serviceList.size();i++){
            if(id.equals(serviceList.get(i).getService_id())){
                check=false;
                break;
            }
        }
        return check;
    }
}

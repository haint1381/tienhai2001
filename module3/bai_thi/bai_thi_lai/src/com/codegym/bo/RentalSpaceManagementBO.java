package com.codegym.bo;

import com.codegym.dao.IRentalSpaceManagementDAO;
import com.codegym.dao.RentalSpaceManagementDAO;
import com.codegym.model.Premises;
import com.codegym.model.RentalSpaceManagement;
import com.codegym.model.Status;

import java.sql.SQLException;
import java.util.List;

public class RentalSpaceManagementBO implements  IRentalSpaceManagementBO {
    IRentalSpaceManagementDAO iRentalSpaceManagementDAO=new RentalSpaceManagementDAO();
    @Override
    public List<RentalSpaceManagement> findAll() {
        return iRentalSpaceManagementDAO.findAll();
    }

    @Override
    public void create(RentalSpaceManagement rentalSpaceManagement) {
        iRentalSpaceManagementDAO.create(rentalSpaceManagement);
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return iRentalSpaceManagementDAO.delete(id);
    }

    @Override
    public RentalSpaceManagement findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<RentalSpaceManagement> findByPremises(String name) throws SQLException {
        return iRentalSpaceManagementDAO.findByPremises(name);
    }

    @Override
    public List<RentalSpaceManagement> findByFloors(String name) throws SQLException {
        return iRentalSpaceManagementDAO.findByFloors(name);
    }

    @Override
    public List<RentalSpaceManagement> findByPrice(String name) throws SQLException {
        return iRentalSpaceManagementDAO.findByPrice(name);
    }
}

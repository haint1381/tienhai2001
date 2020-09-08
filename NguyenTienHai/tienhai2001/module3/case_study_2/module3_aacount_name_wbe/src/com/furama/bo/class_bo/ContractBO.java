package com.furama.bo.class_bo;

import com.furama.bo.interface_bo.IContractBO;
import com.furama.dao.class_dao.ContractDAO;
import com.furama.dao.interface_dao.IContractDAO;
import com.furama.model.Contract;

import java.util.List;

public class ContractBO implements IContractBO {
    IContractDAO contractDAO =new ContractDAO();
    @Override
    public List<Contract> findAll() {
        return contractDAO.findAll();
    }

    @Override
    public void create(Contract contract) {
        contractDAO.create(contract);
    }
}

package com.furama.bo.contract_bo;

import com.furama.dao.contract_dao.ContractDAO;
import com.furama.dao.contract_dao.IContractDAO;
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

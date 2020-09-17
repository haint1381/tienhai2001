package com.furama.bo.class_bo;


import com.furama.bo.interface_bo.IContractDetailBO;
import com.furama.dao.class_dao.ContractDetailDAO;
import com.furama.dao.interface_dao.IContractDetailDAO;
import com.furama.model.ContractDetail;

import java.util.List;

public class ContractDetailBO implements IContractDetailBO {
    IContractDetailDAO contractDetailDAO =new ContractDetailDAO();
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailDAO.findAll();
    }

    @Override
    public void create(ContractDetail contractDetail) {
        contractDetailDAO.create(contractDetail);
    }
}

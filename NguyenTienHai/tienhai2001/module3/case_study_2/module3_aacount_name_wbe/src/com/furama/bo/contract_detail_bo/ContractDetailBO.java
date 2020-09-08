package com.furama.bo.contract_detail_bo;


import com.furama.dao.contract_detail_dao.ContractDetailDAO;
import com.furama.dao.contract_detail_dao.IContractDetailDAO;
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

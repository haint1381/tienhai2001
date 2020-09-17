package com.furama.dao.interface_dao;

import com.furama.model.ContractDetail;

import java.util.List;

public interface IContractDetailDAO {
    List<ContractDetail> findAll();
    void create(ContractDetail contractDetail);
}

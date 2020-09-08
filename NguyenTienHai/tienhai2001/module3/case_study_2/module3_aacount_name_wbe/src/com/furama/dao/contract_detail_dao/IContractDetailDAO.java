package com.furama.dao.contract_detail_dao;

import com.furama.model.ContractDetail;

import java.util.List;

public interface IContractDetailDAO {
    List<ContractDetail> findAll();
    void create(ContractDetail contractDetail);
}

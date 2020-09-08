package com.furama.dao.contract_dao;

import com.furama.model.Contract;

import java.util.List;

public interface IContractDAO {
    List<Contract> findAll();
    void create(Contract contract);

}

package com.furama.bo.interface_bo;

import com.furama.model.Contract;

import java.util.List;

public interface IContractBO {
    List<Contract> findAll();
    void create(Contract contract);
}

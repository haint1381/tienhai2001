package com.furama.bo.interface_bo;

import com.furama.model.Contract;
import com.furama.model.ContractDetail;

import java.util.List;

public interface IContractDetailBO {
    List<ContractDetail> findAll();
    void create(ContractDetail contractDetail);
}

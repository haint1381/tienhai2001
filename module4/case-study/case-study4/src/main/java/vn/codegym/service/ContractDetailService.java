package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.ContractDetail;


public interface ContractDetailService {
    Page<ContractDetail> getAll(Pageable pageable);

    ContractDetail findById(String id);

    void save(ContractDetail contractDetail);
    boolean checkId(String id);
    void delete(String id);
}

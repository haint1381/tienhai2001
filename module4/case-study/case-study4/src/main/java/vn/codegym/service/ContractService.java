package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Contract;


public interface ContractService {
    Page<Contract> getAll(Pageable pageable);

    Contract findById(String id);
    Iterable<Contract> findAll();
    void save(Contract contract);
    boolean checkId(String id);
    void delete(String id);
}

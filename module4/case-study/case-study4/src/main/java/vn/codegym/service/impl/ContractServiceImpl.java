package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Contract;
import vn.codegym.repository.ContractRepository;
import vn.codegym.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;
    @Override
    public Page<Contract> getAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(String id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public boolean checkId(String id) {
        boolean check = false;
        for (int i=0;i<contractRepository.findAll().size();i++){
            if(id.equals(contractRepository.findAll().get(i).getContractId())){
                check=false;
                break;
            }
            check=true;
        }

        return check;
    }

    @Override
    public void delete(String id) {
        contractRepository.deleteById(id);
    }
}

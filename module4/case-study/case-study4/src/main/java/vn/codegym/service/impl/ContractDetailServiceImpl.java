package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.ContractDetail;
import vn.codegym.repository.ContractDetailRepository;
import vn.codegym.service.ContractDetailService;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> getAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public ContractDetail findById(String id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public boolean checkId(String id) {
        boolean check = false;
        for (int i=0;i<contractDetailRepository.findAll().size();i++){
            if(id.equals(contractDetailRepository.findAll().get(i).getContractDetailId())){
                check=false;
                break;
            }
            check=true;
        }

        return check;
    }

    @Override
    public void delete(String id) {
        contractDetailRepository.deleteById(id);
    }
}

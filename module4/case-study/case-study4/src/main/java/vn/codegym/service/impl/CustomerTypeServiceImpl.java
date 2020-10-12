package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.CustomerType;
import vn.codegym.repository.CustomerTypeRepository;
import vn.codegym.service.CustomerTypeService;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable<CustomerType> findAll() {
       return customerTypeRepository.findAll();
    }
}

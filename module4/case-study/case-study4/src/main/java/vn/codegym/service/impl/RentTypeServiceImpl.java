package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.CustomerType;
import vn.codegym.model.RentType;
import vn.codegym.repository.RentTypeRepository;
import vn.codegym.service.RentTypeService;
@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}

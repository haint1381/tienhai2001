package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.ServiceType;
import vn.codegym.service.ServiceTypeService;

@Service
public class ServiceTypeImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeService serviceTypeService;
    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeService.findAll();
    }
}

package vn.codegym.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import vn.codegym.model.Service;
import vn.codegym.service.ServiceService;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceService serviceService;

    @Override
    public Page<Service> getAll(Pageable pageable) {
        return serviceService.getAll(pageable);
    }

    @Override
    public Service findById(String id) {
        return serviceService.findById(id);
    }

    @Override
    public void save(Service service) {
        serviceService.save(service);
    }

    @Override
    public void delete(String id) {
        serviceService.delete(id);
    }
}

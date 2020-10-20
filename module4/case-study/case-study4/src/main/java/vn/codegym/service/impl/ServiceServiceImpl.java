package vn.codegym.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import vn.codegym.model.Service;
import vn.codegym.repository.ServiceRepository;
import vn.codegym.service.ServiceService;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<Service> getAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public boolean checkId(String id) {
        boolean check = false;
        for (int i=0;i<serviceRepository.findAll().size();i++){
            if(id.equals(serviceRepository.findAll().get(i).getServiceId())){
                check=false;
                break;
            }
            check=true;
        }

        return check;
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Iterable<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void delete(String id) {
        serviceRepository.deleteById(id);
    }
}

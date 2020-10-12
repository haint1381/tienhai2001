package vn.codegym.service;

import vn.codegym.model.RentType;
import vn.codegym.model.ServiceType;

public interface ServiceTypeService {
    Iterable<ServiceType> findAll();
}

package vn.codegym.service;

import vn.codegym.model.CustomerType;
import vn.codegym.model.RentType;

public interface RentTypeService {
    Iterable<RentType> findAll();
}

package vn.codegym.service;

import vn.codegym.model.CustomerType;

public interface CustomerTypeService  {
    Iterable<CustomerType> findAll();
}

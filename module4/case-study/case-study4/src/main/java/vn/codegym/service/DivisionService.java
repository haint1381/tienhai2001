package vn.codegym.service;

import vn.codegym.model.Division;
import vn.codegym.model.RentType;

public interface DivisionService {
    Iterable<Division> findAll();
}

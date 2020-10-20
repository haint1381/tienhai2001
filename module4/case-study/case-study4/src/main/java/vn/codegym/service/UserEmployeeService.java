package vn.codegym.service;

import vn.codegym.model.RentType;
import vn.codegym.model.UserEmployee;

public interface UserEmployeeService  {
    Iterable<UserEmployee> findAll();
}

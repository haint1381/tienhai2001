package vn.codegym.service;

import vn.codegym.model.Position;
import vn.codegym.model.RentType;

public interface PositionService {
    Iterable<Position> findAll();
}

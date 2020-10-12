package vn.codegym.repository;

import org.springframework.data.repository.CrudRepository;
import vn.codegym.model.Smartphone;

public interface SmartphoneRepository extends CrudRepository<Smartphone, Long> {
}

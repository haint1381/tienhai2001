package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.FlowerProducts;


public interface ProductRepository extends JpaRepository<FlowerProducts, Long> {

}

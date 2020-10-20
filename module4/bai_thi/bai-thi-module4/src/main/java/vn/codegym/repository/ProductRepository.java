package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findProductsByProductNameContainsAndStatusTrue(String name, Pageable pageable);
    Page<Product> findProductsByPriceContainsAndStatusTrue(String price, Pageable pageable);
    Page<Product> findProductsByColorContainsAndStatusTrue(String color, Pageable pageable);

    Page<Product> findAllByStatusTrueOrderByProductNameAsc(Pageable pageable);
    Page<Product> findAllByStatusTrueOrderByPriceAsc(Pageable pageable);
    Page<Product> findAllByStatusTrueAndProductNameOrColorContaining(String color,String name,Pageable pageable);

}

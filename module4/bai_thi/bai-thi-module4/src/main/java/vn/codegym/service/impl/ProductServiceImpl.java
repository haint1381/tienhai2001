package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import vn.codegym.model.Product;
import vn.codegym.repository.ProductRepository;
import vn.codegym.service.ProductService;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

//    @Override
//    public boolean checkId(String id) {
//        boolean check = true;
//        for (int i=0;i<productRepository.findAll().size();i++){
//            if(id.equals(productRepository.findAll().get(i).getProductId())){
//                check=false;
//                break;
//            }
//            check=true;
//        }
//
//        return check;
//    }

    @Override
    public Page<Product> findProductsByProductNameContains(String name, Pageable pageable) {
        return productRepository.findProductsByProductNameContainsAndStatusTrue(name, pageable);
    }

    @Override
    public Page<Product> findProductsByPriceContains(String price, Pageable pageable) {
        return productRepository.findProductsByPriceContainsAndStatusTrue(price, pageable);
    }

    @Override
    public Page<Product> findProductsByColorContains(String color, Pageable pageable) {
        return productRepository.findProductsByColorContainsAndStatusTrue(color, pageable);
    }

    @Override
    public Page<Product> findAllByStatusTrue(Pageable pageable) {
        return productRepository.findAllByStatusTrueOrderByProductNameAsc(pageable);
    }

    @Override
    public Page<Product> findAllByStatusTrueAndColorContainingOrProductNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByStatusTrueAndProductNameOrColorContaining(name, name, pageable);
    }

    @Override
    public boolean checkBirthday(String birthday) {
        boolean check = false;
        int yearNow = Year.now().getValue();
        System.err.println(yearNow);

        String[] stringDay = birthday.split("/");
        int year =yearNow- Integer.parseInt(stringDay[2]);
        int month = Integer.parseInt(stringDay[1]);

        int total = year * 12 + month;
        if (total > 216) {//1500
            check = true;
        }
        return check;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Product customerValidate = (Product) target;
////        String date = customerValidate.getBirthday().toString();
////        String[] birthdayArray = date.split("-");
//        int year = Integer.parseInt(birthdayArray[0]);
//        int month = Integer.parseInt(birthdayArray[1]);
//        int day = Integer.parseInt(birthdayArray[2]);
//        LocalDate birthdate = LocalDate.of(year, month, day);
//        LocalDate now = LocalDate.now();
//        long age = Period.between(birthdate, now).getYears();
//        if (age < 18 || age > 125) {
//            errors.rejectValue("birthday", "birthday.Value");
//        }
    }
}

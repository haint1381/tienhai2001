package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Service;

public interface ServiceService {
    Page<Service> getAll(Pageable pageable);

    Service findById(String id);

    void save(Service service);

    void delete(String id);
}

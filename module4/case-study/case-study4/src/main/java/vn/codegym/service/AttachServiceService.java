package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.AttachService;


public interface AttachServiceService  {
    Iterable<AttachService> findAll();
}

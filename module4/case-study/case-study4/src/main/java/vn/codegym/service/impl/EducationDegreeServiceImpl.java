package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.EducationDegree;
import vn.codegym.repository.EducationDegreeRepository;
import vn.codegym.service.EducationDegreeService;
@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {

    @Autowired
    EducationDegreeRepository educationDegreeRepository;
    @Override
    public Iterable<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}

package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Smartphone;
import vn.codegym.repository.SmartphoneRepository;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return this.smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return this.smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone phone) {
        return this.smartphoneRepository.save(phone);
    }

    @Override
    public Smartphone remove(Long id) {
        Smartphone smartphone = smartphoneRepository.findById(id).orElse(null);
        smartphoneRepository.delete(smartphone);
        return smartphone;
    }
}

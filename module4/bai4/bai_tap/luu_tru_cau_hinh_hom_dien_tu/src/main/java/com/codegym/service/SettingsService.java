package com.codegym.service;

import com.codegym.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegym.repository.ISettingsRepository;

import java.util.List;

@Service
public class SettingsService implements ISettingsService{
    @Autowired
    ISettingsRepository iSettingsRepository;

    @Override
    public List<String> getLanguage() {
        return iSettingsRepository.getLanguage();
    }

    @Override
    public List<String> getPageSize() {
        return iSettingsRepository.getPageSize();
    }

    @Override
    public void update(Settings settings) {
        iSettingsRepository.update(settings);
    }

    @Override
    public Settings getSetting() {
        return iSettingsRepository.getSetting();
    }


}
package com.codegym.service;

import com.codegym.model.Settings;

import java.util.List;

public interface ISettingsService {
    List<String> getLanguage();
    List<String> getPageSize();
    void update(Settings settings);
    Settings getSetting();
}

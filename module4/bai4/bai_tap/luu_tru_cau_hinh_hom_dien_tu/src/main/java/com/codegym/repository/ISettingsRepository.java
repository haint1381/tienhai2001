package com.codegym.repository;

import com.codegym.model.Settings;

import java.util.List;

public interface ISettingsRepository {
    List<String> getLanguage();
    List<String> getPageSize();
    void update(Settings settings);
    Settings getSetting();
}

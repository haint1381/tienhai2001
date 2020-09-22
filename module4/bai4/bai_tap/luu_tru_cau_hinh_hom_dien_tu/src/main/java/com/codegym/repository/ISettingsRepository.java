package com.codegym.repository;

import java.util.List;

public interface ISettingsRepository {
    List<String> getLanguage();
    List<String> getPageSize();
}

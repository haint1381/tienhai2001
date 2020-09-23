package com.codegym.repository;

import com.codegym.model.Settings;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SettingsRepository implements ISettingsRepository{
    private  Settings settings = new Settings("1","1","1","1");

    @Override
    public List<String> getLanguage() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }

    @Override
    public List<String> getPageSize() {
        List<String> pageSizeList = new ArrayList<>();
        pageSizeList.add("5");
        pageSizeList.add("10");
        pageSizeList.add("15");
        pageSizeList.add("25");
        pageSizeList.add("50");
        pageSizeList.add("100");
        return pageSizeList;
    }

    @Override
    public void update(Settings settings) {
        this.settings=settings;
    }

    @Override
    public Settings getSetting() {
        return this.settings;
    }


}
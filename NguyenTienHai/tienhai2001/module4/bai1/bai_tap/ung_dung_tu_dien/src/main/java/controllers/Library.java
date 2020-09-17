package controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;

public class Library {
    private static Map<String,String> dictionary =new TreeMap<String, String>();
    static {
        dictionary.put("hello","xin chào");
    }
    public static Map<String,String> findAll() {
        return new TreeMap<String, String>(dictionary);
    }
}
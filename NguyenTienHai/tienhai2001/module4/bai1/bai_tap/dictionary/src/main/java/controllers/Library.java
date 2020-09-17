package controllers;


import java.util.Map;
import java.util.TreeMap;

public class Library {
    private static Map<String,String> dictionary =new TreeMap<String, String>();
    static {
        dictionary.put("hello","xin chào");
        dictionary.put("dictionary","từ điển");
        dictionary.put("library","thư viện");
        dictionary.put("beautiful","xinh đẹp");
        dictionary.put("class","lớp học");
    }
    public static Map<String,String> findAll() {
        return new TreeMap<String, String>(dictionary);
    }
}
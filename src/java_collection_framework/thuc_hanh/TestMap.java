package java_collection_framework.thuc_hanh;

import java.util.*;
public class TestMap {
    public static void main(String[] args) {
        // Create HashMap to store list of students
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Hoang Kim Van Chuong", 32);
        hashMap.put("Le Nhat", 22);
        hashMap.put("Tu Si Tung", 25);
        hashMap.put("Nguyen Huu Quang", 24);
        hashMap.put("Phan Quoc Khanh", 28);
        hashMap.put("Nguyen Tien Hai", 21);
        hashMap.put("Tran Huu Hien", 26);
        hashMap.put("Nguyen Tran Dat", 27);
        hashMap.put("Tran Phuoc Vuong", 30);
        hashMap.put("Tran Thanh Hoang", 24);
        hashMap.put("Le Toan", 28);
        hashMap.put("Vo Son Tra", 26);
        System.out.println("--Display entries in HashMap--");
//        int j = 1;

//        for (String key : hashMap.keySet()) {
//            System.out.println("Key " + j +": " + key + " - " + hashMap.get(key));
//            j++;
//        }
        for(Map.Entry<String,Integer> abc:hashMap.entrySet()){
            System.out.println(abc);
        }
        System.out.println("------------------------------------");
        // Create TreeMap to store keys by sorting ascending order
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("--Display entries in TreeMap with ascending order of keys--");
//        int i = 1;
//        for (String key : treeMap.keySet()) {
//            System.out.println("Key " + i + ": " + key + " --> " + treeMap.get(key));
//            i++;
//        }
        for(Map.Entry<String,Integer> abc: treeMap.entrySet()){
            System.out.println(abc);
        }
        // Create LinkedHashMap to store list of students
        System.out.println("---------------");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Hoang Kim Van Chuong", 32);
        linkedHashMap.put("Le Nhat", 22);
        linkedHashMap.put("Tu Si Tung", 25);
        linkedHashMap.put("Nguyen Huu Quang", 24);
        linkedHashMap.put("Phan Quoc Khanh", 28);
        linkedHashMap.put("Nguyen Tien Hai", 21);
        linkedHashMap.put("Tran Huu Hien", 26);
        linkedHashMap.put("Nguyen Tran Dat", 27);
        linkedHashMap.put("Tran Phuoc Vuong", 30);
        linkedHashMap.put("Tran Thanh Hoang", 24);
        linkedHashMap.put("Le Toan", 28);
//        for (Map.Entry<String,Integer> abc: linkedHashMap.entrySet()){
//            System.out.println(abc);
//        }

        for (String key : linkedHashMap.keySet()) {
            System.out.println(linkedHashMap.get(key));
        }
        System.out.println();
        // Display LinkedHashMap (support sort entries)

    }
}
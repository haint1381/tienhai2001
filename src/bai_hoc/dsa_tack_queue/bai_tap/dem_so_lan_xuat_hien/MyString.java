package bai_hoc.dsa_tack_queue.bai_tap.dem_so_lan_xuat_hien;

import java.util.*;

public class MyString {

    public static HashMap <Character,Integer > countMap = new HashMap<Character,Integer >();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String");
        String str=scanner.nextLine();
        String string=str.toLowerCase();

        for(int i=0;i<string.length();i++){
            Integer key = countMap.get(string.charAt(i));
            if(key ==null){
                countMap.put(string.charAt(i),1);
            }else {
                countMap.put(string.charAt(i), ++key);
            }
        }

        System.out.println("Initial Mappings are: " + countMap);
        System.out.println("The set is: " + countMap.entrySet());
    }
}

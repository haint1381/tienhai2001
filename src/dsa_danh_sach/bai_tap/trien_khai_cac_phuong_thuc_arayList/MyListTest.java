package dsa_danh_sach.bai_tap.trien_khai_cac_phuong_thuc_arayList;

import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList myList=new MyList();
        myList.addLast(5);
        myList.addLast(4);
        myList.addLast(3);
        myList.addLast(2);
        myList.addLast(1);
        System.out.println(myList.get(0));
        System.out.println("--------------");
        myList.add(2,6);
        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        System.out.println("--------------");
        myList.remove(1);
        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        System.out.println("--------------");
        myList.clone();
        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        System.out.println("--------------");

        System.out.println(myList.contains(3));
        System.out.println("--------------");
        System.out.println(myList.indexOf(3));
        System.out.println("--------------");
        System.out.println(myList.add(3));
        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        System.out.println("--------------");
        myList.clear();
        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        System.out.println("<-_->");
  }
}

package java_collection_framework.bai_tap.luyen_tap_su_dung_linkedlist;

import java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist.SortPriceIncrease;
import java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist.TelephoneProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManager {
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<TelephoneProduct> linkedList = new LinkedList<>();
        while ( true ) {
            display();
            int chosse = scanner.nextInt();
            switch (chosse) {
                case 1: {
                    add(scanner, linkedList);
                    count++;
                }
                break;
                case 2: {
                    edit(scanner, linkedList);

                }
                break;
                case 3: {
                    delete(scanner, linkedList);
                }
                break;
                case 4: {
                    for (TelephoneProduct a : linkedList) {
                        System.out.println(a);
                    }
                }
                break;
                case 5: {

                    seach(scanner, linkedList);
                }
                break;
                case 6: {
                    Collections.sort(linkedList, new SortPriceIncrease());
                    System.out.println("sắp xếp giảm theo giá ok rồi");
                    for (TelephoneProduct a : linkedList) {
                        System.out.println(a);
                    }
                }
                break;
                case 7: {
                    Collections.sort(linkedList, new SortPriceIncrease());
                    System.out.println("sắp xếp tăng theo giá ok rồi");
                    for (TelephoneProduct a : linkedList) {
                        System.out.println(a);
                    }
                }
                break;
                case 8:
                    System.exit(0);
                default: {
                    System.out.println("lựa chọn không hợp lệ");
                }
            }
        }
    }
    private static void seach(Scanner scanner, LinkedList<TelephoneProduct> linkedList) {
        scanner.nextLine();
        System.out.println("nhập tên sản phẩm cần tìm");
        String name = scanner.nextLine();
        for (TelephoneProduct telephoneProduct : linkedList) {
            if (name.equals(telephoneProduct.getName())) {
                System.out.println(telephoneProduct);
            }
            break;

        }
    }

    private static void delete(Scanner scanner, LinkedList<TelephoneProduct> linkedList) {
        System.out.println("nhập id sản phẩm cần xóa");
        int id = scanner.nextInt();
        for (int i = 0; i < linkedList.size(); i++) {
            if (id == linkedList.get(i).getId()) {
                linkedList.remove(linkedList.get(i));
                break;
            }

        }
    }

    private static void edit(Scanner scanner, LinkedList<TelephoneProduct> linkedList) {
        System.out.println("nhập id cần sửa");
        int id = scanner.nextInt();
        for (int i = 0; i < linkedList.size(); i++) {
            if (id == linkedList.get(i).getId()) {
                System.out.println("sửa tên");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("sửa id");
                int id1 = scanner.nextInt();
                System.out.println("sửa giá");
                double price = scanner.nextDouble();
                linkedList.set(i, new TelephoneProduct(name, id1, price));
                break;
            }
        }
    }

    private static void add(Scanner scanner, LinkedList<TelephoneProduct> linkedList) {
        System.out.println("1.nhập tên");
        scanner.nextLine();
        String name = scanner.nextLine();
        boolean check = true;
        int id;
        if (count >= 1) {
            do {
                System.out.println("2.nhập id");
                id = scanner.nextInt();
                for (int i = 0; i < linkedList.size(); i++) {
                    if (id == linkedList.get(i).getId()) {
                        System.out.println("id đã trùng");
                        check = false;
                        break;
                    }
                    check = true;
                }
            } while ( check == false );
        } else {
            System.out.println("2.nhập id");
            id = scanner.nextInt();
        }
        System.out.println("3.nhập giá");
        double price = scanner.nextDouble();
        linkedList.add(new TelephoneProduct(name, id, price));
    }


    private static void display() {
        System.out.println("1.thêm sản phẩm");
        System.out.println("2.sửa sản phẩm theo id");
        System.out.println("3.xóa sản phẩm theo id");
        System.out.println("4.hiển thị thông tin sản phẩm");
        System.out.println("5.tìm kiếm sản phẩm theo tên");
        System.out.println("6.sắp xếp giảm dần theo giá");
        System.out.println("7.sắp xếp tăng dần theo giá");
        System.out.println("8.EXIT");
    }
}

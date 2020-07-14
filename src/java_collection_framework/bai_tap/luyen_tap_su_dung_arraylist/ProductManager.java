package java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TelephoneProduct> arrayList = new ArrayList<>();
        while ( true ) {
            display();
            int chosse = scanner.nextInt();
            switch (chosse) {
                case 1: {
                    addProduct(scanner, arrayList);
                    count++;
                }
                break;
                case 2: {
                    editId(scanner, arrayList);
                }
                break;
                case 3: {
                    deleteProduct(scanner, arrayList);
                }
                break;
                case 4: {
                    for (TelephoneProduct a : arrayList) {
                        System.out.println(a);
                    }
                }
                break;
                case 5: {
                    seachProduct(scanner, arrayList);
                }
                break;
                case 6: {
                    Collections.sort(arrayList, new SortPriceIncrease());
                    System.out.println("sắp xếp giảm theo giá ok rồi");
                }
                break;
                case 7: {
                    Collections.sort(arrayList, new SortPriceIncrease());
                    System.out.println("sắp xếp tăng theo giá ok rồi");
                }
                break;
                default: {
                    System.out.println("lựa chọn không hợp lệ");
                }
            }
        }
    }

    private static void seachProduct(Scanner scanner, ArrayList<TelephoneProduct> arrayList) {
        scanner.nextLine();
        System.out.println("nhập tên sản phẩm cần tìm");
        String name = scanner.nextLine();
        for (TelephoneProduct telephoneProduct : arrayList) {
            if (name.equals(telephoneProduct.getName())) {
                System.out.println(telephoneProduct);
            }
            break;
        }
    }

    private static void deleteProduct(Scanner scanner, ArrayList<TelephoneProduct> arrayList) {
        System.out.println("nhập id sản phẩm cần xóa");
        int id = scanner.nextInt();
        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                arrayList.remove(arrayList.get(i));
                break;
            }
        }
    }

    private static void editId(Scanner scanner, ArrayList<TelephoneProduct> arrayList) {
        System.out.println("nhập id cần sửa");
        int id = scanner.nextInt();
        for (int i = 0; i < arrayList.size(); i++) {
            if (id == arrayList.get(i).getId()) {
                System.out.println("sửa tên");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("sửa id");
                int id1 = scanner.nextInt();
                System.out.println("sửa giá");
                double price = scanner.nextDouble();
                arrayList.set(i, new TelephoneProduct(name, id1, price));
                break;
            }
        }
    }

    private static void addProduct(Scanner scanner, ArrayList<TelephoneProduct> arrayList) {
        System.out.println("1.nhập tên");
        scanner.nextLine();
        String name = scanner.nextLine();
        boolean check = true;
        int id;
        if (count >= 1) {
            do {
                System.out.println("2.nhập id");
                id = scanner.nextInt();
                for (int i = 0; i < arrayList.size(); i++) {
                    if (id == arrayList.get(i).getId()) {
                        System.out.println("id đã trùng");
                        check = false;
                        break;
                    }check=true;
                }
            } while ( check==false );
        }else {
            System.out.println("2.nhập id");
            id = scanner.nextInt();
        }
        System.out.println("3.nhập giá");
        double price = scanner.nextDouble();
        arrayList.add(new TelephoneProduct(name, id, price));
    }

    private static void display() {
        System.out.println("1.thêm sản phẩm");
        System.out.println("2.sửa sản phẩm theo id");
        System.out.println("3.xóa sản phẩm theo id");
        System.out.println("4.hiển thị thông tin sản phẩm");
        System.out.println("5.tìm kiếm sản phẩm theo tên");
        System.out.println("6.sắp xếp giảm dần theo giá");
        System.out.println("7.sắp xếp tăng dần theo giá");
    }
}

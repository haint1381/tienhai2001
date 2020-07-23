package bai_hoc.io_binary_file_srialization.bai_tap.quan_li_san_pham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    static List<Product> productList = new ArrayList<>();
    static final String FILE_PATH = "D:\\Codegym\\src\\bai_hoc\\io_binary_file_srialization\\bai_tap\\quan_li_san_pham\\file_product";

    public static void writerFile(String filePath) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
        } catch (FileNotFoundException e) {
            System.err.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readerFile(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
           List<Product> product=(List<Product>)objectInputStream.readObject();
            for (Product product1 : product) {
                System.out.println("Produc:[ Id:" + product1.getId() + " Name: " + product1.getName() + " Brand: " + product1.getBrand() + " Price: " + product1.getPrice() + " ]");
            }
        } catch (FileNotFoundException e) {
            System.err.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Class Not Found");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while ( true ) {
            System.out.println("1.Add products ");
            System.out.println("2.Search product");
            System.out.println("3.Display product");
            System.out.println("4.Delete Product");
            System.out.println("5.Exit");
            int chosse = scanner.nextInt();
            switch (chosse) {
                case 1: {
                    System.out.println("1.input name");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    boolean check = true;
                    int id;
                    if (productList.size() >= 1) {
                        do {
                            System.out.println("2.input id");
                            id = scanner.nextInt();
                            for (int i = 0; i < productList.size(); i++) {
                                if (id == productList.get(i).getId()) {
                                    System.err.println("Duplicate code");
                                    check = false;
                                    break;
                                }
                                check = true;
                            }
                        } while ( !check );
                    } else {
                        System.out.println("2.input id");
                        id = scanner.nextInt();
                    }
                    scanner.nextLine();
                    System.out.println("3.input brand");
                    String brand = scanner.nextLine();
                    System.out.println("4.input price");
                    double price = scanner.nextDouble();
                    productList.add(new Product(id, name, brand, price));
                }
                break;
                case 2: {
                    scanner.nextLine();
                    System.out.println("Enter the product id to search");
                    int id = scanner.nextInt();
                    boolean check=true;
                    for (Product product : productList) {
                        if (id == (product.getId())) {
                            System.out.println(product);
                            check=true;
                            break;
                        } else {
                            check=false;
                        }
                    }
                    if(!check){
                        System.err.println("This product is unavailable");
                    }
                }
                break;
                case 3: {
                        readerFile(FILE_PATH);
                }
                break;
                case 4: {
                    System.out.println("Enter the product id to delete");
                    int id = scanner.nextInt();
                    for (int i = 0; i < productList.size(); i++) {
                        if (id == productList.get(i).getId()) {
                            productList.remove(productList.get(i));
                            break;
                        }
                    }
                }
                break;
                case 5: {
                    System.exit(0);
                }
            }
            writerFile(FILE_PATH);
        }
    }
}

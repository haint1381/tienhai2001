package bai_thi.controllers;

import bai_thi.commons.ReaderWriterFile;
import bai_thi.models.ExportProducts;
import bai_thi.models.ImportedProducts;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static Scanner scanner = new Scanner(System.in);
    public static int choose;
    public static String FILE_PRODUCT = "D:\\Codegym\\src\\bai_thi\\data\\product.csv";
    public static List<ExportProducts> exportProductsList = new ArrayList<>();
    public static List<ImportedProducts> importedProductsListt = new ArrayList<>();
    public static int count=1;
    public static void main(String[] args) {
        while ( choose < 1 || choose > 7 ) {
            displayMainMenu();
        }
    }

    public static void displayMainMenu() {
        System.out.println("Chọn chức năng theo số (để tiếp tục):\n" +
                "1. Thêm mới\n" +
                "2. Xóa\n" +
                "3. Xem danh sách các sản phẩm\n" +
                "4. Tìm kiếm\n" +
                "5. Thoát\n" +
                "Chọn chức năng:\n");
        choose = scanner.nextInt();
        switch (choose) {
            case 1:{
                System.out.println("1.sản phẩm xuất khẩu"+"\n"+
                        "2.sản phẩm nhập khẩu");
                int choice=scanner.nextInt();
                switch (choice){
                    case 1:{
                        addExportProducts();
                            ReaderWriterFile.writerFile(exportProductsList.get(0).getId()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(exportProductsList.get(0).getProductCode()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(exportProductsList.get(0).getName()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(exportProductsList.get(0).getPrice()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(exportProductsList.get(0).getAmount()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(exportProductsList.get(0).getProducer()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(exportProductsList.get(0).getExportOutput()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(exportProductsList.get(0).getCountry()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile("1",FILE_PRODUCT);
                            ReaderWriterFile.writerFile("\n",FILE_PRODUCT);
                        exportProductsList.clear();
                        displayMainMenu();
                    }break;
                    case 2:{
                        addImportedProducts();
                            ReaderWriterFile.writerFile(importedProductsListt.get(0).getId()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(importedProductsListt.get(0).getProductCode()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(importedProductsListt.get(0).getName()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(importedProductsListt.get(0).getPrice()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(importedProductsListt.get(0).getAmount()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(importedProductsListt.get(0).getProducer()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(importedProductsListt.get(0).getImportPrices()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(importedProductsListt.get(0).getProvince()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile(importedProductsListt.get(0).getImportTax()+",",FILE_PRODUCT);
                            ReaderWriterFile.writerFile("2",FILE_PRODUCT);
                            ReaderWriterFile.writerFile("\n",FILE_PRODUCT);
                        importedProductsListt.clear();
                        displayMainMenu();
                    }break;
                    default:{
                        System.out.println("Invalid selection");
                    }
                }
            }break;
            case 2:{
                deleteProduct();
                displayMainMenu();
            }break;
            case 3:{
                displayProduct();
                displayMainMenu();
            }break;
            case 4:{
                search();
                displayMainMenu();
            }break;
            case 5:{
                System.exit(0);
            }
            default:{
                System.out.println("Invalid selection");
            }
        }

    }

    private static void search() {
        scanner.nextLine();
        System.out.println("nhập mã sản phẩm để tìm kiếm");
        String code=scanner.nextLine();
        importedProductsListt.clear();
        exportProductsList.clear();
        ReaderWriterFile.readerFile(FILE_PRODUCT);
        for (int i=0;i<importedProductsListt.size();i++){
           if(code.equals(importedProductsListt.get(i).getProductCode())){
               System.out.println(importedProductsListt.get(i).showInfor());
               break;
           }
        }
        for (int i=0;i<exportProductsList.size();i++){
            if(code.equals(exportProductsList.get(i).getProductCode())){
                System.out.println(exportProductsList.get(i).showInfor());
                break;
            }
        }
    }

    private static void displayProduct() {
        importedProductsListt.clear();
        exportProductsList.clear();
        ReaderWriterFile.readerFile(FILE_PRODUCT);
        for (int i=0;i<importedProductsListt.size();i++){
            System.out.println(importedProductsListt.get(i).showInfor());
        }
        for (int i=0;i<exportProductsList.size();i++){
            System.out.println(exportProductsList.get(i).showInfor());
        }
    }

    private static void deleteProduct() {
        scanner.nextLine();
        System.out.println("nhập mã sản phẩm cần xóa: ");
        String code=scanner.nextLine();
        importedProductsListt.clear();
        exportProductsList.clear();
        ReaderWriterFile.readerFile(FILE_PRODUCT);
        for (int i=0;i<importedProductsListt.size();i++){
            if(code.equals(importedProductsListt.get(i).getProductCode())){
                importedProductsListt.remove(importedProductsListt.get(i));
                break;
            }
        }
        for (int i=0;i<exportProductsList.size();i++){
            if(code.equals(exportProductsList.get(i).getProductCode())){
                exportProductsList.remove(exportProductsList.get(i));
                break;
            }
            System.out.println("xóa thành công");
        }
        ReaderWriterFile.save("",FILE_PRODUCT);
        for (int i = 0; i < exportProductsList.size(); i++) {
            ReaderWriterFile.writerFile(exportProductsList.get(i).getId()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(exportProductsList.get(i).getProductCode()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(exportProductsList.get(i).getName()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(exportProductsList.get(i).getPrice()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(exportProductsList.get(i).getAmount()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(exportProductsList.get(i).getProducer()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(exportProductsList.get(i).getExportOutput()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(exportProductsList.get(i).getCountry()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile("1",FILE_PRODUCT);
            ReaderWriterFile.writerFile("\n",FILE_PRODUCT);
        }
        for (int i = 0; i < importedProductsListt.size(); i++) {
            ReaderWriterFile.writerFile(importedProductsListt.get(i).getId()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(importedProductsListt.get(i).getProductCode()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(importedProductsListt.get(i).getName()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(importedProductsListt.get(i).getPrice()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(importedProductsListt.get(i).getAmount()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(importedProductsListt.get(i).getProducer()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(importedProductsListt.get(i).getImportPrices()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(importedProductsListt.get(i).getProvince()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile(importedProductsListt.get(i).getImportTax()+",",FILE_PRODUCT);
            ReaderWriterFile.writerFile("2",FILE_PRODUCT);
            ReaderWriterFile.writerFile("\n",FILE_PRODUCT);
        }
    }

    private static void addExportProducts() {
        System.out.println("●\tThông tin cần thêm mới");
        int id=count++;
        scanner.nextLine();
        boolean check;
        System.out.println("Mã sản phẩm");

        String code=scanner.nextLine();
        System.out.println("Tên sản phẩm");
        String name=scanner.nextLine();


        String price;
        do {
            System.out.println("Giá bán");
            price=scanner.nextLine();
            if (price == null || !price.matches("^[1-9](\\.|\\d{0,})*$")) {
                check = false;
                System.err.println("giá bán không hợp lệ");
            } else {
                check = true;
            }
        } while ( !check );



        String num;

        do {
            System.out.println("Số lượng");
            num=scanner.nextLine();
            if (num == null || !num.matches("^[1-9](\\.|\\d{0,})*$")) {
                check = false;
                System.err.println("không hợp lệ");
            } else {
                check = true;
            }
        } while ( !check );

        System.out.println("Nhà sản xuất");
        String producer=scanner.nextLine();
        String price1;
        do {
            System.out.println("Giá xuất khẩu");
            price1=scanner.nextLine();
            if (price1 == null || !price1.matches("^[1-9](\\.|\\d{0,})*$")) {
                check = false;
                System.err.println("không hợp lệ");
            } else {
                check = true;
            }
        } while ( !check );
        System.out.println("quốc gia");
        String country=scanner.nextLine();
        exportProductsList.add(new ExportProducts(id,code,name,price,num,producer,price1,country));
    }

    private static void addImportedProducts() {
        System.out.println("●\tThông tin cần thêm mới");
        int id=count++;
        scanner.nextLine();
        System.out.println("Mã sản phẩm");
        String code=scanner.nextLine();
        System.out.println("Tên sản phẩm");
        String name=scanner.nextLine();
        String price;
        boolean check;
        do {
            System.out.println("Giá bán");
            price=scanner.nextLine();
            if (price == null || !price.matches("^[1-9](\\.|\\d{0,})*$")) {
                check = false;
                System.err.println("giá bán kg hợp lệ");
            } else {
                check = true;
            }
        } while ( !check );
        String num;
        do {
            System.out.println("Số lượng");
            num=scanner.nextLine();
            if (num == null || !num.matches("^[1-9](\\.|\\d{0,})*$")) {
                check = false;
                System.err.println("không hợp lệ");
            } else {
                check = true;
            }
        } while ( !check );
        System.out.println("Nhà sản xuất");
        String producer=scanner.nextLine();


        String price1;
        do {
            System.out.println("Giá nhập khẩu");
            price1=scanner.nextLine();
            if (price1 == null || !price1.matches("^[1-9](\\.|\\d{0,})*$")) {
                check = false;
                System.err.println("không hợp lệ");
            } else {
                check = true;
            }
        } while ( !check );
        System.out.println(" Tỉnh thành nhập.");
        String province=scanner.nextLine();
        String price2;
        do {
            System.out.println("Thuế nhập khẩu");
            price2=scanner.nextLine();
            if (price2 == null || !price2.matches("^[1-9](\\.|\\d{0,})*$")) {
                check = false;
                System.err.println("không hợp lệ");
            } else {
                check = true;
            }
        } while ( !check );

        importedProductsListt.add(new ImportedProducts(id,code,name,price,num,producer,price1,province,price2));
    }
}

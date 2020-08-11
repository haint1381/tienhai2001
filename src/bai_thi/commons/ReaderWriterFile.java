package bai_thi.commons;


import bai_thi.controllers.ProductManagement;
import bai_thi.models.ExportProducts;
import bai_thi.models.ImportedProducts;
import bai_thi.models.Product;

import java.io.*;

public class ReaderWriterFile {
    public static String[] arrayTemp;

    public static void readerFile(String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ( (line = bufferedReader.readLine()) != null ) {
                arrayTemp = line.split(",");
                if(arrayTemp[8].equals("1")){
                    int a =Integer.parseInt(ReaderWriterFile.arrayTemp[0]);
                    String b = ReaderWriterFile.arrayTemp[1];
                    String c =ReaderWriterFile.arrayTemp[2];
                    String d = ReaderWriterFile.arrayTemp[3];
                    String e = ReaderWriterFile.arrayTemp[4];
                    String f = ReaderWriterFile.arrayTemp[5];
                    String g = ReaderWriterFile.arrayTemp[6];
                    String h = ReaderWriterFile.arrayTemp[7];
                    ProductManagement.exportProductsList.add(new ExportProducts(a,b,c,d,e,f,g,h));
                }else {
                    int a =Integer.parseInt(ReaderWriterFile.arrayTemp[0]);
                    String b = ReaderWriterFile.arrayTemp[1];
                    String c =ReaderWriterFile.arrayTemp[2];
                    String d = ReaderWriterFile.arrayTemp[3];
                    String e = ReaderWriterFile.arrayTemp[4];
                    String f = ReaderWriterFile.arrayTemp[5];
                    String g = ReaderWriterFile.arrayTemp[6];
                    String h = ReaderWriterFile.arrayTemp[7];
                    String n = ReaderWriterFile.arrayTemp[8];
                    ProductManagement.importedProductsListt.add(new ImportedProducts(a,b,c,d,e,f,g,h,n));
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writerFile(String str, String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(str);

            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void save(String str, String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(str);

            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

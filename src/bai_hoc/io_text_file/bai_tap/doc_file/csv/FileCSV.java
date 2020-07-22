package bai_hoc.io_text_file.bai_tap.doc_file.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileCSV {
    public static void main(String[] args) {
        File file =new File("D:\\Codegym\\src\\bai_hoc\\io_text_file\\bai_tap\\doc_file\\csv\\fileCSV.txt");
        try {
            FileReader fileReader =new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            String[] arrayTemp;
            while ( (line=bufferedReader.readLine())!=null ){
                arrayTemp = line.split(",");
                System.out.println("Quốc gia [ mã: "+arrayTemp[4]+"  Tên: "+arrayTemp[5]+" ]");
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

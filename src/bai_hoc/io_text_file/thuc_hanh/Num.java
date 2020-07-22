package bai_hoc.io_text_file.thuc_hanh;

import java.io.*;

public class Num {
    public static void main(String[] args) {
        File file=new File("D:\\Codegym\\src\\bai_hoc\\io_text_file\\thuc_hanh\\ numbers.txt");
        try {
            FileReader fileReader =new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            int num = 0;
            while ((line= bufferedReader.readLine())!=null){
                num+=Integer.parseInt(line);
            }
            System.out.println("tổng: "+num);
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("sai");
        }
    }
}

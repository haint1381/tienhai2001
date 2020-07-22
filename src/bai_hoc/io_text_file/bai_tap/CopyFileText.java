package bai_hoc.io_text_file.bai_tap;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    static String result="";
    public static void readFileText(String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ( (line = bufferedReader.readLine()) != null ) {
                System.out.println(line);
                result+=line;
                result+="\n";
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Fie không tồn tại hoặc nội dung có lỗi!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writerFileText(String filePath) {
        File file1 =new File(filePath);
        try {
            FileWriter fileWriter=new FileWriter(file1);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(result);
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập tên file");
        String file=scanner.nextLine();
        readFileText(file);
        System.out.println("tạo tên file cần copy");
        String file1=scanner.nextLine();
        writerFileText(file1);
    }
}

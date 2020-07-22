package bai_hoc.io_text_file.bai_tap;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        File file1 =new File("hole.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter=new FileWriter(file1);
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
            String line = "";
            while ( (line = bufferedReader.readLine()) != null ) {
                System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();


            fileReader.close();
            bufferedReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package bai_hoc.io_binary_file_srialization.bai_tap.copy_file_nhi_phan;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFile {
    static List<Student> studentList = new ArrayList<>();
    static final String FILE_PATH ="hello1.txt";
    static final String FILE_PATH1 ="goodbye.txt";
    public static void writeFile(String filePath) {

        try {

            FileOutputStream   fos = new FileOutputStream(filePath);
            ObjectOutputStream   objectOutputStream = new ObjectOutputStream(fos);

            Student student1 = new Student("Toan", 25);
            Student student2 = new Student("Dat09", 29);
            Student student3 = new Student("Hai", 20);

            studentList.add(student1);
            studentList.add(student2);
            studentList.add(student3);
            objectOutputStream.writeObject(studentList);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fie không tồn tại hoặc nội dung có lỗi!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String filePath) {
        try {
            FileOutputStream newFos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream newObjectOutputStream=new ObjectOutputStream(newFos);

            FileInputStream  fis = new FileInputStream(filePath);
            ObjectInputStream   objectInputStream = new ObjectInputStream(fis);

            objectInputStream.readObject();

            for (Student student : studentList) {
                System.out.println(student.getName() + " " + student.getAge() );

                newObjectOutputStream.writeObject(student);
            }
            System.out.println("số byte "+filePath.length());
            objectInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("class không tồn tại");
        }
    }

    public static void main(String[] args) {
        writeFile(FILE_PATH);
        readFile(FILE_PATH);
    }
}

package bai_hoc.io_text_file;

import java.io.*;
import java.util.Arrays;

public class CharacterFile {
    public static void readFile() throws IOException {
        File file = new File("hello.txt");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] arrayTemp;
            while ((line = bufferedReader.readLine()) != null) {
                arrayTemp = line.split(",");
                System.out.println(Arrays.toString(arrayTemp));
            }
            bufferedReader.close();
            fileReader.close();

    }

    public static void writeFile() {
        File file = new File("hello.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Hien trum java 2\n");
            bufferedWriter.write("Hien trum java 3\n");
            bufferedWriter.write("Hien trum java 4\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile2(Student student) {
        File file = new File("hello.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(student.getName()).append(",").append(student.getAge()).append("\n");

            bufferedWriter.write(student.getName() + "," + student.getAge() + "\n");

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student("Hien", 25);
        Student student2 = new Student("Hai", 22);
        Student student3 = new Student("Dat", 29);
        writeFile2(student1);
        writeFile2(student2);
        writeFile2(student3);
    }
}
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

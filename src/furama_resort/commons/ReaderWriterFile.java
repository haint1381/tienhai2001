package furama_resort.commons;

import bai_hoc.java_collection_framework.thuc_hanh.hashmap_va_hashset.Main;
import furama_resort.controllers.MainController;
import furama_resort.libs.Customer;
import furama_resort.libs.Employee;
import furama_resort.models.House;
import furama_resort.models.Room;
import furama_resort.models.Services;
import furama_resort.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class ReaderWriterFile {
    public static String[] arrayTemp;
    public static Services services=null;
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
                if (filePath.equals(MainController.FILE_VILLA)) {
                    String id = ReaderWriterFile.arrayTemp[0];
                    String name = ReaderWriterFile.arrayTemp[1];
                    String area = ReaderWriterFile.arrayTemp[2];
                    String price = ReaderWriterFile.arrayTemp[3];
                    String numPeople = ReaderWriterFile.arrayTemp[4];
                    String typeOfRent = ReaderWriterFile.arrayTemp[5];
                    String kindOfRoom = ReaderWriterFile.arrayTemp[6];
                    String description = ReaderWriterFile.arrayTemp[7];
                    String poolArea = ReaderWriterFile.arrayTemp[8];
                    String numberOfFloors = ReaderWriterFile.arrayTemp[9];
                    MainController.villaList.add(new Villa(id, name, area, price, numPeople, typeOfRent, kindOfRoom, description, poolArea, numberOfFloors,"1"));
                } else if (filePath.equals(MainController.FILE_HOUSE)) {
                    String id = ReaderWriterFile.arrayTemp[0];
                    String name = ReaderWriterFile.arrayTemp[1];
                    String area = ReaderWriterFile.arrayTemp[2];
                    String price = ReaderWriterFile.arrayTemp[3];
                    String numPeople = ReaderWriterFile.arrayTemp[4];
                    String typeOfRent = ReaderWriterFile.arrayTemp[5];
                    String kindOfRoom = ReaderWriterFile.arrayTemp[6];
                    String description = ReaderWriterFile.arrayTemp[7];
                    String numberOfFloors = ReaderWriterFile.arrayTemp[8];
                    MainController.housesList.add(new House(id, name, area, price, numPeople, typeOfRent, kindOfRoom, description, numberOfFloors,"2"));
                } else if (filePath.equals(MainController.FILE_ROOM)) {
                    String id = ReaderWriterFile.arrayTemp[0];
                    String name = ReaderWriterFile.arrayTemp[1];
                    String area = ReaderWriterFile.arrayTemp[2];
                    String price = ReaderWriterFile.arrayTemp[3];
                    String numPeople = ReaderWriterFile.arrayTemp[4];
                    String typeOfRent = ReaderWriterFile.arrayTemp[5];
                    String freeService = ReaderWriterFile.arrayTemp[6];
                    MainController.roomsList.add(new Room(id, name, area, price, numPeople, typeOfRent, freeService,"3"));
                } else if (filePath.equals(MainController.FILE_CUS)) {
                    String name = ReaderWriterFile.arrayTemp[0];
                    String birthday = ReaderWriterFile.arrayTemp[1];
                    String gender = ReaderWriterFile.arrayTemp[2];
                    String id = ReaderWriterFile.arrayTemp[3];
                    String telephone = ReaderWriterFile.arrayTemp[4];
                    String email = ReaderWriterFile.arrayTemp[5];
                    String kindOfGuests = ReaderWriterFile.arrayTemp[6];
                    String address = ReaderWriterFile.arrayTemp[7];
                    MainController.customersList.add(new Customer(name, birthday, gender, id, telephone, email, kindOfGuests, address, services,"4"));
                }else {
                    String name = (ReaderWriterFile.arrayTemp[0]).toLowerCase();
                    String age = ReaderWriterFile.arrayTemp[1];
                    String adreess = ReaderWriterFile.arrayTemp[2];
                    MainController.employeeList.add(new Employee(name,age,adreess));
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

    public static void WriterFile(String str, String filePath) {
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
}

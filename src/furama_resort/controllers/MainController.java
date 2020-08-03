package furama_resort.controllers;

import bai_hoc.abstract_class_interface.baitap.trien_khai_interface_resizeable.Circle;
import furama_resort.commons.ReaderWriterFile;
import furama_resort.libs.*;
import furama_resort.models.House;
import furama_resort.models.Room;
import furama_resort.models.Services;
import furama_resort.models.Villa;

import java.util.*;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    public static final String FILE_VILLA = "D:\\Codegym\\src\\furama_resort\\data\\Villa.csv";
    public static final String FILE_HOUSE = "D:\\Codegym\\src\\furama_resort\\data\\House.csv";
    public static final String FILE_ROOM = "D:\\Codegym\\src\\furama_resort\\data\\Room.csv";
    public static final String FILE_CUS = "D:\\Codegym\\src\\furama_resort\\data\\Customer.csv";
    public static final String FILE_BOOK = "D:\\Codegym\\src\\furama_resort\\data\\Booking.csv";
    public static final String FILE_EMPLOYEE = "D:\\Codegym\\src\\furama_resort\\data\\Employee.csv";
    public static List<Villa> villaList = new ArrayList<>();
    public static List<House> housesList = new ArrayList<>();
    public static List<Room> roomsList = new ArrayList<>();
    public static List<Customer> customersList = new ArrayList<>();
    public static List<Employee> employeeList = new ArrayList<>();
    public static Queue<Customer> cinema = new LinkedList<>();
    static int choose;
    static int count;

    public static void main(String[] args) {
        while ( choose < 1 || choose > 7 ) {
            displayMainMenu();
        }
    }

    public static void displayMainMenu() {
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Add cinema");
        System.out.println("8. Search employee information");
        System.out.println("9. Exit");
        choose = scanner.nextInt();
        switch (choose) {
            case 1: {
                addNewServies();
            }
            break;
            case 2: {
                showServices();
            }
            break;
            case 3: {
                addNewCustomer();
                for (int i = customersList.size() - 1; i < customersList.size(); i++) {
                    ReaderWriterFile.WriterFile(customersList.get(i).getName() + ",", FILE_CUS);
                    ReaderWriterFile.WriterFile(customersList.get(i).getBirthday() + ",", FILE_CUS);
                    ReaderWriterFile.WriterFile(customersList.get(i).getGender() + ",", FILE_CUS);
                    ReaderWriterFile.WriterFile(customersList.get(i).getId() + ",", FILE_CUS);
                    ReaderWriterFile.WriterFile(customersList.get(i).getTelephone() + ",", FILE_CUS);
                    ReaderWriterFile.WriterFile(customersList.get(i).getEmail() + ",", FILE_CUS);
                    ReaderWriterFile.WriterFile(customersList.get(i).getKindOfGuests() + ",", FILE_CUS);
                    ReaderWriterFile.WriterFile(customersList.get(i).getAddress(), FILE_CUS);
                    ReaderWriterFile.WriterFile("\n", FILE_CUS);
                }
                displayMainMenu();
            }
            break;
            case 4: {
                showInformationCustomers();
            }
            break;
            case 5: {
                addNewBooking();
            }
            break;
            case 6: {
                ReaderWriterFile.readerFile(FILE_EMPLOYEE);
                Map<String, Employee> employeeMap = new TreeMap<>();
                for (int i = 0; i < employeeList.size(); i++) {
                    employeeMap.put("00" + (i + 1), employeeList.get(i));
                }
                for (String key : employeeMap.keySet()) {
                    System.out.println("ID: " + key + " Name: " + employeeMap.get(key).getName());
                }
                displayMainMenu();
            }
            break;
            case 7: {
                ticketBooking();
                count++;
                displayMainMenu();
            }
            break;
            case 8: {
                FilingCabinets.filingCabinets();
                FilingCabinets.searchEmployee();
                displayMainMenu();
            }
            break;
            case 9: {
                System.exit(0);
            }
            default: {
                System.err.print("Invalid selection");
            }
        }
    }


    private static void ticketBooking() {
        if (count < 5) {
            ReaderWriterFile.readerFile(FILE_CUS);
            for (int i = 0; i < customersList.size(); i++) {
                System.out.println((i + 1) + ". " + customersList.get(i).getName());
            }
            System.out.println("Enter the customer id to book a ticket:");
            scanner.nextLine();
            String id = scanner.nextLine();
            for (int i = 0; i < customersList.size(); i++) {
                if (id.equalsIgnoreCase(customersList.get(i).getId())) {
                    cinema.add(customersList.get(i));
                } else {
                    System.out.println("No customer id found");
                    ticketBooking();
                }
            }
            System.out.println("Book successfully");
            customersList.clear();
        } else {
            System.out.println("Movie tickets have run out");
            System.out.println("Customer list for tickets booked today");
            while ( !cinema.isEmpty() ) {
                System.out.println(cinema.poll().getName());
            }
        }
    }

    private static void addNewBooking() {
        ReaderWriterFile.readerFile(FILE_CUS);
        System.out.println("list of customers");
        for (int i = 0; i < customersList.size(); i++) {
            System.out.println((i + 1) + "." + customersList.get(i).getName());
        }
        int choice = scanner.nextInt();
        if ((choice - 1) <= customersList.size()) {
            System.out.println("1.\tBooking Villa\n" +
                    "2.\tBooking House\n" +
                    "3.\tBooking Room\n");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    ReaderWriterFile.readerFile(FILE_VILLA);
                    for (int j = 0; j < villaList.size(); j++) {
                        System.out.println((j + 1) + "." + villaList.get(j).getId());
                    }
                    int choose1 = scanner.nextInt();
                    for (int h = 0; h < villaList.size(); h++) {
                        if (h == (choose1 - 1)) {
                            customersList.get(choice - 1).setServices(villaList.get(h));
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getName() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getBirthday() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getGender() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getId() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getTelephone() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getEmail() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getKindOfGuests() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getAddress() + ",", FILE_BOOK);
                            /**thuộc tính service**/
                            ReaderWriterFile.WriterFile(villaList.get(h).getId() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(villaList.get(h).getName() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(villaList.get(h).getArea() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(villaList.get(h).getPrice() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(villaList.get(h).getPeopleMax() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(villaList.get(h).getTypeOfRent() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(villaList.get(h).getKindOfRoom() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(villaList.get(h).getDescription() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(villaList.get(h).getPoolArea() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(villaList.get(h).getNumberOfFloors(), FILE_BOOK);
                            ReaderWriterFile.WriterFile("\n", FILE_BOOK);
                        }
                    }
                }
                customersList.clear();
                addNewBooking();
                break;
                case 2: {
                    ReaderWriterFile.readerFile(FILE_HOUSE);
                    for (int j = 0; j < housesList.size(); j++) {
                        System.out.println((j + 1) + "." + housesList.get(j).getId());
                    }
                    int choose1 = scanner.nextInt();
                    for (int h = 0; h < housesList.size(); h++) {
                        if ((choose1 - 1) == h) {
                            customersList.get(choice - 1).setServices(housesList.get(h));
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getName() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getBirthday() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getGender() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getId() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getTelephone() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getEmail() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getKindOfGuests() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getAddress() + ",", FILE_BOOK);
                            /**thuộc tính service**/
                            ReaderWriterFile.WriterFile(housesList.get(h).getId() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(housesList.get(h).getName() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(housesList.get(h).getArea() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(housesList.get(h).getPrice() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(housesList.get(h).getPeopleMax() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(housesList.get(h).getTypeOfRent() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(housesList.get(h).getKindOfRoom() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(housesList.get(h).getDescription() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(housesList.get(h).getNumberOfFloors(), FILE_BOOK);
                            ReaderWriterFile.WriterFile("\n", FILE_BOOK);
                        }
                    }
                }
                customersList.clear();
                addNewBooking();
                break;
                case 3: {
                    ReaderWriterFile.readerFile(FILE_ROOM);
                    for (int j = 0; j < roomsList.size(); j++) {
                        System.out.println((j + 1) + "." + roomsList.get(j).getId());
                    }
                    int choose1 = scanner.nextInt();
                    for (int h = 0; h < roomsList.size(); h++) {
                        if ((choose1 - 1) == h) {
                            customersList.get(choice - 1).setServices(roomsList.get(h));
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getName() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getBirthday() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getGender() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getId() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getTelephone() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getEmail() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getKindOfGuests() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(customersList.get(choice - 1).getAddress() + ",", FILE_BOOK);
                            /**thuộc tính service**/
                            ReaderWriterFile.WriterFile(roomsList.get(h).getId() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(roomsList.get(h).getName() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(roomsList.get(h).getArea() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(roomsList.get(h).getPrice() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(roomsList.get(h).getPeopleMax() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(roomsList.get(h).getTypeOfRent() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(roomsList.get(h).getFreeService().getName() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(roomsList.get(h).getFreeService().getUnit() + ",", FILE_BOOK);
                            ReaderWriterFile.WriterFile(String.valueOf(roomsList.get(h).getFreeService().getPrice()), FILE_BOOK);
                            ReaderWriterFile.WriterFile("\n", FILE_BOOK);
                        }
                    }
                }
                customersList.clear();
                addNewBooking();
                break;
                default: {
                    System.err.print("Invalid selection");
                }
            }

        }

    }

    private static void showInformationCustomers() {
        ReaderWriterFile.readerFile(FILE_CUS);
        customersList.sort(new SortCustomer());
        for (Customer customer : customersList) {
            System.out.println(customer.showInfor());
            System.out.println("-----");
        }
        displayMainMenu();
    }

    private static void addNewCustomer() {
        scanner.nextLine();
        boolean check;
        String name;
        do {
            System.out.print("Name Customer: ");
            name = scanner.nextLine();
            if (name == null || !name.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid name!");
            } else {
                check = true;
            }
        } while ( !check );


        String birthday;
        do {
            System.out.print("Input birthday customer: ");
            birthday = scanner.nextLine();
            if (birthday == null || !birthday.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.]((19\\d{2})|(200[12]))$")) {
                check = false;

                System.err.println("Invalid birthday!");
            } else {
                check = true;
            }
        } while ( !check );

        String gender;
        String str;
        String str1;

        do {
            System.out.print("Input gender customer: ");
            gender = scanner.nextLine();
            if (gender == null) {
                check = false;
                System.err.println("Null");
            } else {
                str1 = gender.trim();
                str = str1.toLowerCase();
                gender = (String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1));
                if (!gender.matches("^((Fem|M)ale)|(Unknow)$")) {
                    check = false;
                    System.err.println("Invalid gender!");
                } else {
                    check = true;
                }
            }
        } while ( !check );


        String id;
        boolean check1=true;
        do {
            System.out.print("Input id customer: ");
            id = scanner.nextLine();

            ReaderWriterFile.readerFile(FILE_CUS);
            for (int i=0;i<customersList.size();i++){
                if(id.equals(customersList.get(i).getId())){
                    check1=false;
                }else {
                    check1=true;
                }
            }
            if(!check1){
                System.err.println("duplicate id!");
            }
            if (id == null || !id.matches("^([1-9])(\\d{8})$")) {
                check = false;
                System.err.println("Invalid id!");
            } else {
                check = true;
            }
        } while ( !check ||!check1);
        String telephone;
        do {
            System.out.print("Input telephone customer: ");
            telephone = scanner.nextLine();
            if (telephone == null || !telephone.matches("^ (0[1-9]\\d{8})$")) {
                check = false;
                System.err.println("Invalid telephone!");
            } else {
                check = true;
            }
        } while ( !check );

        String email;
        do {
            System.out.print("Input email customer: ");
            email = scanner.nextLine();
            if (email == null || !email.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$")) {
                check = false;
                System.err.println("Invalid email!");
            } else {
                check = true;
            }
        } while ( !check );

        System.out.print("Input Kind Of Guests customer: ");
        String kindOfGuests = scanner.nextLine();
        System.out.print("Input address customer: ");
        String address = scanner.nextLine();
        customersList.add(new Customer(name, birthday, gender, id, telephone, email, kindOfGuests, address, null, "4"));
    }

    private static void showServices() {
        System.out.println("1. Show all Villa");
        System.out.println("2. Show all House");
        System.out.println("3. Show all Room");
        System.out.println("4. Show All Name Villa Not Duplicate");
        System.out.println("5. Show All Name House Not Duplicate");
        System.out.println("6. Show All Name Name Not Duplicate");
        System.out.println("7. Back to menu");
        System.out.println("8. Exit");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1: {
                showAllVilla();
                displayMainMenu();
            }
            break;
            case 2: {
                showAllHouse();
                displayMainMenu();
            }
            break;
            case 3: {
                showAllRoom();
                displayMainMenu();
            }
            break;
            case 4: {
                ReaderWriterFile.readerFile(FILE_VILLA);
                TreeSet<String> villaTreeSet = new TreeSet<>();
                for (int i = 0; i < villaList.size(); i++) {
                    villaTreeSet.add(villaList.get(i).getName());
                }
                System.out.println("list Name Villa Not Duplicate");
                for (String name : villaTreeSet) {
                    System.out.println(name);
                }
            }
            break;
            case 5: {
                ReaderWriterFile.readerFile(FILE_HOUSE);
                TreeSet<String> houseTreeSet = new TreeSet<>();
                for (int i = 0; i < housesList.size(); i++) {
                    houseTreeSet.add(housesList.get(i).getName());
                }
                System.out.println("list Name house Not Duplicate");
                for (String name : houseTreeSet) {
                    System.out.println(name);
                }
            }
            break;
            case 6: {
                ReaderWriterFile.readerFile(FILE_ROOM);
                TreeSet<String> roomTreeSet = new TreeSet<>();
                for (int i = 0; i < roomsList.size(); i++) {
                    roomTreeSet.add(roomsList.get(i).getName());
                }
                System.out.println("list Name room Not Duplicate");
                for (String name : roomTreeSet) {
                    System.out.println(name);
                }
            }
            break;
            case 7: {
                displayMainMenu();
            }
            break;
            case 8: {
                System.exit(0);
            }
            default: {
                System.out.println("Invalid selection");
            }

        }
    }

    private static void showAllRoom() {
        ReaderWriterFile.readerFile(FILE_ROOM);
        for (Room room : roomsList) {
            System.out.println(room.showInfor());
        }
    }

    private static void showAllHouse() {
        ReaderWriterFile.readerFile(FILE_HOUSE);
        for (House house : housesList) {
            System.out.println(house.showInfor());
        }
    }

    public static void showAllVilla() {
        ReaderWriterFile.readerFile(FILE_VILLA);
        for (Villa villa : villaList) {
            System.out.println(villa.showInfor());
        }
    }

    public static void addNewServies() {
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1: {
                addNewVilla();
                for (int i = villaList.size() - 1; i < villaList.size(); i++) {
                    ReaderWriterFile.WriterFile(villaList.get(i).getId() + ",", FILE_VILLA);
                    ReaderWriterFile.WriterFile(villaList.get(i).getName() + ",", FILE_VILLA);
                    ReaderWriterFile.WriterFile(villaList.get(i).getArea() + ",", FILE_VILLA);
                    ReaderWriterFile.WriterFile(villaList.get(i).getPrice() + ",", FILE_VILLA);
                    ReaderWriterFile.WriterFile(villaList.get(i).getPeopleMax() + ",", FILE_VILLA);
                    ReaderWriterFile.WriterFile(villaList.get(i).getTypeOfRent() + ",", FILE_VILLA);
                    ReaderWriterFile.WriterFile(villaList.get(i).getKindOfRoom() + ",", FILE_VILLA);
                    ReaderWriterFile.WriterFile(villaList.get(i).getDescription() + ",", FILE_VILLA);
                    ReaderWriterFile.WriterFile(villaList.get(i).getPoolArea() + ",", FILE_VILLA);
                    ReaderWriterFile.WriterFile(villaList.get(i).getNumberOfFloors() + ",", FILE_VILLA);
                    ReaderWriterFile.WriterFile("1", FILE_VILLA);
                    ReaderWriterFile.WriterFile("\n", FILE_VILLA);
                }
                villaList.clear();
                addNewServies();
            }
            break;
            case 2: {
                addNewHouse();
                for (int i = 0; i < housesList.size(); i++) {
                    ReaderWriterFile.WriterFile(housesList.get(i).getId() + ",", FILE_HOUSE);
                    ReaderWriterFile.WriterFile(housesList.get(i).getName() + ",", FILE_HOUSE);
                    ReaderWriterFile.WriterFile(housesList.get(i).getArea() + ",", FILE_HOUSE);
                    ReaderWriterFile.WriterFile(housesList.get(i).getPrice() + ",", FILE_HOUSE);
                    ReaderWriterFile.WriterFile(housesList.get(i).getPeopleMax() + ",", FILE_HOUSE);
                    ReaderWriterFile.WriterFile(housesList.get(i).getTypeOfRent() + ",", FILE_HOUSE);
                    ReaderWriterFile.WriterFile(housesList.get(i).getKindOfRoom() + ",", FILE_HOUSE);
                    ReaderWriterFile.WriterFile(housesList.get(i).getDescription() + ",", FILE_HOUSE);
                    ReaderWriterFile.WriterFile(housesList.get(i).getNumberOfFloors(), FILE_HOUSE);
                    ReaderWriterFile.WriterFile("2", FILE_HOUSE);
                    ReaderWriterFile.WriterFile("\n", FILE_HOUSE);
                }
                housesList.clear();
                addNewServies();
            }
            case 3: {
                addNewRoom();
                for (int i = 0; i < roomsList.size(); i++) {
                    ReaderWriterFile.WriterFile(roomsList.get(i).getId() + ",", FILE_ROOM);
                    ReaderWriterFile.WriterFile(roomsList.get(i).getName() + ",", FILE_ROOM);
                    ReaderWriterFile.WriterFile(roomsList.get(i).getArea() + ",", FILE_ROOM);
                    ReaderWriterFile.WriterFile(roomsList.get(i).getPrice() + ",", FILE_ROOM);
                    ReaderWriterFile.WriterFile(roomsList.get(i).getPeopleMax() + ",", FILE_ROOM);
                    ReaderWriterFile.WriterFile(roomsList.get(i).getTypeOfRent() + ",", FILE_ROOM);
                    ReaderWriterFile.WriterFile(roomsList.get(i).getFreeService().getName() + ",", FILE_ROOM);
                    ReaderWriterFile.WriterFile(roomsList.get(i).getFreeService().getUnit() + ",", FILE_ROOM);
                    ReaderWriterFile.WriterFile(String.valueOf(roomsList.get(i).getFreeService().getPrice()), FILE_ROOM);
                    ReaderWriterFile.WriterFile("3", FILE_ROOM);
                    ReaderWriterFile.WriterFile("\n", FILE_ROOM);
                }
                roomsList.clear();
                addNewServies();
            }
            break;
            case 4: {
                displayMainMenu();
            }
            case 5: {
                System.exit(0);
            }
            default: {
                System.out.println("Invalid selection");
            }
        }
    }

    public static void addNewVilla() {
        scanner.nextLine();

        ReaderWriterFile.readerFile(FILE_VILLA);
        String id;
        boolean check;
        boolean check1 = true;
        do {
            System.out.print("1.ID Services(Villa): ");
            id = scanner.nextLine();

            for (int i = 0; i < villaList.size(); i++) {
                if (id.equals(villaList.get(i).getId())) {
                    check1 = false;
                    break;
                } else {
                    check1 = true;
                }
            }
            if(!check1){
                System.err.println("duplicate id!");
            }
            if (id == null || !id.matches("^SVVL-\\d{4}$")) {
                check = false;
                System.err.println("Invalid id!");
            } else {
                check = true;
            }
        } while ( !check || !check1 );

        String name;
        do {
            System.out.print("2.Name Services(Villa): ");
            name = scanner.nextLine();
            if (name == null || !name.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid name!");
            } else {
                check = true;
            }
        } while ( !check );
        String area;
        do {
            System.out.print("3.Area Used(Villa): ");
            area = scanner.nextLine();
            if (area == null || !area.matches("^([3-9])(\\.|[0-9]){1,9}$")) {
                check = false;
                System.err.println("must be a real number greater than 30m2");
            } else {
                check = true;
            }
        } while ( !check );

        String price;
        do {
            System.out.print("4.Rental Costs(Villa): ");
            price = scanner.nextLine();
            if (price == null || !price.matches("^([1-9]{1,9})?((\\.|[0-9]){1,9})$")) {
                check = false;
                System.err.println("Must be a positive number");
            } else {
                check = true;
            }
        } while ( !check );

        String numPeople;
        do {
            System.out.print("5.Maximum number of people(Villa): ");
            numPeople = scanner.nextLine();
            if (numPeople == null || !numPeople.matches("^([1-9])|(1([0-9]))|(20)$")) {
                check = false;
                System.err.println("The number of people must be between 1 and 20");
            } else {
                check = true;
            }
        } while ( !check );
        String typeOfRent;
        do {
            System.out.print("6.Rental services(Villa): ");
            typeOfRent = scanner.nextLine();
            if (typeOfRent == null || !typeOfRent.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid Rental services!");
            } else {
                check = true;
            }
        } while ( !check );
        String kindOfRoom;
        do {
            System.out.print("7.Kind of room(Villa): ");
            kindOfRoom = scanner.nextLine();
            if (kindOfRoom == null || !kindOfRoom.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid Kind of room!");
            } else {
                check = true;
            }
        } while ( !check );
        String description;
        do {
            System.out.print("8.Description(Villa): ");
            description = scanner.nextLine();
            if (description == null || !description.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid Description!");
            } else {
                check = true;
            }
        } while ( !check );

        String poolArea;
        do {
            System.out.print("9.Pool area(Villa): ");
            poolArea = scanner.nextLine();
            if (poolArea == null || !poolArea.matches("^([12]\\d{2})|(([3-9][0-9])(\\.|\\d{0,})*)$")) {
                check = false;
                System.err.println("must be a real number greater than 30m2");
            } else {
                check = true;
            }
        } while ( !check );

        String numberOfFloors;
        do {
            System.out.print("10.Number of floors(Villa): ");
            numberOfFloors = scanner.nextLine();
            if (numberOfFloors == null || !numberOfFloors.matches("^[1-9]{1,9}$")) {
                check = false;
                System.err.println("Must be a positive number");
            } else {
                check = true;
            }
        } while ( !check );

        System.out.print("11.input name accompanied Service");
        String name1=scanner.nextLine();
        System.out.print("12.input Unit");
        int unit=scanner.nextInt();
        System.out.print("12.input price");
        double price1 =scanner.nextDouble();

        villaList.add(new Villa(id, name, area, price, numPeople, typeOfRent, kindOfRoom, description, poolArea, numberOfFloors, "3"));
    }

    public static void addNewHouse() {
        scanner.nextLine();
        ReaderWriterFile.readerFile(FILE_HOUSE);
        String id;
        boolean check;
        boolean check1 = true;
        do {
            System.out.print("1.ID Services(house): ");
            id = scanner.nextLine();

            for (int i = 0; i < housesList.size(); i++) {
                if (id.equals(housesList.get(i).getId())) {
                    check1 = false;
                    break;
                } else {
                    check1 = true;
                }
            }
            if(!check1){
                System.err.println("duplicate id!");
            }
            if (id == null || !id.matches("^SVVL-\\d{4}$")) {
                check = false;
                System.err.println("Invalid id!");
            } else {
                check = true;
            }
        } while ( !check || !check1 );
        String name;
        do {
            System.out.print("2.Name Services(Villa): ");
            name = scanner.nextLine();
            if (name == null || !name.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid name!");
            } else {
                check = true;
            }
        } while ( !check );
        String area;
        do {
            System.out.print("3.Area Used(Villa): ");
            area = scanner.nextLine();
            if (area == null || !area.matches("^([3-9])(\\.|[0-9]){1,9}$")) {
                check = false;
                System.err.println("must be a real number greater than 30m2");
            } else {
                check = true;
            }
        } while ( !check );

        String price;
        do {
            System.out.print("4.Rental Costs(Villa): ");
            price = scanner.nextLine();
            if (price == null || !price.matches("^([1-9]{1,9})?((\\.|[0-9]){1,9})$")) {
                check = false;
                System.err.println("Must be a positive number");
            } else {
                check = true;
            }
        } while ( !check );

        String numPeople;
        do {
            System.out.print("5.Maximum number of people(Villa): ");
            numPeople = scanner.nextLine();
            if (numPeople == null || !numPeople.matches("^([1-9])|(1([0-9]))|(20)$")) {
                check = false;
                System.err.println("The number of people must be between 1 and 20");
            } else {
                check = true;
            }
        } while ( !check );
        String typeOfRent;
        do {
            System.out.print("6.Rental services(Villa): ");
            typeOfRent = scanner.nextLine();
            if (typeOfRent == null || !typeOfRent.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid Rental services!");
            } else {
                check = true;
            }
        } while ( !check );
        String kindOfRoom;
        do {
            System.out.print("7.Kind of room(Villa): ");
            kindOfRoom = scanner.nextLine();
            if (kindOfRoom == null || !kindOfRoom.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid Kind of room!");
            } else {
                check = true;
            }
        } while ( !check );
        String description;
        do {
            System.out.print("8.Description(Villa): ");
            description = scanner.nextLine();
            if (description == null || !description.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid Description!");
            } else {
                check = true;
            }
        } while ( !check );

        String numberOfFloors;
        do {
            System.out.print("10.Number of floors(Villa): ");
            numberOfFloors = scanner.nextLine();
            if (numberOfFloors == null || !numberOfFloors.matches("^[1-9]{1,9}$")) {
                check = false;
                System.err.println("Must be a positive number");
            } else {
                check = true;
            }
        } while ( !check );
        housesList.add(new House(id, name, area, price, numPeople, typeOfRent, kindOfRoom, description, numberOfFloors, "2"));
    }

    public static void addNewRoom() {
        scanner.nextLine();
        ReaderWriterFile.readerFile(FILE_ROOM);
        String id;
        boolean check;
        boolean check1 = true;
        do {
            System.out.print("1.ID Services(room): ");
            id = scanner.nextLine();

            for (int i = 0; i < roomsList.size(); i++) {
                if (id.equals(roomsList.get(i).getId())) {
                    check1 = false;
                    break;
                } else {
                    check1 = true;
                }
            }
            if(!check1){
                System.err.println("duplicate id!");
            }
            if (id == null || !id.matches("^SVVL-\\d{4}$")) {
                check = false;
                System.err.println("Invalid id!");
            } else {
                check = true;
            }
        } while ( !check || !check1 );
        String name;
        do {
            System.out.print("2.Name Services(Villa): ");
            name = scanner.nextLine();
            if (name == null || !name.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid name!");
            } else {
                check = true;
            }
        } while ( !check );
        String area;
        do {
            System.out.print("3.Area Used(Villa): ");
            area = scanner.nextLine();
            if (area == null || !area.matches("^([3-9])(\\.|[0-9]){1,9}$")) {
                check = false;
                System.err.println("must be a real number greater than 30m2");
            } else {
                check = true;
            }
        } while ( !check );

        String price;
        do {
            System.out.print("4.Rental Costs(Villa): ");
            price = scanner.nextLine();
            if (price == null || !price.matches("^([1-9]{1,9})?((\\.|[0-9]){1,9})$")) {
                check = false;
                System.err.println("Must be a positive number");
            } else {
                check = true;
            }
        } while ( !check );

        String numPeople;
        do {
            System.out.print("5.Maximum number of people(Villa): ");
            numPeople = scanner.nextLine();
            if (numPeople == null || !numPeople.matches("^([1-9])|(1([0-9]))|(20)$")) {
                check = false;
                System.err.println("The number of people must be between 1 and 20");
            } else {
                check = true;
            }
        } while ( !check );
        String typeOfRent;
        do {
            System.out.print("6.Rental services(Villa): ");
            typeOfRent = scanner.nextLine();
            if (typeOfRent == null || !typeOfRent.matches("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$")) {
                check = false;
                System.err.println("Invalid Rental services!");
            } else {
                check = true;
            }
        } while ( !check );

        AccompaniedService freeService;

            System.out.print("7.Includes free service(Room): ");

        String name1;
        String name2;
        do {
            System.out.println("a.input name: ");
            name2=scanner.nextLine();
            name1=name2.toLowerCase();
            if (name1 == null || !name1.matches("^(massage)|(karaoke)|(food)|(drink)|(car)$")) {
                check = false;
                System.err.println("Invalid name!");
            } else {
                check = true;
            }
        } while ( !check );

            System.out.println("b.input Unit: ");
            int unit=scanner.nextInt();
            System.out.println("b.input price: ");
            double price1=scanner.nextDouble();
            freeService=new AccompaniedService(name1,unit,price1);
        roomsList.add(new Room(id, name, area, price, numPeople, typeOfRent, freeService, "1"));
    }
}

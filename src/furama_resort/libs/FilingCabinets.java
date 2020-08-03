package furama_resort.libs;

import furama_resort.commons.ReaderWriterFile;
import furama_resort.controllers.MainController;

import java.util.Scanner;
import java.util.Stack;

public class FilingCabinets {
    public static Scanner scanner = new Scanner(System.in);
    public static Stack<Employee> employeeStack=new Stack<>();
    public static void filingCabinets(){
        ReaderWriterFile.readerFile(MainController.FILE_EMPLOYEE);
        for (int i=0;i<MainController.employeeList.size();i++){
            employeeStack.push(MainController.employeeList.get(i));
        }
    }
    public static void searchEmployee() {
        System.out.println("input name employee");
        String name=scanner.nextLine();
        String name1=name.toLowerCase();
        while ( !employeeStack.isEmpty() ){
            if(name1.equals(employeeStack.pop().getName())){
                System.out.println(employeeStack.peek().toString());
            }
        }
    }
}

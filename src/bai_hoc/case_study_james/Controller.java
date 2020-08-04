package bai_hoc.case_study_james;

import java.util.Scanner;

public class Controller {
    public static Scanner scanner=new Scanner(System.in);
    public static String FILE_DICTIONARY="D:\\Codegym\\src\\bai_hoc\\case_study_james\\dictionary.csv";
    static int choice;
    public static void main(String[] args) {
        while ( choice<1 || choice>5 ){
            displayMenu();
        }
    }
    private static void displayMenu() {
        System.out.println("1.look up words"+"\n"+
                "2.Additional definitions for an entry"+"\n"+
                "3.delete an item from"+"\n"+
                "4.Export dictionary database"+"\n"+
                "5.Exit");
        choice=scanner.nextInt();
        switch (choice){
            case 1:{
                ReaderWriterFile.readerFile(FILE_DICTIONARY);

            }
            break;
            case 2:
            case 3:
            case 4:
            case 5:
            default:{
                System.err.println("invalidate selection");
            }
        }
    }
}

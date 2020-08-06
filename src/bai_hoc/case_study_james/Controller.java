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
                scanner.nextLine();
                System.out.println("Enter the word to search");
                String work=scanner.nextLine();
                Comons.lookup(work);
            }
            break;
            case 2:{
                scanner.nextLine();
                System.out.println("enter the word");
                String work=scanner.nextLine();
                System.out.println("enter the mean");
                String mean=scanner.nextLine();
                Comons.additionalDictionary(work,mean);
            }break;
            case 3:{
                scanner.nextLine();
                System.out.println("enter the word");
                String work=scanner.nextLine();
                Comons.delete(work);
            }break;
            case 4:{
                Comons.dictionaryList.clear();
                Comons.exportDictionaryDatabase();
                for (int i = 0; i < Comons.dictionaryList.size(); i++) {
                        System.out.println( Comons.dictionaryList.get(i).getWork()+" does that mean: "+Comons.dictionaryList.get(i).getMean());
                }
            }break;
            case 5:
            default:{
                System.err.println("invalidate selection");
            }
        }
    }
}

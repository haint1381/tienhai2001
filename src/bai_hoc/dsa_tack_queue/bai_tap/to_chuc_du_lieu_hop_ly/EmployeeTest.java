package bai_hoc.dsa_tack_queue.bai_tap.to_chuc_du_lieu_hop_ly;

import java.util.*;


public class EmployeeTest {
    public static void main(String[] args) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        ArrayList<Employee> arrayList1 = new ArrayList<>();
        Queue<Employee> nu = new LinkedList<>();
        Queue<Employee> nam = new LinkedList<>();
        Employee nu1 = new Employee("mai", "nu", 16);
        Employee nu2 = new Employee("hoa", "nu", 25);
        Employee nu3 = new Employee("lan", "nu", 34);
        Employee nam1 = new Employee("hai", "nam", 20);
        Employee nam2 = new Employee("nhat", "nam", 21);
        Employee nam3 = new Employee("đạt", "nam", 22);
        arrayList.add(nu1);
        arrayList.add(nu2);
        arrayList.add(nu3);
        arrayList.add(nam1);
        arrayList.add(nam2);
        arrayList.add(nam3);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getGender() == "nu") {
                nu.add(arrayList.get(i));
            } else {
                nam.add(arrayList.get(i));
            }
        }
        Collections.sort(arrayList, new SortAge());
        for (Employee x : arrayList) {
            System.out.println(x);
        }
        System.out.println("----------");

        while ( !nu.isEmpty() ) {
            arrayList1.add(nu.poll());
        }
        while ( !nam.isEmpty() ) {
            arrayList1.add(nam.poll());
        }
        for (Employee x : arrayList1) {
            System.out.println(x);
        }
    }
}

package dsa_tack_queue.bai_tap.to_chuc_du_lieu_hop_ly;

import java.util.Comparator;

public class SortAge implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        } else return 0;
    }
}

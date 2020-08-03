package furama_resort.libs;

import java.util.Comparator;

public class SortCustomer implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
       int year1= Integer.parseInt(o1.getBirthday().substring(6,10));
        int year2= Integer.parseInt(o2.getBirthday().substring(6,10));
        if(o1.getName().equals(o2.getName())){
           return year2-year1;
        }else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

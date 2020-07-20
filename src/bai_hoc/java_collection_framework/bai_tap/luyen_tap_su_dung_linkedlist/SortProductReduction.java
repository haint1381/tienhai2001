package bai_hoc.java_collection_framework.bai_tap.luyen_tap_su_dung_linkedlist;

import bai_hoc.java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist.TelephoneProduct;

import java.util.Comparator;

public class SortProductReduction implements Comparator<TelephoneProduct> {
    @Override
    public int compare(TelephoneProduct o1, TelephoneProduct o2) {
        if(o1.getPrice()<o2.getPrice()){
            return 1;
        }else if(o1.getPrice()>o2.getPrice()){
            return -1;
        }else {
            return 0;
        }
    }
}

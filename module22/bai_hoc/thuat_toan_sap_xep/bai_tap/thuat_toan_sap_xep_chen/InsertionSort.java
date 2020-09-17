package bai_hoc.thuat_toan_sap_xep.bai_tap.thuat_toan_sap_xep_chen;

public class InsertionSort {
    public static void InsertionSort(int[] list) {

        for (int i = 0; i < list.length; i++) {
            int key = list[i];
           int  temp=-1;
            for ( int j = i - 1; j >= 0 && list[j] > key; j--) {
                list[j + 1] = list[j];
                temp=j;
            }
            if(temp!=-1)
            list[temp] = key;
        }
    }
    public static void main(String[] args) {
        int[] list = {12, 11, 13, 5, 6};
        InsertionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}

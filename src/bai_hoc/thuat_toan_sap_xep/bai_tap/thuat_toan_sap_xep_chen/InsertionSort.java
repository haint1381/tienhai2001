package bai_hoc.thuat_toan_sap_xep.bai_tap.thuat_toan_sap_xep_chen;

public class InsertionSort {
    public static void InsertionSort(int[] list, int number) {

        for (int i = 0; i < list.length; i++) {
            int key = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > key; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = key;
        }
        int index=0;
        for (int i = 0; i < list.length; i++) {
            if (number < list[i]) ;
          index=i;
          break;
        }
        for (int j=list.length-1;j>index;j--){
            list[j]=list[j-1];
        }
        list[index]=number;
    }
    public static void main(String[] args) {
        int[] list = {12, 11, 13, 5, 6};
        InsertionSort(list, 4);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}

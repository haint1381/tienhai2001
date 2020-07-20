package bai_hoc.dsa_danh_sach.thuc_hanh.trien_khai_lop_list_don_gian;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.addlast(1);
        listInteger.addlast(3);
        listInteger.addlast(2);
        listInteger.addlast(6);
        listInteger.addlast(4);
        for (int i=0;i<listInteger.getSize();i++){
            System.out.println(listInteger.get(i));
        }
        listInteger.addFirst(9);
        System.out.println("helllo");
        for (int i=0;i<listInteger.getSize();i++){
            System.out.println(listInteger.get(i));
        }
    }
}
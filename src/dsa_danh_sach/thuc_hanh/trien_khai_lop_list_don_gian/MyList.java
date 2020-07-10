package dsa_danh_sach.thuc_hanh.trien_khai_lop_list_don_gian;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 1;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void addlast(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    public void addFirst(E e){
        if (size == elements.length) {
            ensureCapa();
        }
        size++;
        for (int i=size;i>0;i--){
            elements[i]=elements[i-1];
        }
        elements[0]=e;
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
    public int getSize(){
        return size;
    }

}
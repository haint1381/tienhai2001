package dsa_danh_sach.bai_tap.trien_khai_cac_phuong_thuc_arayList;

import java.util.Arrays;

public class MyList {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size) {
        elements = new Object[size];
    }

    public void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void addLast(Object e) {
        if (elements.length == size) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public Object get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        } else return null;
    }

    public void add(int index, Object element) {
        if (elements.length == size) {
            ensureCapa();
        }
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
        }
    }

    public Object clone() {
        MyList clone = new MyList(elements.length);
        for (Object a : elements) {
            clone.addLast(a);
        }
        return clone;
    }

    public boolean contains(Object element) {
        for (Object a : elements) {
            if (element.equals(a)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;

            }

        }
        return -1;
    }

    public boolean add(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                if (elements.length == size) {
                    ensureCapa();
                }
                elements[size++] = element;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }
    public void set(int index){

    }
}

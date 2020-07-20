package bai_hoc.java_collection_framework.bai_tap.duyet_theo_thu_tu_preorder;

public interface Tree<E> {
    void preOrder();
    int getSize();
    boolean insert(E e);
}

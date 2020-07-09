package dsa_danh_sach.bai_tap;
//Trả về 1 danh sách
public interface MyList<E> extends java.lang.Iterable<E> {
    //nối 1 phần tử vào cuối danh sách
    public void add(E e);

// chèn 1 phần tử tùy í
    public void add(int index, E e);

//loại bỏ tất cả các yếu ra khỏi danh sách
    public void clear();

//trả về true nếu danh sách này chứa phần tử đã chỉ định
    public boolean contains(E e);

//trả về 1 p.tử có vị trí nhất định
    public E get(int index);

//trả về chỉ số của 1 p.tử (nếu có nhiều thì trả về vị trí đầu)
    public int indexOf(E e);

//trả về true nếu danh sách này không chứa bất kỳ phần tử nào
    public boolean isEmpty();

//trả về chỉ số của 1 p.tử (nếu có nhiều thì trả về vị trí cuối)
    public int lastIndexOf(E e);

    //
    public boolean remove(E e);

    public E remove(int index);

    public Object set(int index, E e);

    public int size();
}
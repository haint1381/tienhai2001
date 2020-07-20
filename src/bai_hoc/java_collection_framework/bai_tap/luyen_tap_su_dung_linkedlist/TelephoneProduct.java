package bai_hoc.java_collection_framework.bai_tap.luyen_tap_su_dung_linkedlist;

public class TelephoneProduct {
    private String name;
    private int id;
    private double price;
    public TelephoneProduct() {
    }
    public TelephoneProduct(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TelephoneProduct{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}

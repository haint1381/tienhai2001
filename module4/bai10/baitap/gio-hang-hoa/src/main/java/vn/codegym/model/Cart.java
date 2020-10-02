package vn.codegym.model;


import org.springframework.stereotype.Component;

@Component
public class Cart {
    private FlowerProducts product;
    private int quantity;

    public Cart() {
    }

    public Cart(FlowerProducts product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public FlowerProducts getProduct() {
        return product;
    }

    public void setProduct(FlowerProducts product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

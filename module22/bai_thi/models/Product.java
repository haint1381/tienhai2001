package bai_thi.models;

public abstract class  Product {
    private int id;
    private String productCode;
    private String name;
    private String price;
    private String amount;
    private String producer;

    public Product(int id, String productCode, String name, String price, String amount, String producer) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.producer = producer;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public abstract String showInfor();
}

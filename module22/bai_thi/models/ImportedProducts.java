package bai_thi.models;

import bai_thi.models.Product;

public class ImportedProducts extends Product {
    private String importPrices;
    private String province;
    private String importTax;

    public ImportedProducts(int id, String productCode, String name, String price, String amount, String producer, String importPrices, String province, String importTax) {
        super(id, productCode, name, price, amount, producer);
        this.importPrices = importPrices;
        this.province = province;
        this.importTax = importTax;
    }

    public String getImportPrices() {
        return importPrices;
    }

    public void setImportPrices(String importPrices) {
        this.importPrices = importPrices;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getImportTax() {
        return importTax;
    }

    public void setImportTax(String importTax) {
        this.importTax = importTax;
    }

    @Override
    public String showInfor() {
        return "Product{" +
                "id='" + super.getId() + '\'' +
                ", productCode='" + super.getProductCode() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", price='" + super.getPrice() + '\'' +
                ", amount='" + super.getAmount() + '\'' +
                ", producer='" +super.getProducer() + '\'' +
                "ImportedProducts{" +
                "importPrices='" + importPrices + '\'' +
                ", province='" + province + '\'' +
                ", importTax='" + importTax + '\'' +
                '}';
    }
}

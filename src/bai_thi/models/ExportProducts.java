package bai_thi.models;

import bai_thi.models.Product;

public class ExportProducts extends Product {
private String exportOutput;
    private String country;

    public ExportProducts(int id, String productCode, String name, String price, String amount, String producer, String exportOutput, String country) {
        super(id, productCode, name, price, amount, producer);
        this.exportOutput = exportOutput;
        this.country = country;
    }

    public String getExportOutput() {
        return exportOutput;
    }

    public void setExportOutput(String exportOutput) {
        this.exportOutput = exportOutput;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
                "ExportProducts{" +
                "exportOutput='" + exportOutput + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

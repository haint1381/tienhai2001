package com.furama.model;
public class ContractDetail {
    String contract_detail_id;
    String contract_id;
    String attach_service_id;
    String quantity;

    public ContractDetail() {
    }

    public ContractDetail(String contract_detail_id, String contract_id, String attach_service_id, String quantity) {
        this.contract_detail_id = contract_detail_id;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.quantity = quantity;
    }

    public String getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(String contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

    public String getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(String attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

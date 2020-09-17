package com.furama.model;

public class CustomerUsingService {
    String customer_id;
    String customer_name;
    String service_id;
    String service_name;
    String contract_id;
    String attach_service_id;
    String attach_service_name;

    public CustomerUsingService() {
    }

    public CustomerUsingService(String customer_id, String customer_name, String service_id, String service_name, String contract_id, String attach_service_id, String attach_service_name) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.service_id = service_id;
        this.service_name = service_name;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.attach_service_name = attach_service_name;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
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

    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }
}

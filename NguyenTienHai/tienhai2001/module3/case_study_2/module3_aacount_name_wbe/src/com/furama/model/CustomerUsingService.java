package com.furama.model;

public class CustomerUsingService {
    int customer_id;
    String customer_name;
    int service_id;
    String service_name;
    int contract_id;
    int attach_service_id;
    String attach_service_name;

    public CustomerUsingService() {
    }

    public CustomerUsingService(int customer_id, String customer_name, int service_id, String service_name, int contract_id, int attach_service_id, String attach_service_name) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.service_id = service_id;
        this.service_name = service_name;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.attach_service_name = attach_service_name;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(int attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }
}

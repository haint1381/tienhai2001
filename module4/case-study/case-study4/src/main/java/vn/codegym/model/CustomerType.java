package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CustomerType {
    @Id
    private String customerTypeId;
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerType() {
    }

    public String getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}

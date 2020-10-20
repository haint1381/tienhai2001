package vn.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table
public class Service {
    @Id
    @Pattern(regexp = "^DV-\\d{4}$",message = "The Service code is not in the correct format")
    private String serviceId;
    private String serviceName;
    @Pattern(regexp =  "^[-]*\\d+([.]\\d+)?$",message = "The Service Area  is not in the correct format")
    private String serviceArea;

    @Pattern(regexp =  "^[-]*\\d+([.]\\d+)?$",message = "The Service Cost  is not in the correct format")
    private String serviceCost;
    @Pattern(regexp =  "^[-]*\\d+$",message = "The Service Max People  is not in the correct format")
    private String serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;

    @Pattern(regexp =  "^[-]*\\d+([.]\\d+)?$",message = "The Pool Area  is not in the correct format")
    private String poolArea;
    @Pattern(regexp =  "^[-]*\\d+$",message = "The Number Of Floors  is not in the correct format")
    private String numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "serviceTypeId")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rentTypeId")
    private RentType rentType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Service() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }


    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}

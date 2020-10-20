package vn.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table
public class ContractDetail {
    @Id
    String contractDetailId;
    @Pattern(regexp =  "^[-]*\\d+$",message = "The quantity  is not in the correct format")
    String quantity;

    public ContractDetail() {
    }
    @ManyToOne
    @JoinColumn(name = "attachServiceId")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contractId")
    private Contract contract;

    public String getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(String contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}

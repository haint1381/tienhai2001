package vn.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table
public class Employee {
    @Id
    private String employeeId;
    private  String employeeName;
    private String employeeBirthday;
    @Pattern(regexp = "^\\d{9}$",message = "The id Card  is not in the correct format")
    private String employeeIdCard;
    @Pattern(regexp =  "^[-]*\\d+([.]\\d+)?$",message = "The Employee Salary  is not in the correct format")
    private  String employeeSalary;
    @Pattern(regexp =  "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$",message = "The phone  is not in the correct format")
    private String employeePhone;
    @Pattern(regexp =  "^(\\w{3,}@\\w+\\.\\w+)$",message = "The email  is not in the correct format")
    private String employeeEmail;
    private String employeeAddress;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;

    @ManyToOne()
    @JoinColumn(name = "educationDegreeId")
    private  EducationDegree educationDegree;

    @ManyToOne()
    @JoinColumn(name = "divisionId")
    private  Division division;

    @ManyToOne()
    @JoinColumn(name = "username")
    private UserEmployee username;

    public UserEmployee getUsername() {
        return username;
    }

    public void setUsername(UserEmployee username) {
        this.username = username;
    }

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }


}

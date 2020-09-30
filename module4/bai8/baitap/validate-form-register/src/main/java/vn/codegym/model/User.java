package vn.codegym.model;



import javax.validation.constraints.*;


public class User {


    private int idUser;
    @NotEmpty
    @Size(min = 5,max = 45)
    private String nameUser;
    @NotEmpty
    @Min(value = 18,message = "is greater than 18")
    private String age;

    @NotEmpty
    @Pattern(regexp = "^(0\\d{9})$",message = "Phone number format is incorrect")
    private String number;
    @NotEmpty
    @Email(message = "Email format is incorrect")
    private String email;

    public User() {
    }

    public User(int idUser, String nameUser, String age, String number, String email) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.age = age;
        this.number = number;
        this.email = email;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

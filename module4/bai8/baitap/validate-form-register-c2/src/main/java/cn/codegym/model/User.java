package cn.codegym.model;



import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;

    private String nameUser;

    private String age;

    private String number;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
       if(user.nameUser.isEmpty()){
            errors.rejectValue("common","common.validate");
        }else if((user.nameUser.length()<5 || user.nameUser.length()>45) ){
            errors.rejectValue("nameUser","nameUser.range");
        }
        if(user.age.isEmpty()){
            errors.rejectValue("common","common.validate");
        }else if(Integer.parseInt(user.age)<18){
            errors.rejectValue("age","age.notBeHon18");
        }
        if(user.number.isEmpty()){
            errors.rejectValue("common","common.validate");
        }else if(!user.number.matches("(^0\\d{9}$)")) {
            errors.rejectValue("number","number.notNumber");
        }
         if(user.email.isEmpty()){
            errors.rejectValue("common","common.validate");
        }else if(!user.email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            errors.rejectValue("email","email.notEmail");
        }
    }
}

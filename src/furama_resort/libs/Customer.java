package furama_resort.libs;


import furama_resort.models.Services;


public class Customer {
    private String name;
    private String birthday;
    private String gender;
    private String id;
    private String telephone;
    private String email;
    private String kindOfGuests;
    private String address;
    private final String flag="4";
    private  Services services;

    public Customer(String name, String birthday, String gender, String id, String telephone, String email, String kindOfGuests, String address, Services services,String flag) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id = id;
        this.telephone = telephone;
        this.email = email;
        this.kindOfGuests = kindOfGuests;
        this.address = address;
        this.services = services;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKindOfGuests() {
        return kindOfGuests;
    }

    public void setKindOfGuests(String kindOfGuests) {
        this.kindOfGuests = kindOfGuests;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public  void setServices(Services services) {

         this.services=services;
    }

    public String showInfor() {
        return "Customer:" + "\n" +
                "1.Name: " + this.name + "\n" +
                "2.Birthday: " + this.birthday + "\n" +
                "3.Gender: '" + this.gender + "\n" +
                "4.Id: " + this.id + "\n" +
                "5.Telephone: " + this.telephone + "\n" +
                "6.Email: " + this.email + "\n" +
                "7.Kind Of Guests: " + this.kindOfGuests + "\n" +
                "8.Address: " + this.address + "\n" +
                "9.Services: " + this.services;
    }
}

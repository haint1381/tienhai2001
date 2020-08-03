package furama_resort.libs;

public class Employee {
    private String name;
    private String age;
    private String adreess;

    public Employee() {
    }

    public Employee(String name, String age, String adreess) {
        this.name = name;
        this.age = age;
        this.adreess = adreess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdreess() {
        return adreess;
    }

    public void setAdreess(String adreess) {
        this.adreess = adreess;
    }

    @Override
    public String toString() {
        return "Employee:"+"\n"+
                "1.Name: " + name + "\n"+
                "2.Age: " + age + "\n"+
                "3.Adreess: " + adreess;
    }
}

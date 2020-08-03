package furama_resort.libs;

public class AccompaniedService {
    private String name;
    private int Unit;
    private double price;
    public AccompaniedService() {
    }

    public AccompaniedService(String name, int unit, double price) {
        this.name = name;
        Unit = unit;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return Unit;
    }

    public void setUnit(int unit) {
        Unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AccompaniedService:" +"\n"+
                "Name: " + name  +"\n"+
                "Unit: " + Unit +"\n"+
                "Price: " + price;
    }
}
